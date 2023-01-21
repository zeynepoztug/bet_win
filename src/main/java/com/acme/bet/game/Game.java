package com.acme.bet.game;

import java.math.BigDecimal;

public class Game {

    public BigDecimal run(BigDecimal bet, int number) {
        int randomNumber = GameUtil.getRandom();
        if (number > randomNumber) {
            BigDecimal multiplier = BigDecimal.valueOf(99).divide(BigDecimal.valueOf(100 - number));
            return bet.multiply(multiplier);
        }
        return BigDecimal.ZERO;
    }
}
