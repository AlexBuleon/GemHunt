package com.crystalgems.gemhunt.model;

public class Game {
	private int id;
	private int turnCounter;
	private long duration;
    private Player[] players;
    private DicePool dicePool;
    private DicePool dicePicked;
    private DicePool diceBin;

    
    public Game(int id, Player[] players, DicePool dicePool){
    	this.id = id;
    	this.players = new Player[players.length];
    	for(int i = 0; i < players.length; i++){
    		this.players[i] = players[i];
    	}
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
    	for (int i = 0; i<3; i++){
    		if(dicePicked.get(2-i).getResult() != Dice.ESCAPE_FACE){
    			dicePicked.moveTo(2-i, diceBin);
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
    
}
