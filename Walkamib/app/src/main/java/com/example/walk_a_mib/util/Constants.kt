package com.example.walk_a_mib.util

object Constants {
    val FRESH_TIMEOUT: Int = 60*60*1000
    val RETROFIT_ERROR : String = "retrofit_error"
    val API_BASE_URL : String = "https://walkamib.azurewebsites.net/api/"

    // Constants for managing errors
    const val API_KEY_ERROR = "api_key_error"
    const val UNEXPECTED_ERROR = "unexpected_error"
    const val INVALID_USER_ERROR = "invalidUserError"
    const val INVALID_CREDENTIALS_ERROR = "invalidCredentials"
    const val USER_COLLISION_ERROR = "userCollisionError"
    const val WEAK_PASSWORD_ERROR = "passwordIsWeak"

    const val MINIMUM_PASSWORD_LENGTH = 6

    const val FIREBASE_USERS_COLLECTION = "users"
}