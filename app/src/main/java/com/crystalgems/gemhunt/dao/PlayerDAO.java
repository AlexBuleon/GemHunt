package com.crystalgems.gemhunt.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;

import com.crystalgems.gemhunt.dao.daoInterface.PlayerDAOInterface;
import com.crystalgems.gemhunt.database.schema.PlayerSchema;
import com.crystalgems.gemhunt.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerDAO extends DatabaseContentProvider implements PlayerSchema, PlayerDAOInterface{

    private Cursor cursor;
    private ContentValues values;

    public PlayerDAO(SQLiteDatabase database) {
        super(database);
    }

    @Override
    protected Player cursorToEntity(Cursor cursor) {
        Player player = new Player();

        int nameIndex;
        int pictureIdIndex;
        int globalScoreIndex;
        int globalPenaltyIndex;

        if(cursor != null) {
            //get the name
            if(cursor.getColumnIndex(COLUMN_PLAYER_NAME) != -1) {
                nameIndex = cursor.getColumnIndex(COLUMN_PLAYER_NAME);
                player.setName(cursor.getString(nameIndex));
            }

            //get the pictureIndex
            if(cursor.getColumnIndex(COLUMN_PLAYER_PICTURE_ID) != -1) {
                pictureIdIndex = cursor.getColumnIndex(COLUMN_PLAYER_PICTURE_ID);
                player.setPictureId(cursor.getInt(pictureIdIndex));
            }

            //get the global score
            if(cursor.getColumnIndex(COLUMN_PLAYER_GLOBAL_SCORE) != -1) {
                globalScoreIndex = cursor.getColumnIndex(COLUMN_PLAYER_GLOBAL_SCORE);
                player.setGlobalScore(cursor.getInt(globalScoreIndex));
            }

            //get the global penalty
            if(cursor.getColumnIndex(COLUMN_PLAYER_GLOBAL_PENALTY) != -1) {
                globalPenaltyIndex = cursor.getColumnIndex(COLUMN_PLAYER_GLOBAL_PENALTY);
                player.setGlobalPenalty(cursor.getInt(globalPenaltyIndex));
            }

            if(cursor.getColumnIndex(COLUMN_PLAYER_ID) != -1) {
                int i = cursor.getColumnIndex(COLUMN_PLAYER_ID);
                player.setId(cursor.getInt(i));
            }

            //set the other field to an zero value
            player.setTurnScore(0);
            player.setPenaltyCounter(0);
            player.setRollCounter(0);
        }



        return player;
    }

    @Override
    public boolean updatePlayer(int id, Player player) {
        values = new ContentValues();

        values.put(COLUMN_PLAYER_NAME, player.getName());
        values.put(COLUMN_PLAYER_PICTURE_ID, player.getPictureId());
        values.put(COLUMN_PLAYER_GLOBAL_PENALTY, player.getGlobalPenalty());
        values.put(COLUMN_PLAYER_GLOBAL_SCORE, player.getGlobalScore());

        final String selection = COLUMN_PLAYER_ID + " = ?";
        final String[] selectionArg = {String.valueOf(id)};

        return super.update(PLAYER_TABLE, values, selection, selectionArg) > 0;
    }

    @Override
    public Player findPlayerById(int id) {
        Player player = new Player();

        final String selection = COLUMN_PLAYER_ID + " = ?";
        final String[] selectionArg = { String.valueOf(id) };

        cursor = super.query(PLAYER_TABLE, PLAYER_COLUMNS, selection, selectionArg, COLUMN_PLAYER_ID);

        if(cursor != null) {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                player = cursorToEntity(cursor);
                cursor.moveToNext();
            }

            cursor.close();

            return player;
        }

        return null;
    }

    @Override
    public Player findPlayerByName(String name) {
        Player player = new Player();

        final String selection = COLUMN_PLAYER_NAME + " = ?";
        final String[] selectionArg = { String.valueOf(name) };

        cursor = super.query(PLAYER_TABLE, PLAYER_COLUMNS, selection, selectionArg, COLUMN_PLAYER_ID);

        if(cursor != null) {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                player = cursorToEntity(cursor);
                cursor.moveToNext();
            }

            cursor.close();

            return player;
        }

        return null;
    }

    @Override
    public boolean exists(String name) {
        final String selection = COLUMN_PLAYER_NAME + " = ?";
        final String[] selectionArg = { String.valueOf(name) };

        return super.query(PLAYER_TABLE, PLAYER_COLUMNS, selection, selectionArg, COLUMN_PLAYER_ID).getCount() > 0;
    }

    @Override
    public List<Player> findAllPlayer() {
        List<Player> players = new ArrayList<>();

        cursor = super.query(PLAYER_TABLE, PLAYER_COLUMNS, null, null, COLUMN_PLAYER_ID);

        if(cursor != null) {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                players.add(cursorToEntity(cursor));
                cursor.moveToNext();
            }

            cursor.close();
        }

        return players;
    }

    @Override
    public boolean addPlayer(Player player) {
        setContentValues(player);
        try {
            return super.insert(PLAYER_TABLE, values) > 0;
        } catch (SQLiteConstraintException e) {
            return false;
        }
    }


    @Override
    public boolean addPlayers(List<Player> players) {
        return false;
    }

    @Override
    public boolean deletePlayer(int id) {
        final String selection = COLUMN_PLAYER_ID + " = ?";
        final String[] selectionArg = { String.valueOf(id) };

        return super.delete(PLAYER_TABLE, selection, selectionArg) > 0;
    }

    @Override
    public boolean deleteAllPlayers() {
        return super.delete(PLAYER_TABLE, null, null) > 0;
    }

    private void setContentValues(Player player) {
        values  = new ContentValues();
        values.put(COLUMN_PLAYER_NAME, player.getName());
        values.put(COLUMN_PLAYER_PICTURE_ID, player.getPictureId());
        values.put(COLUMN_PLAYER_GLOBAL_SCORE, player.getGlobalScore());
        values.put(COLUMN_PLAYER_GLOBAL_PENALTY, player.getGlobalPenalty());
    }
}
