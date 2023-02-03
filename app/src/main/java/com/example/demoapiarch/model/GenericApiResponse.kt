package com.example.demoapiarch.model

data class GenericApiResponse<T>(val status: String, val responseBody: T)