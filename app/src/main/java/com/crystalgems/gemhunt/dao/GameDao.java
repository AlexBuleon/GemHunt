package com.crystalgems.gemhunt.dao;

import com.crystalgems.gemhunt.model.Game;

public class GameDAO extends DAO<Game, Integer> {
    @Override
    public boolean create(Game obj) {
        return false;
    }

    @Override
    public boolean delete(Game obj) {
        return false;
    }

    @Override
    public boolean update(Game obj) {
        return false;
    }

    @Override
    public Game find(Integer id) {
        return null;
    }
}
