/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.edison.scoreBowling;

/**
 * FrameParser implementation created to return an StrikeFrame parser if the frame analyzed contains only one "X".
 * This FrameParser will return null if the analyzed frame is not an "X".
 *
 * @author edison
 */
class StrikeFrameParser implements FrameParser {

    private static final String STRIKE_FRAME = "X";

    @Override
    public Frame evaluate(String frame) {
        Frame result = null;
        if (STRIKE_FRAME.equals(frame)) {
            result = new StrikeFrame();
        }
        return result;
    }
}
