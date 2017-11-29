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
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertTrue;

/**
 * Test created to check the correctness of LineParser.
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
@Category(IntegrationTest.class)
public class LineParserTest {

    private static final String ZERO = "--";
    private static final String STRIKE = "X";
    private static final String SPARE = "4/";
    private static final String NORMAL_FRAME = "8-";
    private static final String FULL_LINE = ZERO + STRIKE + SPARE + NORMAL_FRAME;

    @Mock
    private FrameParser mockedZeroFrameParser;
    @Mock
    private FrameParser mockedStrikeFrameParser;
    @Mock
    private FrameParser mockedSpareFrameParser;
    @Mock
    private FrameParser mockedNumeralFrameParser;
    @Mock
    private FrameParser mockedExtraFrameParser;

    private LineParser lineParser;

    @Before
    public void setUp() {
        initializeMocks();
        initializeLineParser();
    }

    @Test
    public void ZeroFrame() {
        when(mockedZeroFrameParser.evaluate(ZERO)).thenReturn(new ZeroFrame());
        List<Frame> frames = lineParser.parse(ZERO);
        assertTrue(frames.get(0) instanceof ZeroFrame);
    }

    @Test
    public void StrikeFrame() {
        when(mockedZeroFrameParser.evaluate(STRIKE)).thenReturn(new StrikeFrame());
        List<Frame> frames = lineParser.parse(STRIKE);
        assertTrue(frames.get(0) instanceof StrikeFrame);
    }

    @Test
    public void SpareFrame() {
        when(mockedZeroFrameParser.evaluate(SPARE)).thenReturn(new SpareFrame(0));
        List<Frame> frames = lineParser.parse(SPARE);
        assertTrue(frames.get(0) instanceof SpareFrame);
    }

    @Test
    public void NormalFrame() {
        when(mockedZeroFrameParser.evaluate(NORMAL_FRAME)).thenReturn(new NormalFrame(0, 0));
        List<Frame> frames = lineParser.parse(NORMAL_FRAME);
        assertTrue(frames.get(0) instanceof NormalFrame);
    }

    @Test
    public void TheFullParsed() {
        when(mockedZeroFrameParser.evaluate(ZERO)).thenReturn(new ZeroFrame());
        when(mockedZeroFrameParser.evaluate(STRIKE)).thenReturn(new StrikeFrame());
        when(mockedZeroFrameParser.evaluate(SPARE)).thenReturn(new SpareFrame(0));
        when(mockedZeroFrameParser.evaluate(NORMAL_FRAME)).thenReturn(new NormalFrame(0, 0));
        List<Frame> frames = lineParser.parse(FULL_LINE);

        assertTrue(frames.get(0) instanceof ZeroFrame);
        assertTrue(frames.get(1) instanceof StrikeFrame);
        assertTrue(frames.get(2) instanceof SpareFrame);
        assertTrue(frames.get(3) instanceof NormalFrame);
    }

    private void initializeMocks() {
        MockitoAnnotations.initMocks(this);
    }

    private void initializeLineParser() {
        Collection<FrameParser> parsers = getMockedParsers();
        lineParser = new LineParser(parsers);
    }

    private Collection<FrameParser> getMockedParsers() {
        Collection<FrameParser> parsers = new LinkedList<FrameParser>();
        parsers.add(mockedZeroFrameParser);
        parsers.add(mockedStrikeFrameParser);
        parsers.add(mockedSpareFrameParser);
        parsers.add(mockedNumeralFrameParser);
        parsers.add(mockedExtraFrameParser);

        return parsers;
    }


}
