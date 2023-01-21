package com.acme.bet.game;

public class GameUtil {
    static final int min = 1;
    static final int max = 100;

    public static int getRandom() {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
