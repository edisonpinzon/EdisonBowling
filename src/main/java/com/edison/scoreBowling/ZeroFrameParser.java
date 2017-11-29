/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edison.scoreBowling;

/**
 * FrameParser implementation created to return a ZeroFrame if the frame analyzed contains is equals to "--".
 * This FrameParser will return null if the analyzed frame is not equals to "--".
 *
 * @author edison
 */
class ZeroFrameParser implements FrameParser {

    private static final String ZERO = "--";

    @Override
    public Frame evaluate(String frame) {
        Frame result = null;     
        if (isValidFrame(frame)) {
            result = new ZeroFrame();            
        }       
         return result; 
    }

    private boolean isValidFrame(String frame) {     
        return frame.length()==2 && ZERO.equals(frame);
    }

}
