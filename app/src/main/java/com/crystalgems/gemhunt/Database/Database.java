package com.crystalgems.gemhunt.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class Database {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "gemHunt_database";

    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper databaseHelper;

    public Database(Context context) {
        databaseHelper = new DatabaseHelper(context, DB_NAME, null, DB_VERSION);
    }

    //open the database
    public void open() {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
    }

    //close the database
    public void close() {
        sqLiteDatabase.close();
    }

    //get the databse
    public SQLiteDatabase getDB() {
        return sqLiteDatabase;
    }
}
