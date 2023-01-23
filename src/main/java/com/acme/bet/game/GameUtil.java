package com.acme.bet.game;

import java.math.BigDecimal;

public class GameUtil {

    public static final int ONE_HUNDRED = 100;
    public static final BigDecimal NINETY_NINE = new BigDecimal(99);
    static final int min = 1;
    static final int max = 99;

    public static int getRandom() {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
}
