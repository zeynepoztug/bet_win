package com.acme.bet.utils;


import java.math.BigDecimal;
import java.util.concurrent.Semaphore;

public class GameCounter {
    private final Semaphore semaphore = new Semaphore(1);
    private int counter;
    private BigDecimal win = BigDecimal.ZERO;

    public int getCounter() {
        return counter;
    }

    public BigDecimal getWin() {
        return win;
    }

    public void addToWin(BigDecimal bigDecimal) {
        try {
            semaphore.acquire();
            win = win.add(bigDecimal);
            counter++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}

