package com.wreckingballsoftware.lingosherpa.ui.mainscreen

import android.speech.tts.TextToSpeech
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import com.wreckingballsoftware.data.models.NetworkResponse
import com.wreckingballsoftware.data.models.RequestBody
import com.wreckingballsoftware.data.models.TranslationRequest
import com.wreckingballsoftware.data.models.TranslationResponse
import com.wreckingballsoftware.data.repositories.TranslationRepo
import com.wreckingballsoftware.di.ttsReady
import com.wreckingballsoftware.domain.ApiResult
import com.wreckingballsoftware.lingosherpa.ui.mainscreen.models.MainScreenEvent
import com.wreckingballsoftware.lingosherpa.ui.mainscreen.models.MainScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainScreenViewModel(
    handle: SavedStateHandle,
    private val tts: TextToSpeech,
    private val translationRepo: TranslationRepo
) : ViewModel() {
    @OptIn(SavedStateHandleSaveableApi::class)
    var state by handle.saveable {
        mutableStateOf(MainScreenState())
    }

    init {
        viewModelScope.launch(Dispatchers.Main) {
            ttsReady.collect { ready ->
                if (ready) {
                    val languages = tts.availableLanguages.toList().sortedBy { it.displayName }
                    eventHandler(MainScreenEvent.SetLanguages(languages))
                }
            }
        }
    }

    fun eventHandler(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.SetLanguages -> {
                state = state.copy(languages = event.languages)
            }
            is MainScreenEvent.LanguageSelected -> {
                tts.language = event.language
                state = state.copy(
                    selectedLanguage = event.language.displayName,
                    dropdownExpanded = false
                )
            }
            MainScreenEvent.DismissDropdown -> {
                state = state.copy(dropdownExpanded = false)
            }
            is MainScreenEvent.ExpandedChanged -> {
                state = state.copy(dropdownExpanded = event.expanded)
            }
            is MainScreenEvent.TextToTranslateChanged -> {
                state = state.copy(textToTranslate = event.text)
            }
            MainScreenEvent.TranslateButtonClicked -> {
                translateText()
                state
            }
            MainScreenEvent.SpeakTranslationClicked -> {
                speakTranslation()
            }
            MainScreenEvent.DismissError -> {
                state = state.copy(errorMessage = null)
            }
        }
    }

    private fun translateText() {
        if (state.textToTranslate.isEmpty()) {
            state = state.copy(errorMessage = "Please enter text to translate")
            return
        }
        state = state.copy(displaySpinner = true)
        viewModelScope.launch(Dispatchers.Main) {
            val result = translationRepo.getTranslation(
                targetLanguage = "id",
                request = TranslationRequest().apply { add(RequestBody(state.textToTranslate)) }
            ).mapToTranslationString()
            state = when (result) {
                is ApiResult.Success -> {
                    state.copy(translatedText = result.data, displaySpinner = false)
                }

                is ApiResult.Error -> {
                    state.copy(errorMessage = result.errorMessage, displaySpinner = false)
                }
            }
        }
    }

    private fun speakTranslation() {
        if (state.translatedText.isNotEmpty()) {
            tts.speak(state.translatedText, TextToSpeech.QUEUE_FLUSH, null, "id")
        }
    }
}

private fun NetworkResponse<TranslationResponse>.mapToTranslationString(): ApiResult<String> {
    return when (this) {
        is NetworkResponse.Success -> {
            if (data.isEmpty()) {
                ApiResult.Error(errorMessage = "No translations found")
            } else {
                if (data[0].translations.isNotEmpty() && data[0].translations[0].text.isNotEmpty()) {
                    ApiResult.Success(data[0].translations[0].text)
                } else {
                    ApiResult.Error(errorMessage = "No translations found")
                }
            }
        }
        is NetworkResponse.Error -> {
            ApiResult.Error(errorMessage = "Error code: ${code}, message: ${exception.localizedMessage}")
        }
    }
}
