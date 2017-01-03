package com.crystalgems.gemhunt.dao;

import android.database.sqlite.SQLiteDatabase;

public abstract class DatabaseContentProvider {
    public SQLiteDatabase database;

    public DatabaseContentProvider(SQLiteDatabase database) {
        this.database = database;
    }
}
