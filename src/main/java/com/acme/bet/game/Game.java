package com.acme.bet.game;

import com.acme.bet.dto.BetRequest;

import java.math.BigDecimal;

public class Game {

    private BigDecimal win;

    public Game(BetRequest betRequest) {
        int randomNumber = Util.getRandom();

        // * Win depends on chance - = bet * (99 / (100 - number)), as an example if player selected number 50 and bet 40.5, win would be 80,19
        if (betRequest.getNumber() > randomNumber) {
            // calculate win
            // @todo performans ve hesap
            BigDecimal multiplier = BigDecimal.valueOf(99).divide(BigDecimal.valueOf(100 - betRequest.getNumber()));
            this.win = betRequest.getBet().multiply(multiplier);
        }
    }

    public BigDecimal getWin() {
        return win;
    }
}
