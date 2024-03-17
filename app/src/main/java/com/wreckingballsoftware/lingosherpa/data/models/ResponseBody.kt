package com.wreckingballsoftware.lingosherpa.data.models

data class ResponseBody(
    val detectedLanguage: DetectedLanguage = DetectedLanguage(),
    val translations: List<Translation> = emptyList(),
)
