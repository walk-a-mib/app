package com.example.walk_a_mib.source.user;


import com.example.walk_a_mib.model.user.User;
import com.example.walk_a_mib.repository.user.UserResponseCallback;

/**
 * Base class to get the user data from a remote source.
 */
public abstract class BaseUserDataRemoteDataSource {
    protected UserResponseCallback userResponseCallback;

    public void setUserResponseCallback(UserResponseCallback userResponseCallback) {
        this.userResponseCallback = userResponseCallback;
    }

    public abstract void saveUserData(User user);
//    public abstract void getUserFavoriteNews(String idToken);
//    public abstract void getUserPreferences(String idToken);
//    public abstract void saveUserPreferences(String favoriteCountry, Set<String> favoriteTopics, String idToken);
}
