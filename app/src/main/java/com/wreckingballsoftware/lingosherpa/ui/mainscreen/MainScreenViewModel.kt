package com.wreckingballsoftware.lingosherpa.ui.mainscreen

import android.speech.tts.TextToSpeech
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import com.wreckingballsoftware.di.ttsReady
import com.wreckingballsoftware.lingosherpa.ui.mainscreen.models.MainScreenEvent
import com.wreckingballsoftware.lingosherpa.ui.mainscreen.models.MainScreenState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainScreenViewModel(
    handle: SavedStateHandle,
    private val tts: TextToSpeech,
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
                state = state.copy(displaySpinner = true)
                translateText()
            }
            is MainScreenEvent.DisplayTranslation -> {
                state = state.copy(translatedText = state.textToTranslate, displaySpinner = false)
            }
            MainScreenEvent.SpeakTranslationClicked -> {
                speakTranslation()
            }
        }
    }

    private fun translateText() {
        eventHandler(MainScreenEvent.DisplayTranslation(state.textToTranslate))
    }

    private fun speakTranslation() {
        tts.speak(state.translatedText, TextToSpeech.QUEUE_FLUSH, null, "id")
    }
}