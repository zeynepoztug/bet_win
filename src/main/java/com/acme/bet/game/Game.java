package com.acme.bet.game;

import com.acme.bet.exception.GameException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor
public class Game {

    public BigDecimal run(BigDecimal bet, int number) {
        int randomNumber = GameUtil.getRandom();
        if (number >= randomNumber) {
            try {
                BigDecimal multiplier = GameUtil.NINETY_NINE.divide(BigDecimal.valueOf(GameUtil.ONE_HUNDRED - number), 2, RoundingMode.HALF_EVEN);
                return bet.multiply(multiplier);
            } catch (ArithmeticException e) {
                log.error("ArithmeticException bet {} number {} random {} ", bet, number, randomNumber);
                log.error("ArithmeticException", e);
                throw new GameException();
            } catch (Exception e) {
                log.error("Unknown Game Exception bet {} number {} random {} ", bet, number, randomNumber);
                log.error("Unknown Game Exception", e);
                throw new GameException();
            }
        }
        return BigDecimal.ZERO;
    }
}
