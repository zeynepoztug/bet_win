package com.acme.bet.exception;

public class GameArithmeticException extends ArithmeticException {

    public static final String GAME_ARITHMETIC_EXCEPTION = "Cannot operate the mathematical expression.";

    public GameArithmeticException() {
        super(GAME_ARITHMETIC_EXCEPTION);
    }
}
