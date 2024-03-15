package com.wreckingballsoftware.lingosherpa.ui.mainscreen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.SavedStateHandleSaveableApi
import androidx.lifecycle.viewmodel.compose.saveable
import com.wreckingballsoftware.lingosherpa.ui.mainscreen.models.MainScreenEvent
import com.wreckingballsoftware.lingosherpa.ui.mainscreen.models.MainScreenState

class MainScreenViewModel(
    handle: SavedStateHandle
) : ViewModel() {
    @OptIn(SavedStateHandleSaveableApi::class)
    var state by handle.saveable {
        mutableStateOf(MainScreenState())
    }

    fun eventHandler(event: MainScreenEvent) {
        when (event) {
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
        //speak the translation
    }
}