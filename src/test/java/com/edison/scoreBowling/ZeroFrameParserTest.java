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
public class ZeroFrameParserTest {

    private static final String VALID_ZERO_FRAME = "--";
    private static final String INVALID_ZERO_FRAME = "4-";

    private ZeroFrameParser zeroFrameParser;

    @Before
    public void setUp() {
        initializeStrikeFrameParser();
    }

    @Test
    public void ReturnStrikeFrame() {
        Frame result = zeroFrameParser.evaluate(VALID_ZERO_FRAME);

        assertTrue(result instanceof ZeroFrame);
    }

    @Test
    public void ReturnNullFrame() {
        Frame result = zeroFrameParser.evaluate(INVALID_ZERO_FRAME);

        assertNull(result);
    }

    private void initializeStrikeFrameParser() {
        zeroFrameParser = new ZeroFrameParser();
    }

}
