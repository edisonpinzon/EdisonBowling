/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edison.scoreBowling;

/**
 * Frame implementation created to represent one frame with score 0.
 *
 * @author edison
 */
class ZeroFrame implements Frame {

    private static final int SCORE = 0;

    @Override
    public int getScore() {
        return SCORE;
    }

    @Override
    public boolean hasToDuplicateNextFrame() {
        return false;
    }

    @Override
    public int getDuplicationDuration() {
        return 0;
    }

    @Override
    public boolean getBonus() {
        return false;
    }

    @Override
    public int FirstRoll() {
        return 0;
    }

    @Override
    public int SecondRoll() {
       return 0;
    }

    @Override
    public void Edit(int FirstRoll, int SecondRoll, int LastBonusFrame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String tFrame() {
        return "Zero";
    }

 
}
