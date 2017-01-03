package com.crystalgems.gemhunt.dao;

import android.database.sqlite.SQLiteDatabase;

public class GameDAO extends DatabaseContentProvider {


    public GameDAO(SQLiteDatabase database) {
        super(database);
    }
}
