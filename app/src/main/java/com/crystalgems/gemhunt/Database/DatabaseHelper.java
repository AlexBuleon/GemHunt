package com.crystalgems.gemhunt.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    //defines the structure of the database
    public static final String PLAYER_TABLE = "player";
    public static final String ID_PLAYER_COLUMN = "id";
    public static final String NAME_COLUMN = "name";
    public static final String TOTAL_SCORE_COLUMN = "totalScore";
    public static final String TOTAL_PENALTY_COLUMN = "penalty";

    public static final String GAME_TABLE = "game";
    public static final String ID_GAME_COLUMN = "id";
    public static final String GAME_TOTAL_SCORE_COLUMN = "total_score";
    public static final String GAME_TOTAL_PENALTY_COLUMN = "total_penalty";

    public static final String GAME_LINK_PLAYER_TABLE = "game_link_player";
    public static final String ID_LINK_COLUMN = "id";
    public static final String ID_LINK_GAME_COLUMN = "id_game";
    public static final String ID_LINK_PLAYER_COLUMN = "id_player";
    public static final String LINK_RANK_COLUMN = "rank";

    //creates all the tables
    private static final String CREATE_TABLES = "CREATE TABLE " + PLAYER_TABLE + " ("
            + ID_PLAYER_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NAME_COLUMN + " VARCHAR(50) NOT NULL,"
            + TOTAL_SCORE_COLUMN + " INTEGER NOT NULL,"
            + TOTAL_PENALTY_COLUMN + " INTEGER NOT NULL"
            + ");"

            + "CREATE TABLE " + GAME_TABLE + " ("
            + ID_GAME_COLUMN + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + GAME_TOTAL_SCORE_COLUMN + "INTEGER NOT NULL,"
            + GAME_TOTAL_PENALTY_COLUMN + "INTEGER NOT NULL"
            + ");"

            + "CREATE TABLE " + GAME_LINK_PLAYER_TABLE + " ("
            + ID_LINK_COLUMN + " INTGER PRIMARY KEY AUTOINCREMENT,"
            + ID_LINK_GAME_COLUMN + " INTEGER NOT NULL,"
            + ID_LINK_PLAYER_COLUMN + " INTEGER NOT NULL,"
            + LINK_RANK_COLUMN + " INTEGER NOT NULL"
            + ");";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create the tables of the database
        db.execSQL(CREATE_TABLES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO: 27/12/2016 decide what to do
    }
}
