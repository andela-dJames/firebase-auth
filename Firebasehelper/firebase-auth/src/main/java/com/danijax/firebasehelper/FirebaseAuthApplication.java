package com.danijax.firebasehelper;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by danieljames on 2/25/16.
 */
public class FirebaseAuthApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
