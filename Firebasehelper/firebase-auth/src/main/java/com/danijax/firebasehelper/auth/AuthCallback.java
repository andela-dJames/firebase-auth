package com.danijax.firebasehelper.auth;

/**
 * Created by danieljames on 2/25/16.
 */
public interface AuthCallback<T> {

    void onSuccess(T data);
    void onError(String errorMessage);
    void onCancel();
    void onFailure(Exception e);
}
