package com.acme.bet.game;

import com.acme.bet.exception.GameArithmeticException;
import java.math.BigDecimal;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GameTest {
    private static MockedStatic<GameUtil> mockedGameUtil;

    @BeforeClass
    public static void init() {
        mockedGameUtil = mockStatic(GameUtil.class);
    }

    @Test
    public void givenProperNumber_ReturnsWin() {
        // * Win depends on chance - = bet * (99 / (100 - number)), as an example if player selected number 50 and bet 40.5, win would be 80,19
        when(GameUtil.getRandom()).thenReturn(49);
        Game game = new Game();
        BigDecimal win = game.run(BigDecimal.valueOf(40.5), 50);
        assertEquals("Base Example", 0, BigDecimal.valueOf(80.19).compareTo(win));
    }

    @Test
    public void givenNumberLessThanRandom_ReturnsZero() {
        when(GameUtil.getRandom()).thenReturn(2);
        Game game = new Game();
        BigDecimal win = game.run(BigDecimal.valueOf(1), 1);
        assertEquals("Loser Example", 0, BigDecimal.ZERO.compareTo(win));
    }

    @Test
    public void givenEqualRandomNumberandNumber_CauseArithmeticException() {
        when(GameUtil.getRandom()).thenReturn(100);
        Game game = new Game();
        assertThrows(GameArithmeticException.class, () -> game.run(BigDecimal.valueOf(1), 100));
    }

    @AfterClass
    public static void close() {
        mockedGameUtil.close();
    }

}
