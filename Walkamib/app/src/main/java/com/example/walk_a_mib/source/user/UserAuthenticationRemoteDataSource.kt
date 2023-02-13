package com.example.walk_a_mib.source.user

import android.util.Log
import com.example.walk_a_mib.model.user.User
import com.example.walk_a_mib.source.user.BaseUserAuthenticationRemoteDataSource
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.example.walk_a_mib.source.user.UserAuthenticationRemoteDataSource
import com.example.walk_a_mib.util.Constants.INVALID_CREDENTIALS_ERROR
import com.example.walk_a_mib.util.Constants.INVALID_USER_ERROR
import com.example.walk_a_mib.util.Constants.UNEXPECTED_ERROR
import com.example.walk_a_mib.util.Constants.USER_COLLISION_ERROR
import com.example.walk_a_mib.util.Constants.WEAK_PASSWORD_ERROR
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import java.lang.Exception

/**
 * Class that manages the user authentication using Firebase Authentication.
 */
class UserAuthenticationRemoteDataSource : BaseUserAuthenticationRemoteDataSource() {
    private val firebaseAuth: FirebaseAuth

    init {
        firebaseAuth = FirebaseAuth.getInstance()
    }

    override fun getLoggedUser(): User? {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null) {
            return User(
                firebaseUser.displayName,
                firebaseUser.email,
                firebaseUser.uid
            )
        } else
            return null
    }

    override fun logout() {
        val authStateListener: AuthStateListener = object : AuthStateListener {
            override fun onAuthStateChanged(firebaseAuth: FirebaseAuth) {
                if (firebaseAuth.currentUser == null) {
                    firebaseAuth.removeAuthStateListener(this)
                    Log.d(TAG, "User logged out")
                    userResponseCallback?.onSuccessLogout()
                }
            }
        }
        firebaseAuth.addAuthStateListener(authStateListener)
        firebaseAuth.signOut()
    }

    override fun signUp(email: String?, password: String?) {
        if (email != null && password != null) {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task: Task<AuthResult?> ->
                    if (task.isSuccessful) {
                        val firebaseUser = firebaseAuth.currentUser
                        if (firebaseUser != null) {
                            Log.d("CREATED", "User created: $email")
                            userResponseCallback?.onSuccessFromAuthentication(
                                User(
                                    firebaseUser.displayName, email, firebaseUser.uid
                                )
                            )
                        } else {
                            userResponseCallback?.onFailureFromAuthentication(getErrorMessage(task.exception))
                        }
                    } else {
                        userResponseCallback?.onFailureFromAuthentication(getErrorMessage(task.exception))
                    }
                }
        }
    }

    override fun signIn(email: String?, password: String?) {
        if (email != null && password != null) {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task: Task<AuthResult?> ->
                    if (task.isSuccessful) {
                        val firebaseUser = firebaseAuth.currentUser
                        if (firebaseUser != null) {
                            userResponseCallback?.onSuccessFromAuthentication(
                                User(
                                    firebaseUser.displayName, email, firebaseUser.uid
                                )
                            )
                        } else {
                            userResponseCallback?.onFailureFromAuthentication(getErrorMessage(task.exception))
                        }
                    } else {
                        userResponseCallback?.onFailureFromAuthentication(getErrorMessage(task.exception))
                    }
                }
        }
    }

    override fun signInWithGoogle(idToken: String?) {
        if (idToken != null) {
            // Got an ID token from Google. Use it to authenticate
            // with Firebase.
            val firebaseCredential = GoogleAuthProvider.getCredential(idToken, null)
            firebaseAuth.signInWithCredential(firebaseCredential)
                .addOnCompleteListener { task: Task<AuthResult?> ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "signInWithCredential:success")
                        val firebaseUser = firebaseAuth.currentUser
                        if (firebaseUser != null) {
                            userResponseCallback?.onSuccessFromAuthentication(
                                User(
                                    firebaseUser.displayName, firebaseUser.email,
                                    firebaseUser.uid
                                )
                            )
                        } else {
                            userResponseCallback?.onFailureFromAuthentication(
                                getErrorMessage(task.exception)
                            )
                        }
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "signInWithCredential:failure", task.exception)
                        userResponseCallback?.onFailureFromAuthentication(getErrorMessage(task.exception))
                    }
                }
        }
    }

    override fun sendPasswordResetEmail(email: String?) {
        if (email != null) {
            Log.d("RESET", "Sending password reset email to $email...")
            firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener { task: Task<Void?> ->
                if (task.isSuccessful) {
                    Log.d("RESET", "Email sent.")
                    userResponseCallback?.onSuccessFromPasswordReset()
                } else {
                    Log.d("RESET", "Email not sent.")
                    userResponseCallback?.onFailureFromPasswordReset(getErrorMessage(task.exception))
                }
            }
        }
    }

    private fun getErrorMessage(exception: Exception?): String {
        if (exception is FirebaseAuthWeakPasswordException) {
            return WEAK_PASSWORD_ERROR
        } else if (exception is FirebaseAuthInvalidCredentialsException) {
            return INVALID_CREDENTIALS_ERROR
        } else if (exception is FirebaseAuthInvalidUserException) {
            return INVALID_USER_ERROR
        } else if (exception is FirebaseAuthUserCollisionException) {
            return USER_COLLISION_ERROR
        }
        return UNEXPECTED_ERROR
    }

    companion object {
        private val TAG = UserAuthenticationRemoteDataSource::class.java.simpleName
    }
}