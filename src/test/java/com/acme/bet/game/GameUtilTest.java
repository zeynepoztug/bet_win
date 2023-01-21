package com.acme.bet.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockedStatic;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class GameUtilTest {

    @Test
    public void mockGameUtilGetRandom() {
        MockedStatic mockedStatic = mockStatic(GameUtil.class);
        when(GameUtil.getRandom()).thenReturn(49);
        assertEquals("Mocking GameUtil", 49, GameUtil.getRandom());
        mockedStatic.close();
    }

    @Test
    public void gameUtilGetRandomConditions() {
        int random = GameUtil.getRandom();
        assertTrue("Random Conditions", random >= 1 && random <= 100);
    }

}
