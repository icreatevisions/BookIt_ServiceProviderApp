package com.icreatevisions.bookit_serviceproviderapp.Activites;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.util.Log;

import com.icreatevisions.bookit_serviceproviderapp.R;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private Button loginButton;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");
        loginButton = (Button) findViewById(R.id.loginButton);
        signupButton = (Button) findViewById(R.id.signUpButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Create Account Selected");
                Intent goToCreateAccountActivity = new Intent(MainActivity.this, CreateAccount.class);
                startActivity(goToCreateAccountActivity);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Login Button Selected");
                Intent goToLoginActivity = new Intent(MainActivity.this, Login.class);
                startActivity(goToLoginActivity);
            }
        });
    }


}
