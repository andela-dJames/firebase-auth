package com.danijax.firebase_auth.model;

/**
 * Created by danieljames on 2/25/16.
 */
public abstract class Model  {
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
