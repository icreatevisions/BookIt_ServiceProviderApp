package com.icreatevisions.bookit_serviceproviderapp.Repository;
import com.google.firebase.firestore.auth.User;
import com.icreatevisions.bookit_serviceproviderapp.Models.Users;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
public class UserRepository implements IRepository<User,String> {
    private FirebaseFirestore firestoredb;

    public UserRepository() {
        firestoredb = FirebaseFirestore.getInstance();
    }

    @Override
    public Observable<List<User>> get() {
        return Observable.create((ObservableEmitter<List<User>> emitter) -> {
            emitter.onNext(null);
            emitter.onComplete();
        });
    }

    @Override
    public Observable<User> getById(String id) {
        final String email = id;
        return Observable.create((ObservableEmitter<User> emitter) -> {
            emitter.onNext(null);
            emitter.onComplete();
        });
    }



    @Override
    public Observable<User> create(com.icreatevisions.bookit_serviceproviderapp.Models.User entity) {
        final com.icreatevisions.bookit_serviceproviderapp.Models.User user = entity;
        return Observable.create((ObservableEmitter<User> emitter) -> {
            final Map<String, String> map = new HashMap<>();
            map.put("firstname", user.getFirstName());
            map.put("lastname", user.getLastName());
            map.put("businessname", user.getBusinessName());

            firestoredb.collection("users").document(user.getEmail())
                    .set(map)
                    .addOnSuccessListener((Void documentReference) -> {
                        emitter.onNext(user);
                         emitter.onComplete();
            }).addOnFailureListener((Exception e) -> {
                emitter.onError(new Throwable(e));
            });


        });
    }

    @Override
    public Observable update(User entity) {
        return null;
    }

    @Override
    public Observable delete(User entity) {
        return null;
    }
}
