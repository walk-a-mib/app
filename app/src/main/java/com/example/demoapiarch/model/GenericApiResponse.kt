package com.example.demoapiarch.model

class GenericApiResponse<T>(val status: String, val responseBody: T) {
}