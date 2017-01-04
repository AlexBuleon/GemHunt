package com.crystalgems.gemhunt.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;

import com.crystalgems.gemhunt.dao.daoInterface.GameDAOInterface;
import com.crystalgems.gemhunt.database.schema.GamePlayerLinkSchema;
import com.crystalgems.gemhunt.database.schema.GameSchema;
import com.crystalgems.gemhunt.model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameDAO extends DatabaseContentProvider implements GameSchema, GameDAOInterface{

    private Cursor cursor;
    private ContentValues values;

    public GameDAO(SQLiteDatabase database) {
        super(database);
    }

    @Override
    protected Game cursorToEntity(Cursor cursor) {
        Game game = new Game();

        int gameIdIndex;
        int durationIndex;
        int turnDurationIndex;
        int gamePlayerLinkIdIndex;

        if(cursor != null) {
            //get the gameId
            if(cursor.getColumnIndex(COLUMN_GAME_ID) != -1) {
                gameIdIndex = cursor.getColumnIndex(COLUMN_GAME_ID);
                game.setId(cursor.getInt(gameIdIndex));
            }

            //get the duration
            if(cursor.getColumnIndex(COLUMN_GAME_DURATION) != -1) {
                durationIndex = cursor.getColumnIndex(COLUMN_GAME_DURATION);
                game.setDuration(cursor.getLong(durationIndex));
            }

            //get the turnDuration
            if(cursor.getColumnIndex(COLUMN_GAME_TURN_DURATION) != -1) {
                turnDurationIndex = cursor.getColumnIndex(COLUMN_GAME_TURN_DURATION);
                game.setTurnCounter(cursor.getInt(turnDurationIndex));
            }

            //get the gamePlayerLinkId
            if(cursor.getColumnIndex(COLUMN_GAME_PLAYER_LINK_ID) != -1) {
                gamePlayerLinkIdIndex = cursor.getColumnIndex(COLUMN_GAME_PLAYER_LINK_ID);
                game.setGamePlayerLinkId(cursor.getInt(gamePlayerLinkIdIndex));
            }
        }

        return game;
    }

    @Override
    public Game findGameById(int id) {
        Game game = new Game();

        final String selection = COLUMN_GAME_ID + " = ?";
        final String[] selectionArg = { String.valueOf(id) };

        cursor = super.query(GAME_TABLE, GAME_COLUMNS, selection, selectionArg, COLUMN_GAME_ID);

        if(cursor != null) {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                game = cursorToEntity(cursor);
                cursor.moveToNext();
            }

            cursor.close();

            return game;
        }

        return null;
    }

    @Override
    public List<Game> findAllGames() {
        List<Game> games = new ArrayList<>();

        cursor = super.query(GAME_TABLE, GAME_COLUMNS, null, null, COLUMN_GAME_ID);

        if(cursor != null) {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                games.add(cursorToEntity(cursor));
                cursor.moveToNext();
            }

            cursor.close();
        }

        return games;
    }

    @Override
    public boolean addGame(Game game) {

        //add the game
        boolean gameInsert = false;
        setContentValues(game);
        try {
            gameInsert = super.insert(GAME_TABLE, values) > 0;
            return gameInsert;
        } catch (SQLiteConstraintException e) {
            return false;
        }
    }

    @Override
    public boolean addGames(List<Game> games) {
        return false;
    }

    @Override
    public boolean deleteGame(int id) {
        final String selection = COLUMN_GAME_ID + " = ?";
        final String[] selectionArg = { String.valueOf(id) };

        return super.delete(GAME_TABLE, selection, selectionArg) > 0;
    }

    @Override
    public boolean deleteAllGames() {
        return false;
    }

    private void setContentValues(Game game) {
        values = new ContentValues();

        values.put(COLUMN_GAME_DURATION, game.getDuration());
        values.put(COLUMN_GAME_TURN_DURATION, game.getTurnCounter());
        values.put(COLUMN_GAME_PLAYER_LINK_ID, 0);
    }
}
