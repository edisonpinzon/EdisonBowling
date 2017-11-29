/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edison.scoreBowling;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author edison
 */
@Category(IntegrationTest.class)
public class BowlingTest {

    private Bowling bowling;

    private Map<String, Integer> validRollsSequences;

    @Before
    public void setUp() {
        initializeBowling();
        initializeRollsSequences();
    }

    @Test
    public void CalculateScore() {
        for (String key : validRollsSequences.keySet()) {
            int result = bowling.getScore(key);
            int expectedResult = validRollsSequences.get(key);

            assertEquals(expectedResult, result);
        }
    }

    private void initializeBowling() {
        bowling = new Bowling();
    }

    private void initializeRollsSequences() {
        validRollsSequences = new HashMap<String, Integer>();
        validRollsSequences.put("XXXXXXXXXXXX", 300);
        validRollsSequences.put("9-9-9-9-9-9-9-9-9-9-", 90);
        validRollsSequences.put("555555555555555555555", 150);
        validRollsSequences.put("3/63X81XX9-7/44X9-", 151);
        validRollsSequences.put("X7/9-X-88/-6XXX81", 167);
    }

}
