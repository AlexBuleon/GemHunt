package com.crystalgems.gemhunt.model;

public class Player {
	private String name;
	private int turnScore;
	private int totalScore;
	private int penalty;
	private int penaltyCounter;
	private int rollCounter;

	public Player(String name) {
		this.name = name;
		turnScore = 0;
		totalScore = 0;
		penalty = 0;
		penaltyCounter = 0;
		rollCounter = 0;
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

	public int getRollCounter() {
		return rollCounter;
	}

	public void setRollCounter(int rollCounter) {
		this.rollCounter = rollCounter;
	}
}
