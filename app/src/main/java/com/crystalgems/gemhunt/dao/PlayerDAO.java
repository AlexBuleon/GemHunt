package com.crystalgems.gemhunt.dao;

import android.content.ContentValues;

import com.crystalgems.gemhunt.model.Player;

//import com.crystalgems.gemhunt.Database.DatabaseHelper;

public class PlayerDAO extends DAO<Player, Integer> {

    @Override
    public boolean create(Player obj) {

        ContentValues values = new ContentValues();
        //store the values to add
        /*values.put(DatabaseHelper.NAME_COLUMN, obj.getName());
        values.put(DatabaseHelper.TOTAL_SCORE_COLUMN, obj.getTotalScore());
        values.put(DatabaseHelper.PENALTY_COLUMN, obj.getPenalty());*/



        return false;
    }

    @Override
    public boolean delete(Player obj) {
        return false;
    }

    @Override
    public boolean update(Player obj) {
        return false;
    }

    @Override
    public Player find(Integer id) {
        return null;
    }
}
