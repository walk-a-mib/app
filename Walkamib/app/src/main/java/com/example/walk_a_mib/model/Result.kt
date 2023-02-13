package com.example.walk_a_mib.model

import com.example.walk_a_mib.model.Result.UserResponseSuccess
import com.example.walk_a_mib.model.user.User

/**
 * Class that represents the result of an action that requires
 * the use of a Web Service or a local database.
 */
abstract class Result private constructor() {
    val isSuccess: Boolean
        get() = if (this is UserResponseSuccess) {
            true
        } else {
            false
        }

    /**
     * Class that represents a successful action during the interaction
     * with a Web Service or a local database.
     */
    class UserResponseSuccess(val data: User) : Result()

    /**
     * Class that represents an error occurred during the interaction
     * with a Web Service or a local database.
     */
    class Error(val message: String) : Result()
}