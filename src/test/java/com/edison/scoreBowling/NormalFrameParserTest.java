/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edison.scoreBowling;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 *
 * @author edison
 */
@Category(IntegrationTest.class)
public class NormalFrameParserTest {

    private static final String VALID_FRAME = "81";
    private static final String INVALID_FRAME = "X";

    private NormalFrameParser normalFrameParser;

    @Before
    public void setUp() {
        initializeStrikeFrameParser();
    }

    @Test
    public void ReturnStrikeFrame() {
        Frame result = normalFrameParser.evaluate(VALID_FRAME);

        assertTrue(result instanceof NormalFrame);
    }

    @Test
    public void ReturnNullFrame() {
        Frame result = normalFrameParser.evaluate(INVALID_FRAME);

        assertNull(result);
    }

    private void initializeStrikeFrameParser() {
        normalFrameParser = new NormalFrameParser();
    }

}
