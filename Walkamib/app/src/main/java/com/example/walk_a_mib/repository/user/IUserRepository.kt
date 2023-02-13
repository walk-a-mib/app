package com.example.walk_a_mib.repository.user

import androidx.lifecycle.MutableLiveData
import com.example.walk_a_mib.model.Result
import com.example.walk_a_mib.model.user.User

interface IUserRepository {
    fun getUser(
        email: String?,
        password: String?,
        isUserRegistered: Boolean
    ): MutableLiveData<Result?>?

    fun getGoogleUser(idToken: String?): MutableLiveData<Result?>?
    fun logout(): MutableLiveData<Result?>?
    val loggedUser: User?
    fun signUp(email: String?, password: String?)
    fun signIn(email: String?, password: String?)
    fun signInWithGoogle(token: String?)
    fun sendPasswordResetEmail(email: String?)
}