package com.acme.bet.service;

import com.acme.bet.game.Game;
import com.acme.bet.game.GameUtil;
import com.acme.bet.utils.GameCounter;
import com.acme.bet.utils.TestUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

@Slf4j
@SpringBootTest
public class ServiceThreadSafetyTest {

    @Test
    void additional_task_run() {
        int numberOfThreads = 24;
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        CountDownLatch latch = new CountDownLatch(1000000);

        GameCounter counter = new GameCounter();
        for (int i = 0; i < 1000000; i++) {
            service.submit(() -> {
                try {
                    BigDecimal win = new Game().run(BigDecimal.ONE, GameUtil.getRandom());
                    counter.addToWin(win);
                } catch (Exception e) {
                    log.error("execute error", e);
                } finally {
                    latch.countDown();
                }
            });
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        service.shutdown();

        log.info("1 million games player has spent 1 million and had won {}, RTP is going to be {}%", counter.getWin(), TestUtils.percentage(counter.getWin()));
        assertEquals("Counter Matches", 1000000, counter.getCounter());
    }

    @Test
    void test_percentage() {
        BigDecimal percentage = TestUtils.percentage(new BigDecimal(990000));
        log.info("percentage:  {} %", percentage);
        assertEquals("Counter Matches", new BigDecimal(99), percentage);
    }

}
