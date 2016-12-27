package com.crystalgems.gemhunt.dao;

import com.crystalgems.gemhunt.model.Player;

public class PlayerDAO extends DAO<Player, Integer> {

    @Override
    public boolean create(Player obj) {
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
