package com.crystalgems.gemhunt.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.crystalgems.gemhunt.dao.daoInterface.GameDAOInterface;
import com.crystalgems.gemhunt.database.schema.GameSchema;
import com.crystalgems.gemhunt.model.Game;

import java.util.List;

public class GameDAO extends DatabaseContentProvider implements GameSchema, GameDAOInterface{

    public GameDAO(SQLiteDatabase database) {
        super(database);
    }

    @Override
    protected Game cursorToEntity(Cursor cursor) {
        return null;
    }

    @Override
    public Game findGameById(int id) {
        return null;
    }

    @Override
    public List<Game> findAllGames() {
        return null;
    }

    @Override
    public boolean addGame(Game game) {
        return false;
    }

    @Override
    public boolean addGames(List<Game> games) {
        return false;
    }

    @Override
    public boolean deleteGame(Game game) {
        return false;
    }

    @Override
    public boolean deleteAllGames() {
        return false;
    }
}
