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
public class SpareFrameParserTest {

    private static final String VALID_SPARE_FRAME = "4/";
    private static final String INVALID_SPARE_FRAME = "7-";

    private SpareFrameParser spareFrameParser;

    @Before
    public void setUp() {
        initializeStrikeFrameParser();
    }

    @Test
    public void ReturnStrikeFrame() {
        Frame result = spareFrameParser.evaluate(VALID_SPARE_FRAME);

        assertTrue(result instanceof SpareFrame);
    }

    @Test
    public void ReturnNullFrame() {
        Frame result = spareFrameParser.evaluate(INVALID_SPARE_FRAME);

        assertNull(result);
    }

    private void initializeStrikeFrameParser() {
        spareFrameParser = new SpareFrameParser();
    }

}
