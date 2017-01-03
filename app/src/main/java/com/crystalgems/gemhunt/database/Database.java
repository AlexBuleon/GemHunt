package com.crystalgems.gemhunt.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.crystalgems.gemhunt.dao.GameDAO;
import com.crystalgems.gemhunt.dao.PlayerDAO;
import com.crystalgems.gemhunt.database.schema.GamePlayerLinkSchema;
import com.crystalgems.gemhunt.database.schema.GameSchema;
import com.crystalgems.gemhunt.database.schema.PlayerSchema;

public class Database {

    private static final String TAG = "GemHuntDatabase";
    private static final String DATABASE_NAME = "gemHunt_database.db";

    private DatabaseHelper databaseHelper;

    private static final int DATABASE_VERSION = 1;
    private final Context context;
    private static PlayerDAO playerDAO;
    private static GameDAO gameDAO;

    public Database(Context context) {
        this.context = context;
    }

    public Database open() {
        databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase sqLiteDatabase = databaseHelper.getWritableDatabase();

        playerDAO = new PlayerDAO(sqLiteDatabase);

        return this;
    }

    public void close() {
        databaseHelper.close();
    }

    public static PlayerDAO getPlayerDAO() {
        return playerDAO;
    }

    public static GameDAO getGameDAO() {
        return gameDAO;
    }

    private static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(GameSchema.GAME_TABLE_CREATE);
            db.execSQL(PlayerSchema.PLAYER_TABLE_CREATE);
            db.execSQL(GamePlayerLinkSchema.GAME_PLAYER_LINK_TABLE_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
