package com.icreatevisions.bookit_serviceproviderapp.Events;

import androidx.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.icreatevisions.bookit_serviceproviderapp.Models.User;

import javax.security.auth.login.LoginException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class CreateUser {

    private static final String TAG = "CreateUserEvent";

    private FirebaseAuth mAuth;
    private User user;
    private CreateUser(User user){
    this.user = user;    }


}
