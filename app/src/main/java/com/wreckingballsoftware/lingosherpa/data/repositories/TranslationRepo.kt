package com.wreckingballsoftware.lingosherpa.data.repositories

import android.speech.tts.TextToSpeech
import com.wreckingballsoftware.lingosherpa.data.models.NetworkResponse
import com.wreckingballsoftware.lingosherpa.data.models.TranslationRequest
import com.wreckingballsoftware.lingosherpa.data.models.TranslationResponse
import com.wreckingballsoftware.lingosherpa.data.models.toNetworkErrorResponse
import com.wreckingballsoftware.lingosherpa.data.network.TranslationService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.util.Locale

class TranslationRepo(
    private val translationService: TranslationService
) {
    fun getTranslationLocales(tts: TextToSpeech): List<Locale> {
//        val languages = tts.availableLanguages
//            .toList()
//            .distinctBy { it.language }
//            .sortedBy { it.displayLanguage }
        val languages = Locale.getAvailableLocales().toList().distinctBy { it.language }.sortedBy { it.displayLanguage }
        return languages.filter { translationLanguageCodes.contains(it.language) }
    }

    suspend fun getTranslation(
        targetLanguage: String,
        request: TranslationRequest,
    ): NetworkResponse<TranslationResponse> = withContext(Dispatchers.IO) {
        try {
            NetworkResponse.Success(
                translationService.getTranslation(
                    targetLanguage = targetLanguage,
                    request = request
                )
            )
        } catch (ex: HttpException) {
            ex.toNetworkErrorResponse()
        } catch (ex: Exception) {
            NetworkResponse.Error.UnknownNetworkError(ex)
        }
    }
}