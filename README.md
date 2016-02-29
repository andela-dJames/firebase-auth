# firebase-auth

## Overview
Easily integrate authentication with firebase using simple helper methods.

## Getting Started
Get the dependency via maven using 

```xml
<dependency>
<groupId>com.danijax.firebasehelper</groupId>
<artifactId>firebase-auth</artifactId>
<version>0.1.3</version>
<type>pom</type>
</dependency> 
```

 Or from gradle using 

```groovy
compile 'com.danijax.firebasehelper:firebase-auth:0.1.3'
```

Or from Ivy using 

```xml
<dependency org='com.danijax.firebasehelper' name='firebase-auth' rev='0.1.3'>
  <artifact name='$AID' ext='pom'></artifact>
</dependency>
```

add the following to the android element of your app build.gradle file
```groovy
android{
      ...
      packagingOptions {
        exclude  'META-INF/NOTICE'
        exclude  'META-INF/LICENSE'
    }
  }
  ```
  
  set the FirebaseAndroidContext in your Application `onCreate` method 
  
  ```java
  public class baseApp extends Application {
  protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         Firebase.setAndroidContext(this);
        }
  }
  
  ```
## Usage

To sign up you need to call the `signUpWithEmail` method


```java
private FirebaseEmailAuth emailAuth;
protected static final String FIREBASE_URL = "[YOUR_APP_FIREBASE_URL]"

emailAuth = new FirebaseEmailAuth(this, FIREBSE_URL);
...
public void signUp(View view) {
        String email = emailText.getText().toString().trim();
        String password = passwordText.getText().toString().trim();
        emailAuth.signUpWithEmail(email, password, new AuthCallback() {
            @Override
            public void onSuccess(Object data) {
                Log.d(TAG, data.toString());
            }

            @Override
            public void onError(String errorMessage) {
                Log.e(TAG, errorMessage);

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onFailure(Exception e) {

            }
        });
        
    }
  ```  


