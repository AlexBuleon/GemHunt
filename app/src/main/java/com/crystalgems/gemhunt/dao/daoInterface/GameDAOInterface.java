package com.crystalgems.gemhunt.dao.daoInterface;

import com.crystalgems.gemhunt.model.Game;

import java.util.List;

public interface GameDAOInterface {
    Game findGameById(int id);
    List<Game> findAllGames();
    boolean addGame(Game game);
    boolean addGames(List<Game> games);
    boolean deleteGame(int id);
    boolean deleteAllGames();
}
