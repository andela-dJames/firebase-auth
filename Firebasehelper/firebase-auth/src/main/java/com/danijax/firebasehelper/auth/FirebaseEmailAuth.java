package com.danijax.firebasehelper.auth;

import android.content.Context;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by danieljames on 2/25/16.
 */
public class FirebaseEmailAuth<T> implements FireBaseAuth{

    private String firebaseUrl;

    private Context context;

    private Firebase firebase;

    public FirebaseEmailAuth(Context context, String firebaseUrl) {
        this.context = context;
        this.firebaseUrl = firebaseUrl;
        firebase = new Firebase(firebaseUrl);
    }

    @Override
    public void signInWithEmail(String email, String password, final AuthCallback callback) {

        firebase.authWithPassword(email, password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                callback.onSuccess(authData);
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {

                callback.onError(firebaseError.toString());

            }
        });

    }

    @Override
    public void signUpWithEmail(String email, String password, final AuthCallback callback) {
        firebase.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> stringObjectMap) {
                callback.onSuccess(stringObjectMap);
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                callback.onError(firebaseError.toString());

            }
        });

    }

    @Override
    public void signOut() {
        firebase.unauth();

    }

    @Override
    public void removeAccount(String email, String password, final AuthCallback callback) {
        firebase.removeUser(email, password, new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError(FirebaseError firebaseError) {

                callback.onError(firebaseError.toString());

            }
        });
    }
}
