package com.danijax.firebasehelper.auth;

import android.content.Context;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

/**
 * Created by danieljames on 2/25/16.
 */
public class FirebaseAuthReset implements EmailReset {

    private Firebase firebase;
    private Context context;
    private String firebaseUrl;

    public FirebaseAuthReset(Context context, String firebaseUrl) {
        this.context = context;
        this.firebaseUrl = firebaseUrl;
        firebase = new Firebase(firebaseUrl);
    }

    @Override
    public void sendResetEmail(String email, final AuthCallback callback) {
        firebase.resetPassword(email, new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {
            }

            @Override
            public void onError(FirebaseError firebaseError) {
            callback.onError(firebaseError.toString());
            }
        });

    }

    @Override
    public void changeEmail(String oldEmail, String newEmail, String password, final AuthCallback callback) {

        firebase.changeEmail(oldEmail, password, newEmail, new Firebase.ResultHandler() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError(FirebaseError firebaseError) {
                callback.onError(firebaseError.toString());
            }
        });

    }

    @Override
    public void resetPassword(String email, String oldPassword, String newPassword, final AuthCallback callback) {
        firebase.changePassword(email, oldPassword, newPassword, new Firebase.ResultHandler() {
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
