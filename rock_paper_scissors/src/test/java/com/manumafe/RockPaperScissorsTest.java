package com.manumafe;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;

public class RockPaperScissorsTest {
    private RockPaperScissors rockPaperScissors;

    @BeforeEach
    public void setup() {
        rockPaperScissors = new RockPaperScissors();
    }

    
    @Test
    public void testRockWinOverScissors() {
        assertThat(rockPaperScissors.logic(0, 2)).isEqualTo(GameResult.WIN);
    }

    @Test
    public void testPaperWinOverRock() {
        assertThat(rockPaperScissors.logic(1, 0)).isEqualTo(GameResult.WIN);
    }

    @Test
    public void testScissorsWinOverPaper() {
        assertThat(rockPaperScissors.logic(2, 1)).isEqualTo(GameResult.WIN);
    }

    @Test
    public void testDraw() {
        assertThat(rockPaperScissors.logic(1, 1)).isEqualTo(GameResult.DRAW);
    }
    
    @Test
    public void testRockLostOverPaper() {
        assertThat(rockPaperScissors.logic(0, 1)).isEqualTo(GameResult.LOST);
    }
}
