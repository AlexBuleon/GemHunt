package com.crystalgems.gemhunt.database.schema;

public interface GameSchema {

    //definition of the table game
    String TABLE_GAME = "game";

    String COLUMN_GAME_ID = "id";
    String COLUMN_GAME_DURATION  = "duration";
    String COLUMN_GAME_TURN_DURATION  = "turnDuration";
    String COLUMN_GAME_PLAYER_LINK = "idLink";

    //Create table query
    String GAME_TABLE_CREATE = "create table if not exists "
            + TABLE_GAME + "(" +
            COLUMN_GAME_ID + " integer primary key autoincrement," +
            // TODO: 03/01/2017 check if duration can be an intger
            COLUMN_GAME_DURATION + " integer not null," +
            COLUMN_GAME_TURN_DURATION + " integer not null," +
            COLUMN_GAME_PLAYER_LINK + " integer not null" +
            ");";

    //List of the column of the table
    String[] GAME_COLUMNS = new String[] {COLUMN_GAME_ID, COLUMN_GAME_TURN_DURATION, COLUMN_GAME_TURN_DURATION, COLUMN_GAME_PLAYER_LINK};
}
