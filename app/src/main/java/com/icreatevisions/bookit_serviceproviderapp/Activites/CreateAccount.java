package com.icreatevisions.bookit_serviceproviderapp.Activites;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.icreatevisions.bookit_serviceproviderapp.Models.User;
import com.icreatevisions.bookit_serviceproviderapp.R;

import androidx.annotation.NonNull;

public class CreateAccount extends Activity {
    private EditText editFirstName, editLastName, editBusinessName, editEmail, editPassword, editEinNumber, editAddress;
    private FirebaseAuth mAuth;

    @Override(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        mAuth = FirebaseAuth.getInstance();

    }

    @Override protected void onStart() {
        super.onStart();

        if(mAuth.getCurrentUser() != null) {
            // handle the already logged in user

        }
    }

    private void registerUser() {
        String fName = editFirstName.getText().toString().trim();
        String lName = editLastName.getText().toString().trim();
        String bName = editBusinessName.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String address = editAddress.getText().toString().trim();

        if (fName.isEmpty() || lName.isEmpty() || bName.isEmpty() || email.isEmpty() || password.isEmpty() ) {
            editFirstName.setError("name required");
            editFirstName.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // store additional fields in firebase db

                            protected void onCrea  //   User user = new User(fName,lName,bName, email,password,address);
                        } else {
                            Toast.makeText(CreateAccount.this, "task.getException().getMessage()", Toast.LENGTH_LONG).show();
                        }
                    }
                });

        }

}

