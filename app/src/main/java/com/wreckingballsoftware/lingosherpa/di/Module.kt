package com.wreckingballsoftware.lingosherpa.di

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import com.wreckingballsoftware.lingosherpa.data.network.TranslationService
import com.wreckingballsoftware.lingosherpa.data.repositories.TranslationRepo
import com.wreckingballsoftware.lingosherpa.BuildConfig
import com.wreckingballsoftware.lingosherpa.ui.mainscreen.MainScreenViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val CONNECT_TIMEOUT = 30L
private const val READ_TIMEOUT = 30L
private const val WRITE_TIMEOUT = 30L

private val _ttsReady = MutableStateFlow(false)
val ttsReady: StateFlow<Boolean> = _ttsReady

val appModule = module {
    viewModel {
        MainScreenViewModel(
            handle = get(),
            tts = provideTextToSpeech(get()),
            translationRepo = get(),
        )
    }

    factory {
        TranslationRepo(
            translationService = get()
        )
    }

    factory<TranslationService> {
        createService(
            retrofit = retrofitService(
                url = BuildConfig.TRANSLATE_URL,
                okHttpClient = okHttp(),
                converterFactory = GsonConverterFactory.create(),
            )
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

inline fun <reified T> createService(retrofit: Retrofit) : T = retrofit.create(T::class.java)

private fun retrofitService(
    url: String,
    okHttpClient: OkHttpClient,
    converterFactory: GsonConverterFactory
) = Retrofit.Builder().apply {
    baseUrl(url)
    client(okHttpClient)
    addConverterFactory(converterFactory)
}.build()

private fun okHttp(authInterceptor: Interceptor? = null) = OkHttpClient.Builder().apply {
    val interceptor = HttpLoggingInterceptor()
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    addInterceptor(interceptor)
    connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
    readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
    connectTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
    retryOnConnectionFailure(true)
    authInterceptor?.let {
        addInterceptor(authInterceptor)
    }
}.build()

