package com.crystalgems.gemhunt.model;

public class Dice {
    public static final int GreenDice = 0;
    public static final int OrangeDice = 1;
    public static final int RedDice = 2;

    public static final int GEM_FACE = 0;
    public static final int ESCAPE_FACE = 1;
    public static final int MONSTER_FACE = 2;

    private int[] faces;
    private int result;
    private int color;

    public Dice(int color) {
    	this.color = color;
        switch (color) {
		case GreenDice:
			faces = new int[]{0, 0, 0, 1, 1, 2};
			break;
		case OrangeDice:
			faces = new int[]{0, 0, 1, 1, 2, 2};
			break;
		case RedDice:
			faces = new int[]{0, 1, 1, 2, 2, 2};
			break;

		default:
			break;
		}
    }

    public int getResult() {
        return result;
    }

    public int roll() {
        result = faces[(int) (Math.random() * faces.length)];
        return result;
    }
    
    public int getColor(){
    	return color;
    }
}
