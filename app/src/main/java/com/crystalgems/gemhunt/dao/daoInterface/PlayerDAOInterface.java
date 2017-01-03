package com.crystalgems.gemhunt.dao.daoInterface;

import com.crystalgems.gemhunt.model.Player;

import java.util.List;

public interface PlayerDAOInterface {
    Player findPlayerById(int id);
    List<Player> findAllPlayer();
    boolean addPlayer(Player player);
    boolean addPlayers(List<Player> players);
    boolean deletePlayer(int id);
    boolean deleteAllPlayers();
}
