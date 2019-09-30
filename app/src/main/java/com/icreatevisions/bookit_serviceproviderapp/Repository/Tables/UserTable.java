package com.icreatevisions.bookit_serviceproviderapp.Repository.Tables;

public class UserTable {
    public static final String TABLE_NAME = "user";
    public static final String COLUMN_NAME_ID = "id";
    public static final String COLUMN_NAME_FIRST_NAME = "first_name";
    public static final String COLUMN_NAME_LAST_NAME = "last_name";
    public static final String COLUMN_NAME_BUSINESS_NAME = "business_name";
    public static final String COLUMN_NAME_EMAIL = "email";
    public static final String COLUMN_NAME_PASSWORD = "password";
    public static final String COLUMN_NAME_ADDRESS = "address";

    public static String create() {
        return new String("Create Table" + TABLE_NAME + " (" +
                COLUMN_NAME_ID + "TEXT PRIMARY KEY," +
                COLUMN_NAME_FIRST_NAME + " TEXT," +
                COLUMN_NAME_LAST_NAME + " TEXT," +
                COLUMN_NAME_BUSINESS_NAME + " TEXT," +
                COLUMN_NAME_EMAIL + " TEXT," +
                COLUMN_NAME_PASSWORD + " TEXT," +
                COLUMN_NAME_ADDRESS + " TEXT)");
    }

    public static final String drop() {
        return "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
