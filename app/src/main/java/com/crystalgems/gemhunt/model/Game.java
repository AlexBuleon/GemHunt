package com.crystalgems.gemhunt.model;

import java.util.Arrays;

public class Game {
	private int id;
	private int gamePlayerLinkId;
	private int turnCounter;
	private long duration;
    private Player[] players;
    private DicePool dicePool;
    private DicePool dicePicked;
    private DicePool diceBin;


    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", gamePlayerLinkId=" + gamePlayerLinkId +
                ", turnCounter=" + turnCounter +
                ", duration=" + duration +
                ", players=" + Arrays.toString(players) +
                ", dicePool=" + dicePool +
                ", dicePicked=" + dicePicked +
                ", diceBin=" + diceBin +
                '}';
    }

    public Game() {
    }

    public Game(int id, Player[] players, DicePool dicePool){
    	this.id = id;
        this.players = players;
        this.dicePool = dicePool;
        turnCounter = 0;
        dicePicked = new DicePool();
        diceBin = new DicePool();
    }

    public void pickDice(int num) {
        if (num < dicePool.size()) {
            // If there's enough dice, choose them randomly
            for (int i = 0; i < num; i++) {
                int index = (int) (Math.random() * dicePool.size());
                dicePool.moveTo(index, dicePicked);
            }
        } else {
            // else, choose them all
            dicePicked.addAll(this.dicePool);
            dicePool.clear();
        }
    }
    
    public void toBin(){
        for (int i = 0; i < dicePicked.size(); i++) {
            if (dicePicked.get(i).getResult() != Dice.ESCAPE_FACE) {
                dicePicked.moveTo(i, diceBin);
            }
        }
    }

    public void resetDicePool() {
        dicePool.addAll(dicePicked);
        dicePicked.clear();
        dicePool.addAll(diceBin);
        diceBin.clear();
    }
    
    public Player getActivePlayer(){
    	return players[turnCounter%players.length];
    }
    
    public int getNumberPlayer(){
    	return turnCounter%players.length;
    }
    
    public int getTurnCounter(){
    	return turnCounter;
    }
    public void setTurnCounter(int turn){
    	turnCounter = turn;
    }
    
    public long getDuration(){
    	return duration;
    }

    public void setDuration(long d){
    	duration = d;
    }

    public DicePool getDiceBin() {
        return diceBin;
    }
    
    public DicePool getDicePicked(){
    	return dicePicked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGamePlayerLinkId() {
        return gamePlayerLinkId;
    }

    public void setGamePlayerLinkId(int gamePlayerLinkId) {
        this.gamePlayerLinkId = gamePlayerLinkId;
    }
}
