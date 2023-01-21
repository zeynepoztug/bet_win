package com.acme.bet.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertThrows;

@SpringBootTest
public class BetServiceUT {

    @Autowired
    IBetService service;

    @Test
    public void test() {
        assertThrows(NullPointerException.class, () -> service.bet(null));
    }

}
