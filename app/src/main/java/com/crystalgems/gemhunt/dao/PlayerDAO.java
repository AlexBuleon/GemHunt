package com.crystalgems.gemhunt.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.crystalgems.gemhunt.dao.daoInterface.PlayerDAOInterface;
import com.crystalgems.gemhunt.database.schema.PlayerSchema;
import com.crystalgems.gemhunt.model.Player;

import java.util.List;

public class PlayerDAO extends DatabaseContentProvider implements PlayerSchema, PlayerDAOInterface{

    public PlayerDAO(SQLiteDatabase database) {
        super(database);
    }

    @Override
    protected Player cursorToEntity(Cursor cursor) {
        Player player = new Player();

        int nameIndex;
        int pictureIdIndex;
        int totalScoreIndex;
        int totalPenaltyIndex;

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

            //get the total score
            if(cursor.getColumnIndex(COLUMN_PLAYER_TOTAL_SCORE) != -1) {
                totalScoreIndex = cursor.getColumnIndex(COLUMN_PLAYER_TOTAL_SCORE);
                player.setTotalScore(cursor.getInt(totalScoreIndex));
            }

            //get the total penalty
            if(cursor.getColumnIndex(COLUMN_PLAYER_TOTAL_PENALTY) != -1) {
                totalPenaltyIndex = cursor.getColumnIndex(COLUMN_PLAYER_TOTAL_PENALTY);
                player.setTotalScore(cursor.getInt(totalPenaltyIndex));
            }

            //set the other field to an zero value
            player.setTurnScore(0);
            player.setPenaltyCounter(0);
            player.setRollCounter(0);
        }

        return player;
    }

    @Override
    public Player findPlayerById(int id) {
        return null;
    }

    @Override
    public List<Player> findAllPlayer() {
        return null;
    }

    @Override
    public boolean addPlayer(Player player) {
        return false;
    }

    @Override
    public boolean addPlayers(List<Player> players) {
        return false;
    }

    @Override
    public boolean deletePlayer(int id) {
        return false;
    }

    @Override
    public boolean deleteAllPlayers() {
        return false;
    }
}
