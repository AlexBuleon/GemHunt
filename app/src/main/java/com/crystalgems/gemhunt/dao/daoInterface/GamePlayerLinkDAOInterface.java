package com.crystalgems.gemhunt.dao.daoInterface;

import com.crystalgems.gemhunt.model.GamePlayerLink;

import java.util.List;

public interface GamePlayerLinkDAOInterface {
    GamePlayerLink findGamePlayerLinkById(int id);
    List<GamePlayerLink> findAllGamePlayerLink();
    boolean addGamePLayerLink(GamePlayerLink gamePlayerLink);
    boolean addGamePlayers(List<GamePlayerLink> gamePlayerLinks);
    boolean deleteGamePlayerLink(int id);
    boolean deleteAllGamePlayers();
}
