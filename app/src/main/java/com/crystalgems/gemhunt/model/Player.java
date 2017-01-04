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
    private int totalPenalty;
    private int penaltyCounter;
    private int rollCounter;
    private int rank;

    public Player(String name) {
        this.name = name;
        turnScore = 0;
        pictureId = 0;
        totalScore = 0;
        penalty = 0;
        totalPenalty = 0;
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
                ", totalPenalty=" + totalPenalty +
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

    public int getTotalPenalty() {
        return totalPenalty;
    }

    public void setTotalPenalty(int totalPenalty) {
        this.totalPenalty = totalPenalty;
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

    @Override
    public int compareTo(Player o) {
        return o.totalScore - this.totalScore;
    }
}
