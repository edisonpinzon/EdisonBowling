/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edison.scoreBowling;

/**
 * FrameParser implementation created to return a NormalFrame if the frame analyzed contains is a valid NormalFrame.
 *
 * @author edison
 */
public class NormalFrameParser implements FrameParser {

    private static final String ZERO = "-";

    @Override
    public Frame evaluate(String frame) {
        Frame result = null;
        if (isValidFrame(frame)) {
            int firstThrow = getScore(frame.charAt(0) + "");
            int secondThrow = getScore(frame.charAt(1) + "");
            result = getFrame(firstThrow, secondThrow);
        }
        return result;
    }

    private boolean isValidFrame(String frame) {
        return frame.length() == 2;
    }

    private Frame getFrame(int firstThrow, int secondThrow) {
        return new NormalFrame(firstThrow, secondThrow);
    }

    private int getScore(String partialFrame) {
        int score = 0;
        if (!ZERO.equals(partialFrame)) {
            score = Integer.parseInt(partialFrame);
        }
        return score;
    }
}
