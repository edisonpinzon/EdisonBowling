/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edison.scoreBowling;

/**
 * Frame implementation created to represent a normal frame.
 *
 * @author edison
 */
class NormalFrame implements Frame {

    private final int firstThrow;
    private final int secondThrow;

    public NormalFrame(int firstThrow, int secondThrow) {
        this.firstThrow = firstThrow;
        this.secondThrow = secondThrow;
    }

    @Override
    public int getScore() {
        return firstThrow + secondThrow;
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
       return this.firstThrow;
    }

    @Override
    public int SecondRoll() {
      return this.secondThrow;
    }

    @Override
    public void Edit(int FirstRoll, int SecondRoll, int LastBonusFrame) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String tFrame() {
       return "Normal";
    }

}
