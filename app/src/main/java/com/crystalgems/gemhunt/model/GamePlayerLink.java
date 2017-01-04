package com.crystalgems.gemhunt.model;

// a class that manage the link between players and game
public class GamePlayerLink {

    private int gamePlayerLinkId;
    private int gameId;
    private int playerId;
    private int playerScore;
    private int playerPenalty;
    private int playerRank;

    public GamePlayerLink() {
    }

    @Override
    public String toString() {
        return "GamePlayerLink{" +
                "gamePlayerLinkId=" + gamePlayerLinkId +
                ", gameId=" + gameId +
                ", playerId=" + playerId +
                ", playerScore=" + playerScore +
                ", playerPenalty=" + playerPenalty +
                ", playerRank=" + playerRank +
                '}';
    }

    public int getGamePlayerLinkId() {
        return gamePlayerLinkId;
    }

    public void setGamePlayerLinkId(int gamePlayerLinkId) {
        this.gamePlayerLinkId = gamePlayerLinkId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getPlayerPenalty() {
        return playerPenalty;
    }

    public void setPlayerPenalty(int playerPenalty) {
        this.playerPenalty = playerPenalty;
    }

    public int getPlayerRank() {
        return playerRank;
    }

    public void setPlayerRank(int playerRank) {
        this.playerRank = playerRank;
    }
}
