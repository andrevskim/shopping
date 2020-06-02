package com.example.shopping;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class LoginActivity extends AppCompatActivity {

//    private static final int RC_SIGN_IN = 123;
private FirebaseAuth mAuth;

    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        openMainActivityy(currentUser);

    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_login);
        Button login = findViewById(R.id.login);

//        login.setOnClickListener(new View.OnClickListener() {
//
//                                     @Override
//                                     public void onClick(View v) {
//                                         createSignInIntent();
//                                     }
//                                 }
//        );
        Button anon = findViewById(R.id.Anon);
        anon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity(getApplicationContext());
            }
        });
    }


    public void openMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);


    }
    public void openMainActivityy(FirebaseUser currentUser){

    }


}
//    public void createSignInIntent() {
//        // [START auth_fui_create_intent]
//        // Choose authentication providers
////        List<AuthUI.IdpConfig> providers = Arrays.asList(
////                new AuthUI.IdpConfig.EmailBuilder().build(),
////                new AuthUI.IdpConfig.GoogleBuilder().build());
//
//
//        startActivityForResult(
//                AuthUI.getInstance()
//                        .createSignInIntentBuilder()
////                        .setAvailableProviders(providers)
//                        .build(),
//                RC_SIGN_IN);
//    }
//
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == RC_SIGN_IN) {
//            IdpResponse response = IdpResponse.fromResultIntent(data);
//
//            if (resultCode == RESULT_OK) {
//                // Successfully signed in
//                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//                openMainActivity(getApplicationContext());
//                // ...
//            } else {
//                // Sign in failed. If response is null the user canceled the
//                // sign-in flow using the back button. Otherwise check
//                // response.getError().getErrorCode() and handle the error.
//                // ...
//            }
//        }
//    }
//}