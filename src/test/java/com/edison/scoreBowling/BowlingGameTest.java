/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edison.scoreBowling;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author edison
 */
@Category(IntegrationTest.class)
public class BowlingGameTest {

    private BowlingGame bowlingFrame;

    @Before
    public void setUp() {
        initializeBowlingFrame();
    }

    @Test
    public void ZeroScore() {
        for (int i = 0; i < 10; i++) {
            ZeroFrame zeroFrame = generateZeroFrame();
            bowlingFrame.addFrame(zeroFrame);
        }

        assertEquals(0, bowlingFrame.getScore());
    }


    @Test
    public void ReturnNormalFramesAsScore() {
        for (int i = 0; i < 10; i++) {
            NormalFrame normalFrame = generateNormalFrame(i);
            bowlingFrame.addFrame(normalFrame);
        }

        assertEquals(45, bowlingFrame.getScore());
    }


    @Test
    public void PerfectScore() {
        for (int i = 0; i < 12; i++) {
            StrikeFrame strikeFrame = generateStrikeFrame();
            bowlingFrame.addFrame(strikeFrame);
        }

        assertEquals(300, bowlingFrame.getScore());
    }

    @Test
    public void PerfectSpareScore() {
        for (int i = 0; i < 11; i++) {
            SpareFrame spareFrame = generateSpareFrame();
            bowlingFrame.addFrame(spareFrame);
        }

        assertEquals(150, bowlingFrame.getScore());
    }


    @Test
    public void SumOfFramesNormalWithSparesAndExtra() {
        bowlingFrame.addFrame(new NormalFrame(2, 3));
        bowlingFrame.addFrame(new NormalFrame(8, 1));
        bowlingFrame.addFrame(new NormalFrame(4, 3));
        bowlingFrame.addFrame(new StrikeFrame());
        bowlingFrame.addFrame(new StrikeFrame());
        bowlingFrame.addFrame(new SpareFrame(5));
        bowlingFrame.addFrame(new ZeroFrame());
        bowlingFrame.addFrame(new NormalFrame(1, 8));
        bowlingFrame.addFrame(new SpareFrame(5));
        bowlingFrame.addFrame(new StrikeFrame());
        bowlingFrame.addFrame(new StrikeFrame());
        bowlingFrame.addFrame(new StrikeFrame());
        bowlingFrame.addFrame(new ExtraFinalFrame(5));


        assertEquals(135, bowlingFrame.getScore());
    }

    @Test
    public void SumOfFramesNormalWithStrikesAndExtra() {
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new StrikeFrame());
        bowlingFrame.addFrame(new StrikeFrame());
        bowlingFrame.addFrame(new StrikeFrame());
        bowlingFrame.addFrame(new ExtraFinalFrame(5));

        assertEquals(111, bowlingFrame.getScore());
    }

    @Test
    public void SumOfFramesNormalWithSparesAndStrikesAndExtra() {
        bowlingFrame.addFrame(new SpareFrame(5));
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new SpareFrame(5));
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new NormalFrame(5, 4));
        bowlingFrame.addFrame(new StrikeFrame());
        bowlingFrame.addFrame(new StrikeFrame());
        bowlingFrame.addFrame(new StrikeFrame());
        bowlingFrame.addFrame(new ExtraFinalFrame(5));

        assertEquals(123, bowlingFrame.getScore());
    }

    private void initializeBowlingFrame() {
        bowlingFrame = new BowlingGame();
    }

    private ZeroFrame generateZeroFrame() {
        return new ZeroFrame();
    }

    private NormalFrame generateNormalFrame(int puntuation) {
        return new NormalFrame(puntuation, 0);
    }

    private StrikeFrame generateStrikeFrame() {
        return new StrikeFrame();
    }

    private SpareFrame generateSpareFrame() {
        return new SpareFrame(5);
    }

}
