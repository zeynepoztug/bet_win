package com.acme.bet.game;

import com.acme.bet.exception.GameArithmeticException;
import java.math.BigDecimal;

public class Game {

    public BigDecimal run(BigDecimal bet, int number) {
        int randomNumber = GameUtil.getRandom();
        if (number >= randomNumber) {
            try {
                BigDecimal multiplier = BigDecimal.valueOf(99).divide(BigDecimal.valueOf(100 - number));
                return bet.multiply(multiplier);
            } catch (ArithmeticException  e) {
                throw new GameArithmeticException();
            }
        }
        return BigDecimal.ZERO;
    }
}
