package com.example.walk_a_mib.repository.user;

import androidx.lifecycle.MutableLiveData;

import com.example.walk_a_mib.model.Result;
import com.example.walk_a_mib.model.user.User;
import com.example.walk_a_mib.source.user.BaseUserAuthenticationRemoteDataSource;
import com.example.walk_a_mib.source.user.BaseUserDataRemoteDataSource;

/**
 * Repository class to get the user information.
 */
public class UserRepository implements IUserRepository, UserResponseCallback
{

    private static final String TAG = UserRepository.class.getSimpleName();

    private final BaseUserAuthenticationRemoteDataSource userRemoteDataSource;
    private final BaseUserDataRemoteDataSource userDataRemoteDataSource;

    private final MutableLiveData<Result> userMutableLiveData;

    public UserRepository(BaseUserAuthenticationRemoteDataSource userRemoteDataSource,
                          BaseUserDataRemoteDataSource userDataRemoteDataSource
    ) {
        this.userRemoteDataSource = userRemoteDataSource;
        this.userDataRemoteDataSource = userDataRemoteDataSource;

        this.userMutableLiveData = new MutableLiveData<>();

        this.userRemoteDataSource.setUserResponseCallback(this);
        this.userDataRemoteDataSource.setUserResponseCallback(this);
    }

    @Override
    public MutableLiveData<Result> getUser(String email, String password, boolean isUserRegistered) {
        if (isUserRegistered) {
            signIn(email, password);
        } else {
            signUp(email, password);
        }
        return userMutableLiveData;
    }

    @Override
    public MutableLiveData<Result> getGoogleUser(String idToken) {
        signInWithGoogle(idToken);
        return userMutableLiveData;
    }

    @Override
    public User getLoggedUser() {
        return userRemoteDataSource.getLoggedUser();
    }

    @Override
    public MutableLiveData<Result> logout() {
        userRemoteDataSource.logout();
        return userMutableLiveData;
    }

    @Override
    public void signUp(String email, String password) {
        userRemoteDataSource.signUp(email, password);
    }

    @Override
    public void signIn(String email, String password) {
        userRemoteDataSource.signIn(email, password);
    }

    @Override
    public void signInWithGoogle(String token) {
        userRemoteDataSource.signInWithGoogle(token);
    }

    @Override
    public void sendPasswordResetEmail(String email) {
        userRemoteDataSource.sendPasswordResetEmail(email);
    }

    @Override
    public void onSuccessFromAuthentication(User user) {
        if (user != null) {
            Result.UserResponseSuccess result = new Result.UserResponseSuccess(user);
            userMutableLiveData.postValue(result);
        }
    }

    @Override
    public void onFailureFromAuthentication(String message) {
        Result.Error result = new Result.Error(message);
        userMutableLiveData.postValue(result);
    }

    @Override
    public void onSuccessFromRemoteDatabase(User user) {
        Result.UserResponseSuccess result = new Result.UserResponseSuccess(user);
        userMutableLiveData.postValue(result);
    }

    @Override
    public void onFailureFromRemoteDatabase(String message) {
        Result.Error result = new Result.Error(message);
        userMutableLiveData.postValue(result);
    }

    @Override
    public void onSuccessLogout() {
    }

    @Override
    public void onSuccessFromPasswordReset() {

    }

    @Override
    public void onFailureFromPasswordReset(String message) {
        Result.Error result = new Result.Error(message);
        userMutableLiveData.postValue(result);
    }

}

