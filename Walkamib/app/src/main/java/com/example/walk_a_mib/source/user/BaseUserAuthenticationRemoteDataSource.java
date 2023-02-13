package com.example.walk_a_mib.source.user;


import com.example.walk_a_mib.model.user.User;
import com.example.walk_a_mib.repository.user.UserResponseCallback;

/**
 * Base class to manage the user authentication.
 */
public abstract class BaseUserAuthenticationRemoteDataSource {
    protected UserResponseCallback userResponseCallback;

    public void setUserResponseCallback(UserResponseCallback userResponseCallback) {
        this.userResponseCallback = userResponseCallback;
    }
    public abstract User getLoggedUser();
    public abstract void logout();
    public abstract void signUp(String email, String password);
    public abstract void signIn(String email, String password);
    public abstract void signInWithGoogle(String idToken);
    public abstract void sendPasswordResetEmail(String email);
}
