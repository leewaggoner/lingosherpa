package com.wreckingballsoftware.lingosherpa.ui.mainscreen.models

sealed interface MainScreenEvent {
    data class TextToTranslateChanged(val text: String) : MainScreenEvent
    data object TranslateButtonClicked : MainScreenEvent
    data class DisplayTranslation(val translatedText: String) : MainScreenEvent
    data object SpeakTranslationClicked : MainScreenEvent
}