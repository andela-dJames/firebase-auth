package com.danijax.firebasehelper.auth;

/**
 * Created by danieljames on 2/25/16.
 */
public interface FireBaseAuth<T> {
    void signInWithEmail(String email, String password, AuthCallback callback);
    void signUpWithEmail(String email, String password, AuthCallback callback);
    void signOut();
    void removeAccount(String email, String Password, AuthCallback callback);
}
