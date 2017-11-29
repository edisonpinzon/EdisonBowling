/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.edison.scoreBowling;

import org.apache.commons.lang3.StringUtils;

/**
 * FrameParser implementation created to return a ExtraFinalFrame.
 *
 * @author edison
 */
class ExtraFinalFrameParser implements FrameParser {

  @Override
  public Frame evaluate(String frame) {
    Frame result = null;
    if (isValidFrame(frame)) {
      int bonusFrame = Integer.valueOf(frame);
      result = getFrame(bonusFrame);
    }
    return result;
  }

  private Frame getFrame(int bonus) {
    return new ExtraFinalFrame(bonus);
  }

  private boolean isValidFrame(String frame) {
    return frame.length()==1 && StringUtils.isNumeric(frame);
  }

}
