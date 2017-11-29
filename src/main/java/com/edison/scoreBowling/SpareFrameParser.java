/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.edison.scoreBowling;

/**
 * FrameParser implementation created to return an SpareFrame parser if the frame analyzed contains only one "/" 
 * at the second char.
 * @author edison
 */
class SpareFrameParser implements FrameParser {

    private static final String SPARE = "/";

    @Override
    public Frame evaluate(String frame) {
        Frame result = null;
        if (isValidFrame(frame)) {
            String firstThrow = String.valueOf(frame.charAt(0));
            result = new SpareFrame(Integer.valueOf(firstThrow));
        }
        return result;
    }

    private boolean isValidFrame(String frame) {      
        return frame.length()==2 && SPARE.equals(frame.charAt(1) + "");
    }

}
