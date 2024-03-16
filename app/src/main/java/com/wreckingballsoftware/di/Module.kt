package com.wreckingballsoftware.di

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import com.wreckingballsoftware.lingosherpa.ui.mainscreen.MainScreenViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val _ttsReady = MutableStateFlow(false)
val ttsReady: StateFlow<Boolean> = _ttsReady

val appModule = module {
    viewModel {
        MainScreenViewModel(
            get(),
            provideTextToSpeech(get()),
        )
    }
}

fun provideTextToSpeech(context: Context): TextToSpeech {
    return TextToSpeech(context) { status ->
        if (status == TextToSpeech.ERROR) {
            Log.e("TextToSpeech", "Error initializing TextToSpeech")
        } else {
            _ttsReady.value = true
        }
    }
}