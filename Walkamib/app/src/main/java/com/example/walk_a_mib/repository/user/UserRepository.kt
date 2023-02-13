package com.example.walk_a_mib.repository.user

import com.example.walk_a_mib.source.user.BaseUserAuthenticationRemoteDataSource
import androidx.lifecycle.MutableLiveData
import com.example.walk_a_mib.model.Result
import com.example.walk_a_mib.model.Result.UserResponseSuccess
import com.example.walk_a_mib.model.user.User

/**
 * Repository class to get the user information.
 */
class UserRepository(
    private val userRemoteDataSource: BaseUserAuthenticationRemoteDataSource,
) : IUserRepository, UserResponseCallback {
    private val userMutableLiveData: MutableLiveData<Result?>

    init {
        userMutableLiveData = MutableLiveData()
        userRemoteDataSource.setUserResponseCallback(this)
    }

    override fun getUser(
        email: String?,
        password: String?,
        isUserRegistered: Boolean
    ): MutableLiveData<Result?>? {
        if (isUserRegistered) {
            signIn(email, password)
        } else {
            signUp(email, password)
        }
        return userMutableLiveData
    }

    override fun getGoogleUser(idToken: String?): MutableLiveData<Result?>? {
        signInWithGoogle(idToken)
        return userMutableLiveData
    }

    override val loggedUser: User?
        get() = userRemoteDataSource.getLoggedUser()

    override fun logout(): MutableLiveData<Result?>? {
        userRemoteDataSource.logout()
        return userMutableLiveData
    }

    override fun signUp(email: String?, password: String?) {
        userRemoteDataSource.signUp(email, password)
    }

    override fun signIn(email: String?, password: String?) {
        userRemoteDataSource.signIn(email, password)
    }

    override fun signInWithGoogle(token: String?) {
        userRemoteDataSource.signInWithGoogle(token)
    }

    override fun sendPasswordResetEmail(email: String?) {
        userRemoteDataSource.sendPasswordResetEmail(email)
    }

    override fun onSuccessFromAuthentication(user: User?) {
        if (user != null) {
            val result = UserResponseSuccess(user)
            userMutableLiveData.postValue(result)
        }
    }

    override fun onFailureFromAuthentication(message: String?) {
        if (message != null){
            val result = Result.Error(message)
            userMutableLiveData.postValue(result)
        }
    }

    override fun onSuccessFromRemoteDatabase(user: User?) {
        if (user != null) {
            val result = UserResponseSuccess(user)
            userMutableLiveData.postValue(result)
        }
    }

    override fun onFailureFromRemoteDatabase(message: String?) {
        if (message != null) {
            val result = Result.Error(message)
            userMutableLiveData.postValue(result)
        }
    }

    override fun onSuccessLogout() {}
    override fun onSuccessFromPasswordReset() {}
    override fun onFailureFromPasswordReset(message: String?) {
        if (message != null) {
            val result = Result.Error(message)
            userMutableLiveData.postValue(result)
        }
    }

    companion object {
        private val TAG = UserRepository::class.java.simpleName
    }
}