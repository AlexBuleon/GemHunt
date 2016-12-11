package com.crystalgems.gemhunt.model;

public enum Dice {
    GreenDice(new int[]{0, 0, 0, 1, 1, 2}),
    OrangeDice(new int[]{0, 0, 1, 1, 2, 2}),
    RedDice(new int[]{0, 1, 1, 2, 2, 2});

    public static final int GEM_FACE = 0;
    public static final int ESCAPE_FACE = 1;
    public static final int MONSTER_FACE = 2;

    private int[] faces;
    private int result;

    Dice(int[] faces) {
        this.faces = faces;
    }

    public int getResult() {
        return result;
    }

    public int roll() {
        result = faces[(int) (Math.random() * faces.length)];
        return result;
    }
}
