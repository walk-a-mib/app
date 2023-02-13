package com.example.walk_a_mib.repository.user

import com.example.walk_a_mib.model.user.User

interface UserResponseCallback {
    fun onSuccessFromAuthentication(user: User?)
    fun onFailureFromAuthentication(message: String?)
    fun onSuccessFromRemoteDatabase(user: User?)
    fun onFailureFromRemoteDatabase(message: String?)
    fun onSuccessLogout()
    fun onSuccessFromPasswordReset()
    fun onFailureFromPasswordReset(message: String?)
}