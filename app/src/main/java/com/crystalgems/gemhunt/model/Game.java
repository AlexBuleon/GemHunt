package com.crystalgems.gemhunt.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class Game implements Parcelable {
    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };
    private int id;
	private int turnCounter;
	private long duration;
    private Player[] players;
    private DicePool dicePool;
    private DicePool dicePicked;
    private DicePool diceBin;

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

    protected Game(Parcel in) {
        id = in.readInt();
        turnCounter = in.readInt();
        duration = in.readLong();
        players = in.createTypedArray(Player.CREATOR);
    }

    // Useless method
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(id);
        out.writeInt(turnCounter);
        out.writeLong(duration);
        out.writeTypedArray(players, flags);
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

    public void resetGame() {
        for (int i = 0; i < players.length; i++) {
            players[i].resetPlayer();
        }
    }
    
    public Player getActivePlayer(){
    	return players[turnCounter%players.length];
    }
    
    public int getPlayerNumber(){
    	return turnCounter%players.length;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
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

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", turnCounter=" + turnCounter +
                ", duration=" + duration +
                ", players=" + Arrays.toString(players) +
                ", dicePool=" + dicePool +
                ", dicePicked=" + dicePicked +
                ", diceBin=" + diceBin +
                '}';
    }
}
