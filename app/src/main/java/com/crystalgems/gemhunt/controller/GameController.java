package com.crystalgems.gemhunt.controller;

import com.crystalgems.gemhunt.model.Dice;
import com.crystalgems.gemhunt.model.DicePool;
import com.crystalgems.gemhunt.model.Game;
import com.crystalgems.gemhunt.model.Player;

public class GameController {
	private Game game;
	private boolean victory;

	public GameController(Player[] players) {
		Dice[] dices = { Dice.GreenDice, Dice.GreenDice, Dice.GreenDice, Dice.GreenDice, Dice.GreenDice, Dice.GreenDice,
				Dice.OrangeDice, Dice.OrangeDice, Dice.OrangeDice, Dice.OrangeDice, Dice.RedDice, Dice.RedDice,
				Dice.RedDice };
		DicePool dicePool = new DicePool(dices);
		game = new Game(0, players, dicePool); //TODO : check database to create id or just only manage id with database and not class
	}

	/**
	 * start the game, end when one player win (dedicated thread)
	 */
	public void start() { //TODO : complete and thread
		victory = false;
		game.setDuration(System.currentTimeMillis()); // init time
		while(!victory){	//victory value only update at the end on a turn, can't trigger between rolls
			playDice();		//play a dice
			if(!rollAgain()){	//if you don't want to roll again or you just can't, pass turn
				passTurn();
			}
		}
		game.setDuration(System.currentTimeMillis() - game.getDuration()); //final duration of the game
		// TODO : add game recap screen
		saveData();
	}
	
	/**
	 * pick and play the 3 Dices
	 */
	private void playDice(){ //TODO : link with activity animation (Dices launch , eventually Dice pick)
		DicePool pool = game.getDicePicked();
		game.pickDice(3-pool.size());
		for(int i=0; i<3; i++){
			pool.get(i).roll();
		}
		passRoll();
	}
	
	/**
	 * check victory and update player datas before passing to next player turn
	 */
	private void passTurn() { // TODO : link with activity animation (passing turn to X)
		if(checkVictory())
			victory = true;
		updatePlayerTurn();
		game.setTurnCounter(game.getTurnCounter()+1);
		game.resetDicePool();
	}
	
	/**
	 * check penalty and update player datas before possible next dice roll
	 */
	private void passRoll(){ // TODO : link with activity animation (3 penalty => turn pass)
		updatePlayerRoll();
		game.toBin();
		if(checkPenalty()){
			game.getActivePlayer().setTurnScore(0);
			passTurn();
		}
	}
	
	/**
	 * update player's turn-ended datas
	 */
	private void updatePlayerTurn() { //TODO : link with activity animation (update total score)
		Player activePlayer = game.getActivePlayer();
		activePlayer.setTotalScore(activePlayer.getTotalScore() + activePlayer.getTurnScore());
		activePlayer.setTurnScore(0);
		activePlayer.setPenaltyCounter(activePlayer.getPenaltyCounter() + activePlayer.getPenalty());
		activePlayer.setPenalty(0);
	}
	
	/**
	 * update player's post-roll datas
	 */
	private void updatePlayerRoll(){ //TODO : link with activity animation (update penalty, turn score)
		Player activePlayer = game.getActivePlayer();
		DicePool pool = game.getDicePicked();
		for(int i = 0; i<3; i++){
			if (pool.get(i).getResult() == Dice.MONSTER_FACE)
				activePlayer.setPenalty(activePlayer.getPenalty() + 1);
			else if(pool.get(i).getResult() == Dice.GEM_FACE)
				activePlayer.setTurnScore(activePlayer.getTurnScore() + 1);
		}
		activePlayer.setRollCounter(activePlayer.getRollCounter() + 1);
	}
	
	/**
	 * check if the player want to roll again in his turn
	 * @return the player want another roll
	 */
	private boolean rollAgain(){ // TODO : link with activities (buttons for true/false)
		//if first roll, true
		if(game.getActivePlayer().getRollCounter() == 0)
			return true;
		return false;
	}

	/**
	 * check if the player have 3 penalties
	 * @return player have 3 penalties and must pass turn
	 */
	private boolean checkPenalty() {
		if(game.getActivePlayer().getPenalty() >= 3){
			return true;
		}
		return false;
	}

	/**
	 * check if the player won
	 * @return the player won the game
	 */
	private boolean checkVictory() {
		if(game.getActivePlayer().getTotalScore() >= 13){
			return true;
		}
		return false;

	}

	/**
	 * save game datas to the database
	 * @return query success
	 */
	private boolean saveData() { //TODO : everything
		return false;

	}
}
