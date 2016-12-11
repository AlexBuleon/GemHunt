package com.crystalgems.gemhunt.model;

import java.util.ArrayList;

public class DicePool extends ArrayList<Dice> {

	public DicePool(){
	}
	
	public DicePool(Dice[] dices){
		for(int i = 0; i < dices.length; i++){
			this.add(dices[i]);
		}
	}
	
	
    public void moveTo(int index, DicePool dicePool) {
        dicePool.add(this.get(index));
        this.remove(index);
    }
}
