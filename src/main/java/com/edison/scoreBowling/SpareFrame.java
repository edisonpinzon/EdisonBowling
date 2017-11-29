/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edison.scoreBowling;

/**
 * Frame implementation created to represent one spare.
 *
 * @author edison
 */
class SpareFrame implements Frame {

    private static final int SCORE = 10;
    private static final int DUPLICATE_DURATION = 1;
    private final int firstThrow;
    
    public SpareFrame(int firstThrow) {
      this.firstThrow=firstThrow;
    }
    
    
    @Override
    public int getScore() {
        return SCORE;
    }

    @Override
    public boolean hasToDuplicateNextFrame() {
        return true;
    }


    @Override
    public int getDuplicationDuration() {
        return DUPLICATE_DURATION;
    }

    @Override
    public boolean getBonus() {
        return false;
    }

 

    @Override
    public int FirstRoll() {
       return this.firstThrow;
    }

    @Override
    public int SecondRoll() {
        return SCORE;
    }

    @Override
    public void Edit(int FirstRoll, int SecondRoll, int LastBonusFrame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String tFrame() {
       return "Spare";
    }

  
}
