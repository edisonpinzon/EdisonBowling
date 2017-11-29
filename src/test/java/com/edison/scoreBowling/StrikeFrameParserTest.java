/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
public class StrikeFrameParserTest {

    private static final String VALID_STRIKE_FRAME = "X";
    private static final String INVALID_STRIKE_FRAME = "7";

    private StrikeFrameParser strikeFrameParser;

    @Before
    public void setUp() {
        initializeStrikeFrameParser();
    }

    @Test
    public void ReturnStrikeFrame() {
        Frame result = strikeFrameParser.evaluate(VALID_STRIKE_FRAME);

        assertTrue(result instanceof StrikeFrame);
    }

    @Test
    public void ReturnNullFrame() {
        Frame result = strikeFrameParser.evaluate(INVALID_STRIKE_FRAME);

        assertNull(result);
    }

    private void initializeStrikeFrameParser() {
        strikeFrameParser = new StrikeFrameParser();
    }

}
