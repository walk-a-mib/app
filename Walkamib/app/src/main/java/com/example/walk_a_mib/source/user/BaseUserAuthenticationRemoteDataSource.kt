package com.example.walk_a_mib.source.user

import com.example.walk_a_mib.model.user.User
import com.example.walk_a_mib.repository.user.UserResponseCallback

/**
 * Base class to manage the user authentication.
 */
abstract class BaseUserAuthenticationRemoteDataSource {
    protected var userResponseCallback: UserResponseCallback? = null
    @JvmName("setUserResponseCallback1")
    fun setUserResponseCallback(userResponseCallback: UserResponseCallback?) {
        this.userResponseCallback = userResponseCallback
    }

    abstract fun getLoggedUser(): User?
    abstract fun logout()
    abstract fun signUp(email: String?, password: String?)
    abstract fun signIn(email: String?, password: String?)
    abstract fun signInWithGoogle(idToken: String?)
    abstract fun sendPasswordResetEmail(email: String?)
}