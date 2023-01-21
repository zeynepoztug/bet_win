package com.acme.bet.game;

import com.acme.bet.BetApplication;
import com.acme.bet.dto.BetRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

@SpringBootTest(classes = {BetApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class GameIT {

    @Test
    public void baseExample() {
        BetRequest request = new BetRequest();
        request.setBet(BigDecimal.valueOf(40.5));
        request.setNumber(50);

        // @todo mock server random value
        Game game = new Game(request);

        // todo compare result result
    }
}
