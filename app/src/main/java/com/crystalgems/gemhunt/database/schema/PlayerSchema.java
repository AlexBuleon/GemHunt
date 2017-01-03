package com.crystalgems.gemhunt.database.schema;

public interface PlayerSchema {

    //definition of the table player
    String PLAYER_TABLE = "player";

    String COLUMN_PLAYER_ID = "id";
    String COLUMN_PLAYER_NAME = "name";
    String COLUMN_PLAYER_PICTURE_ID = "pictureId";
    String COLUMN_PLAYER_TOTAL_SCORE = "totalScore";
    String COLUMN_PLAYER_PENALTY = "penalty";

    //Create table query
    String PLAYER_TABLE_CREATE = "create table if not exists " +
            PLAYER_TABLE + "(" +
            COLUMN_PLAYER_ID + " integer primary key autoincrement," +
            COLUMN_PLAYER_NAME + " text not null," +
            COLUMN_PLAYER_PICTURE_ID + " integer not null," +
            COLUMN_PLAYER_TOTAL_SCORE + " integer not null," +
            COLUMN_PLAYER_PENALTY + " integer not null" +
            ");";

    //List of the column of the table
    String[] PLAYER_COLUMNS = new String[] { COLUMN_PLAYER_ID, COLUMN_PLAYER_NAME, COLUMN_PLAYER_PICTURE_ID, COLUMN_PLAYER_TOTAL_SCORE, COLUMN_PLAYER_PENALTY};
}
