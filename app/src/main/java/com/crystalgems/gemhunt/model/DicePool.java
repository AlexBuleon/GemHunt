package com.crystalgems.gemhunt.model;

import java.util.ArrayList;

public class DicePool extends ArrayList<Dice> {

    public DicePool() {
    }

    public DicePool(Dice[] dices) {
        for (int i = 0; i < dices.length; i++) {
            this.add(dices[i]);
        }
    }


    public void moveTo(int index, DicePool dicePool) {
        dicePool.add(this.get(index));
        this.remove(index);
    }

    public void moveTo(DicePool dicePool) {
        for (int i = 0; i < this.size(); i++) {
            dicePool.add(this.get(i));
            this.remove(i);
        }


    }
}
