package com.crystalgems.gemhunt.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PlayerDAO extends DatabaseContentProvider {

    public PlayerDAO(SQLiteDatabase database) {
        super(database);
    }

    @Override
    protected <T> T cursorToEntity(Cursor cursor) {
        return null;
    }
}
