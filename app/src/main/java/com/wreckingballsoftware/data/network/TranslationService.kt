package com.wreckingballsoftware.data.network

import com.wreckingballsoftware.data.models.TranslationRequest
import com.wreckingballsoftware.data.models.TranslationResponse
import com.wreckingballsoftware.lingosherpa.BuildConfig
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

interface TranslationService {
    @POST("translate")
    @Headers(
        "Content-Type: application/json",
        "Ocp-Apim-Subscription-Key: ${BuildConfig.TRANSLATE_API_KEY}",
        "Ocp-Apim-Subscription-Region: westus2"
    )
    suspend fun getTranslation(
        @Query("api-version") apiVersion: String = "3.0",
        @Query("to") targetLanguage: String,
        @Body request: TranslationRequest,
    ): TranslationResponse
}