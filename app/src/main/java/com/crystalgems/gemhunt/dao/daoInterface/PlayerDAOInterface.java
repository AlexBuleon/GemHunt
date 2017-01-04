package com.crystalgems.gemhunt.dao.daoInterface;

import com.crystalgems.gemhunt.model.Player;

import java.util.List;

public interface PlayerDAOInterface {
    Player findPlayerById(int id);
    Player findPlayerByName(String name);
    List<Player> findAllPlayer();
    boolean exists(String name);
    boolean updatePlayer(int id, Player player);
    boolean addPlayer(Player player);
    boolean addPlayers(List<Player> players);
    boolean deletePlayer(int id);
    boolean deleteAllPlayers();
}
