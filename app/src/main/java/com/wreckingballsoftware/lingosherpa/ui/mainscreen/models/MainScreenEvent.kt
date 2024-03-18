package com.wreckingballsoftware.lingosherpa.ui.mainscreen.models

import java.util.Locale

sealed interface MainScreenEvent {
    data class SetLanguages(val languages: List<Locale>) : MainScreenEvent
    data class ExpandedChanged(val expanded: Boolean) : MainScreenEvent
    data object DismissDropdown : MainScreenEvent
    data class LanguageSelected(val language: Locale) : MainScreenEvent
    data class TextToTranslateChanged(val text: String) : MainScreenEvent
    data object TranslateButtonClicked : MainScreenEvent
    data object DismissAlert : MainScreenEvent
    data object SpeakTranslationClicked : MainScreenEvent
}