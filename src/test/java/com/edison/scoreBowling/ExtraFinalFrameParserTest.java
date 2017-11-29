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
public class ExtraFinalFrameParserTest {

    private static final String VALID_EXTRA_FRAME = "5";
    private static final String INVALID_ZERO_FRAME = "X";

    private ExtraFinalFrameParser ExtraFrameParser;

    @Before
    public void setUp() {
        initializeExtraFrameParser();
    }

    @Test
    public void ReturnExtraFrame() {
        Frame result = ExtraFrameParser.evaluate(VALID_EXTRA_FRAME);
        assertTrue(result instanceof ExtraFinalFrame);
    }

    @Test
    public void ReturnNullFrame() {
        Frame result = ExtraFrameParser.evaluate(INVALID_ZERO_FRAME);

        assertNull(result);
    }

    private void initializeExtraFrameParser() {
        ExtraFrameParser = new ExtraFinalFrameParser();
    }

}
