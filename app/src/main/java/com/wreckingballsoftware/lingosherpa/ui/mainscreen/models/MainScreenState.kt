package com.wreckingballsoftware.lingosherpa.ui.mainscreen.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Locale

@Parcelize
data class MainScreenState(
    val dropdownExpanded: Boolean = false,
    val selectedLanguage: String = "",
    val languages: List<Locale> = emptyList(),
    val textToTranslate: String = "",
    val translatedText: String = "",
    val errorMessage: String? = null,
    val displaySpinner: Boolean = false,
) : Parcelable
