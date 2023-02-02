package com.example.walk_a_mib.model

class GenericApiResponse<T>(val status: String, val responseBody: T) {
}