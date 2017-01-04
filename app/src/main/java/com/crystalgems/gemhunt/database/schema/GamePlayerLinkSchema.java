package com.crystalgems.gemhunt.database.schema;

public interface GamePlayerLinkSchema {

    //definition of the player gamePlayerLink
    String GAME_PLAYER_LINK_TABLE = "gamePlayerLink";

    String COLUMN_GAME_PLAYER_LINK_ID = "id";
    String COLUMN_GAME_PLAYER_LINk_ID_GAME = "idGame";
    String COLUMN_GAME_PLAYER_LINk_ID_PLAYER = "idPlayer";
    String COLUMN_GAME_PLAYER_LINk_PLAYER_SCORE = "playerScore";
    String COLUMN_GAME_PLAYER_LINk_PLAYER_PENALTY = "playerPenalty";
    String COLUMN_GAME_PLAYER_LINk_PLAYER_RANK = "playerRank";

    //Create table query
    String GAME_PLAYER_LINK_TABLE_CREATE = "create table if not exists " +
            GAME_PLAYER_LINK_TABLE + "(" +
            COLUMN_GAME_PLAYER_LINK_ID + " integer primary key," +
            COLUMN_GAME_PLAYER_LINk_ID_GAME + " integer not null," +
            COLUMN_GAME_PLAYER_LINk_ID_PLAYER + " integer not null," +
            COLUMN_GAME_PLAYER_LINk_PLAYER_SCORE + " integer not null," +
            COLUMN_GAME_PLAYER_LINk_PLAYER_PENALTY + " integer not null," +
            COLUMN_GAME_PLAYER_LINk_PLAYER_RANK + " integer not null" +
            ");";

    //List of the column of the table
    String[] GAME_PLAYER_LINK_COLUMNS = new String[] {
            COLUMN_GAME_PLAYER_LINK_ID,
            COLUMN_GAME_PLAYER_LINk_ID_GAME,
            COLUMN_GAME_PLAYER_LINk_ID_PLAYER,
            COLUMN_GAME_PLAYER_LINk_PLAYER_SCORE,
            COLUMN_GAME_PLAYER_LINk_PLAYER_PENALTY,
            COLUMN_GAME_PLAYER_LINk_PLAYER_RANK
    };

}
