package com.crystalgems.gemhunt.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Player implements Parcelable, Comparable<Player> {

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    private String name;
    private int id;
    private int pictureId;
    private int turnScore;
    private int totalScore;
    private int penalty;
    private int penaltyCounter;
    private int rollCounter;
    private int rank;

    //independent of the game
    private int globalScore;
    private int globalPenalty;

    public Player(String name) {
        this.name = name;
        turnScore = 0;
        pictureId = 0;
        totalScore = 0;
        penalty = 0;
        globalPenalty = 0;
        penaltyCounter = 0;
        rollCounter = 0;
    }

    private Player(Parcel in) {
        name = in.readString();
        pictureId = in.readInt();
        turnScore = in.readInt();
        totalScore = in.readInt();
        penalty = in.readInt();
        penaltyCounter = in.readInt();
        rollCounter = in.readInt();
    }

    public Player() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", pictureId=" + pictureId +
                ", turnScore=" + turnScore +
                ", totalScore=" + totalScore +
                ", penalty=" + penalty +
                ", globalPenalty=" + globalPenalty +
                ", penaltyCounter=" + penaltyCounter +
                ", rollCounter=" + rollCounter +
                ", rank=" + rank +
                '}';
    }

    // Useless method
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(name);
        out.writeInt(pictureId);
        out.writeInt(turnScore);
        out.writeInt(totalScore);
        out.writeInt(penalty);
        out.writeInt(penaltyCounter);
        out.writeInt(rollCounter);
    }

    public void resetPlayer() {
        this.turnScore = 0;
        this.totalScore = 0;
        this.penalty = 0;
        this.penaltyCounter = 0;
        this.rollCounter = 0;
        this.rank = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public int getTurnScore() {
        return turnScore;
    }

    public void setTurnScore(int turnScore) {
        this.turnScore = turnScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public int getPenaltyCounter() {
        return penaltyCounter;

    }

    public void setPenaltyCounter(int penaltyCounter) {
        this.penaltyCounter = penaltyCounter;
    }

    public int getGlobalPenalty() {
        return globalPenalty;
    }

    public void setGlobalPenalty(int globalPenalty) {
        this.globalPenalty = globalPenalty;
    }

    public int getRollCounter() {
        return rollCounter;
    }

    public void setRollCounter(int rollCounter) {
        this.rollCounter = rollCounter;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getGlobalScore() {
        return globalScore;
    }

    public void setGlobalScore(int globalScore) {
        this.globalScore = globalScore;
    }

    @Override
    public int compareTo(Player o) {
        return this.totalScore - o.totalScore;
    }
}
