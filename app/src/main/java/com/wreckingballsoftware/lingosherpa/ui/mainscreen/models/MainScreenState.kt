package com.wreckingballsoftware.lingosherpa.ui.mainscreen.models

data class MainScreenState(
    val textToTranslate: String = "",
    val translatedText: String = "",
    val displaySpinner: Boolean = false,
)