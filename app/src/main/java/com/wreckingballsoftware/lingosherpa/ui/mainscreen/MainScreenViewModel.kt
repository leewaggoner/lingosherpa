package com.wreckingballsoftware.lingosherpa.ui.mainscreen

import android.speech.tts.TextToSpeech
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import com.wreckingballsoftware.lingosherpa.R
import com.wreckingballsoftware.lingosherpa.data.models.NetworkResponse
import com.wreckingballsoftware.lingosherpa.data.models.RequestBody
import com.wreckingballsoftware.lingosherpa.data.models.TranslationRequest
import com.wreckingballsoftware.lingosherpa.data.models.TranslationResponse
import com.wreckingballsoftware.lingosherpa.data.repositories.TranslationRepo
import com.wreckingballsoftware.lingosherpa.di.ttsReady
import com.wreckingballsoftware.lingosherpa.domain.ApiResult
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
                    val languages = translationRepo.getTranslationLocales(tts)
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
                val available = tts.isLanguageAvailable(event.language)
                if (available == TextToSpeech.LANG_MISSING_DATA || available == TextToSpeech.LANG_NOT_SUPPORTED) {
                    state = state.copy(alertMessageId = R.string.install_language)
                }
                state = state.copy(selectedLanguage = event.language, dropdownExpanded = false)
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
            MainScreenEvent.DismissAlert -> {
                state = state.copy(errorMessage = null, errorMessageId = null, alertMessageId = null)
            }
        }
    }

    private fun translateText() {
        if (state.textToTranslate.isEmpty()) {
            state = state.copy(errorMessageId = R.string.enter_text)
            return
        }

        state.selectedLanguage?.let { locale ->
            state = state.copy(displaySpinner = true)
            viewModelScope.launch(Dispatchers.Main) {
                val result = translationRepo.getTranslation(
                    targetLanguage = locale.language,
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
    }

    private fun speakTranslation() {
        if (state.translatedText.isNotEmpty()) {
            if (tts.isLanguageAvailable(state.selectedLanguage) == TextToSpeech.LANG_MISSING_DATA) {
                state = state.copy(alertMessageId = R.string.install_language)
                return
            }
            tts.language = state.selectedLanguage
            state.selectedLanguage?.let { locale ->
                if (
                    tts.speak(
                        state.translatedText,
                        TextToSpeech.QUEUE_FLUSH,
                        null,
                        "utteranceId"
                    )  == TextToSpeech.ERROR
                ) {
                    state = state.copy(errorMessageId = R.string.speaking_error)
                } else {
                    Log.d("MainScreenViewModel", "Speaking translation: ${state.selectedLanguage?.displayLanguage}")
                }
            }
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
