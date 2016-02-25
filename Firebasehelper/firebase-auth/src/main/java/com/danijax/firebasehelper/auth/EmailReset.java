package com.danijax.firebasehelper.auth;

/**
 * Created by danieljames on 2/25/16.
 */
public interface EmailReset {

    void sendResetEmail(String oldEmail, AuthCallback callback);
    void changeEmail(String oldEmail, String newEmail, String password, AuthCallback callback);
    void resetPassword(String email, String oldPassword, String password, AuthCallback callback);
}
