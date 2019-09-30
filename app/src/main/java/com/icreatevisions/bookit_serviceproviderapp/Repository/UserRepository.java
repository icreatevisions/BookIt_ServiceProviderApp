package com.icreatevisions.bookit_serviceproviderapp.Repository;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteConstraintException;
import android.content.Context;
import android.content.ContentValues;

import com.icreatevisions.bookit_serviceproviderapp.Models.User;
import com.icreatevisions.bookit_serviceproviderapp.Repository.Tables.UserTable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

import com.icreatevisions.bookit_serviceproviderapp.Exceptions.RepositoryException;
import com.icreatevisions.bookit_serviceproviderapp.Exceptions.RepositoryExceptionCode;

public class UserRepository implements IRepository<User,String> {

    public DatabaseAccess databaseAccess;
    private Context context;

    public UserRepository(Context context) {
        this.context = context;
        this.databaseAccess = new DatabaseAccess(context);
    }

    @Override
    public Observable<List<User>> get() {
        return Observable.<List<User>>create(new ObservableOnSubscribe<List<User>>() {
            @Override
            public void subscribe(ObservableEmitter<List<User>> emitter) throws Exception {

                String[] projection = {
                        UserTable.COLUMN_NAME_ID,
                        UserTable.COLUMN_NAME_FIRST_NAME,
                        UserTable.COLUMN_NAME_LAST_NAME,
                        UserTable.COLUMN_NAME_BUSINESS_NAME,
                        UserTable.COLUMN_NAME_EMAIL,
                        UserTable.COLUMN_NAME_PASSWORD,
                        UserTable.COLUMN_NAME_ADDRESS
                };
                SQLiteDatabase db = databaseAccess.getReadableDatabase();
                Cursor cursor = db.query(UserTable.TABLE_NAME, projection, null, null, null, null, null);

                List<User> users = new ArrayList<>();

                while (cursor.moveToNext()) {
                    User u = User.builder()
                            .email(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_ID)))
                            .firstName(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_FIRST_NAME)))
                            .lastName(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_LAST_NAME)))
                            .businessName(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_BUSINESS_NAME)))
                            .password(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_PASSWORD)))
                            .address(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_ADDRESS)))
                            .build();
                    users.add(u);
                }

                emitter.onNext(users);
                cursor.close();
                emitter.onComplete();
            }
        });
    }

    @Override
    public Observable<User> getById(String id) {
        final String email = id;
        return Observable.<User>create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                String[] projection = {
                        UserTable.COLUMN_NAME_ID,
                        UserTable.COLUMN_NAME_FIRST_NAME,
                        UserTable.COLUMN_NAME_LAST_NAME,
                        UserTable.COLUMN_NAME_BUSINESS_NAME,
                        UserTable.COLUMN_NAME_EMAIL,
                        UserTable.COLUMN_NAME_PASSWORD,
                        UserTable.COLUMN_NAME_ADDRESS
                };

                String selection = UserTable.COLUMN_NAME_ID + "= ?";
                String[] selectionsArgs = {email};

                SQLiteDatabase db = databaseAccess.getReadableDatabase();
                Cursor cursor = db.query(UserTable.TABLE_NAME, projection, selection, selectionsArgs, null, null, null);

                if (cursor.moveToNext()) {
                    User u = User.builder()
                            .email(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_ID)))
                            .firstName(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_FIRST_NAME)))
                            .lastName(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_LAST_NAME)))
                            .businessName(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_BUSINESS_NAME)))
                            .password(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_PASSWORD)))
                            .address(cursor.getString(cursor.getColumnIndex(UserTable.COLUMN_NAME_ADDRESS)))
                            .build();
                    emitter.onNext(u);
                }
                cursor.close();
                emitter.onComplete();
            }
        });

    }

    @Override
    public Observable<User> create(User entity) {
        final User user = entity;
        return Observable.<User>create(new ObservableOnSubscribe<User>() {
            @Override
            public void subscribe(ObservableEmitter<User> emitter) throws Exception {
                // Gets the data repository in write mode
                SQLiteDatabase db = databaseAccess.getWritableDatabase();

                // Create a new map of values, where column names are the keys
                ContentValues values = new ContentValues();
                values.put(UserTable.COLUMN_NAME_ID, user.getEmail());
                values.put(UserTable.COLUMN_NAME_FIRST_NAME, user.getFirstName());
                values.put(UserTable.COLUMN_NAME_LAST_NAME, user.getLastName());
                values.put(UserTable.COLUMN_NAME_BUSINESS_NAME, user.getBusinessName());
                values.put(UserTable.COLUMN_NAME_PASSWORD, user.getPassword());
                values.put(UserTable.COLUMN_NAME_ADDRESS, user.getAddress());

                try {
                    // Insert the new row, returning the primary key value of the new row
                    long newRowId = db.insertOrThrow(UserTable.TABLE_NAME, null, values);

                    if (newRowId > 0) {
                        emitter.onNext(user);
                    } else {
                        emitter.onError(new RepositoryException(RepositoryExceptionCode.INSERT_FAILED, "Unable to create record on DB"));
                    }
                } catch (SQLiteConstraintException e) {
                    emitter.onError(new RepositoryException(RepositoryExceptionCode.DUPLICATE_RECORD, e.getMessage()));
                }

                emitter.onComplete();
            }
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

    @Override
    public void destroy() {
        this.databaseAccess.close();
    }
}
