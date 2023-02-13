package com.example.walk_a_mib.repository.user;

//import com.example.walk_a_mib.model.News;
import com.example.walk_a_mib.model.user.User;

public interface UserResponseCallback {
    void onSuccessFromAuthentication(User user);
    void onFailureFromAuthentication(String message);
    void onSuccessFromRemoteDatabase(User user);
    void onFailureFromRemoteDatabase(String message);
    void onSuccessLogout();
    void onSuccessFromPasswordReset();
    void onFailureFromPasswordReset(String message);
}
