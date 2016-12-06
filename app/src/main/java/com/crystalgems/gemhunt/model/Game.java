package com.crystalgems.gemhunt.model;

public class Game {
    private Player[] players;
    private DicePool dicePool;
    private DicePool dicePicked;
    private DicePool diceBin;


    public void pickDice(int num) {
        if (num > dicePool.size()) {
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

    public void resetDicePool() {
        dicePool.addAll(dicePicked);
        dicePicked.clear();
        dicePool.addAll(diceBin);
        diceBin.clear();
    }

    public Player[] getPlayers() {
        return players;
    }
}
