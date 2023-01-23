package com.acme.bet.exception;

public class GameException extends RuntimeException {

    public static final String GAME_EXCEPTION = "Oops, an error occurred.";

    private final int code = 1;

    public GameException() {
        super(GAME_EXCEPTION);
    }

    public int getCode() {
        return code;
    }
}

