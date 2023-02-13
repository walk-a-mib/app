package com.example.walk_a_mib.model

data class GenericApiResponse<T>(val status: String, val responseBody: T)