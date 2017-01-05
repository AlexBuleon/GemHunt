package com.crystalgems.gemhunt.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;

import com.crystalgems.gemhunt.dao.daoInterface.GamePlayerLinkDAOInterface;
import com.crystalgems.gemhunt.database.schema.GamePlayerLinkSchema;
import com.crystalgems.gemhunt.model.GamePlayerLink;

import java.util.ArrayList;
import java.util.List;

public class GamePlayerLinkDAO extends DatabaseContentProvider implements GamePlayerLinkSchema, GamePlayerLinkDAOInterface {

    private Cursor cursor;
    private ContentValues values;

    public GamePlayerLinkDAO(SQLiteDatabase database) {
        super(database);
    }

    @Override
    protected GamePlayerLink cursorToEntity(Cursor cursor) {
        GamePlayerLink gamePlayerLink = new GamePlayerLink();

        int idIndex;
        int gameIdIndex;
        int playerIdIndex;
        int playerScoreIndex;
        int playerPenaltyIndex;
        int playerRankIndex;

        if(cursor != null) {
            //get the id
            if(cursor.getColumnIndex(COLUMN_GAME_PLAYER_LINK_ID) != -1) {
                idIndex = cursor.getColumnIndex(COLUMN_GAME_PLAYER_LINK_ID);
                gamePlayerLink.setGamePlayerLinkId(cursor.getInt(idIndex));
            }

            //get the game id
            if(cursor.getColumnIndex(COLUMN_GAME_PLAYER_LINk_ID_GAME) != -1) {
                gameIdIndex = cursor.getColumnIndex(COLUMN_GAME_PLAYER_LINk_ID_GAME);
                gamePlayerLink.setGameId(cursor.getInt(gameIdIndex));
            }

            //get the player id
            if(cursor.getColumnIndex(COLUMN_GAME_PLAYER_LINk_ID_PLAYER) != -1) {
                playerIdIndex = cursor.getColumnIndex(COLUMN_GAME_PLAYER_LINk_ID_PLAYER);
                gamePlayerLink.setPlayerId(cursor.getInt(playerIdIndex));
            }

            //get the player score
            if(cursor.getColumnIndex(COLUMN_GAME_PLAYER_LINk_PLAYER_SCORE) != -1) {
                playerScoreIndex = cursor.getColumnIndex(COLUMN_GAME_PLAYER_LINk_PLAYER_SCORE);
                gamePlayerLink.setPlayerScore(cursor.getInt(playerScoreIndex));
            }

            //get the player penalty
            if(cursor.getColumnIndex(COLUMN_GAME_PLAYER_LINk_PLAYER_PENALTY) != -1) {
                playerPenaltyIndex = cursor.getColumnIndex(COLUMN_GAME_PLAYER_LINk_PLAYER_PENALTY);
                gamePlayerLink.setPlayerPenalty(cursor.getInt(playerPenaltyIndex));
            }

            //get the player rank
            if(cursor.getColumnIndex(COLUMN_GAME_PLAYER_LINk_PLAYER_RANK) != -1) {
                playerRankIndex = cursor.getColumnIndex(COLUMN_GAME_PLAYER_LINk_PLAYER_RANK);
                gamePlayerLink.setPlayerRank(cursor.getInt(playerRankIndex));
            }
        }

        return gamePlayerLink;
    }

    @Override
    public GamePlayerLink findGamePlayerLinkById(int id) {
        GamePlayerLink gamePlayerLink = new GamePlayerLink();

        final String selection = COLUMN_GAME_PLAYER_LINK_ID + " = ?";
        final String[] selectionArg = { String.valueOf(id) };

        cursor = super.query(GAME_PLAYER_LINK_TABLE, GAME_PLAYER_LINK_COLUMNS, selection, selectionArg, COLUMN_GAME_PLAYER_LINK_ID);

        if(cursor != null) {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                gamePlayerLink = cursorToEntity(cursor);
                cursor.moveToNext();
            }

            cursor.close();

            return gamePlayerLink;
        }

        return null;
    }

    @Override
    public List<GamePlayerLink> findAllGamePlayerLink() {
        List<GamePlayerLink> gamePlayerLinks = new ArrayList<>();

        cursor = super.query(GAME_PLAYER_LINK_TABLE, GAME_PLAYER_LINK_COLUMNS, null, null, COLUMN_GAME_PLAYER_LINK_ID);

        if(cursor != null) {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                gamePlayerLinks.add(cursorToEntity(cursor));
                cursor.moveToNext();
            }

            cursor.close();
        }

        return gamePlayerLinks;
    }

    @Override
    public boolean addGamePLayerLink(GamePlayerLink gamePlayerLink) {
        //add the gamePlayerLink
        setContentValues(gamePlayerLink);
        try {
            return super.insert(GAME_PLAYER_LINK_TABLE, values) > 0;
        } catch (SQLiteConstraintException e) {
            return false;
        }
    }

    @Override
    public boolean addGamePlayers(List<GamePlayerLink> gamePlayerLinks) {
        return false;
    }

    @Override
    public boolean deleteGamePlayerLink(int id) {
        final String selection = COLUMN_GAME_PLAYER_LINK_ID + " = ?";
        final String[] selectionArg = { String.valueOf(id) };

        return super.delete(GAME_PLAYER_LINK_TABLE, selection, selectionArg) > 0;
    }

    @Override
    public boolean deleteAllGamePlayers() {
        return super.delete(GAME_PLAYER_LINK_TABLE, null, null) > 0;
    }

    private void setContentValues(GamePlayerLink gamePlayerLink) {
        values = new ContentValues();

        values.put(COLUMN_GAME_PLAYER_LINk_ID_GAME, gamePlayerLink.getGameId());
        values.put(COLUMN_GAME_PLAYER_LINk_ID_PLAYER, gamePlayerLink.getPlayerId());
        values.put(COLUMN_GAME_PLAYER_LINk_PLAYER_SCORE, gamePlayerLink.getPlayerScore());
        values.put(COLUMN_GAME_PLAYER_LINk_PLAYER_PENALTY, gamePlayerLink.getPlayerPenalty());
        values.put(COLUMN_GAME_PLAYER_LINk_PLAYER_RANK, gamePlayerLink.getPlayerRank());
    }
}
