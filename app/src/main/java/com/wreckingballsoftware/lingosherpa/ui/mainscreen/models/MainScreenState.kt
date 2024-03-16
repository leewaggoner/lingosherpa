package com.wreckingballsoftware.lingosherpa.ui.mainscreen.models

import java.util.Locale

data class MainScreenState(
    val dropdownExpanded: Boolean = false,
    val selectedLanguage: String = "",
    val languages: List<Locale> = emptyList(),
    val textToTranslate: String = "",
    val translatedText: String = "",
    val displaySpinner: Boolean = false,
)