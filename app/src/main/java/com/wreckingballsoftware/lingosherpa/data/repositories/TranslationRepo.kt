package com.wreckingballsoftware.lingosherpa.data.repositories

import com.wreckingballsoftware.lingosherpa.data.models.NetworkResponse
import com.wreckingballsoftware.lingosherpa.data.models.TranslationRequest
import com.wreckingballsoftware.lingosherpa.data.models.TranslationResponse
import com.wreckingballsoftware.lingosherpa.data.models.toNetworkErrorResponse
import com.wreckingballsoftware.lingosherpa.data.network.TranslationService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

class TranslationRepo(
    private val translationService: TranslationService
) {
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