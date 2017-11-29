/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edison.scoreBowling;

/**
 * Frame implementation created to represent one frame with Extra Bonus Ball  score.
 *
 *  @author edison
 */
class ExtraFinalFrame implements Frame {

    private int BONUS;
    private int firstThrow;
    private int secondThrow;

    public ExtraFinalFrame(int bonus) {
        this.BONUS = bonus;
    }

    @Override
    public int getScore() {     
        return BONUS;
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
        return true;
    }

    @Override
    public void Edit(int FirstRoll,int SecondRoll, int LastScoreFrame) {
    this.BONUS = LastScoreFrame;
    this.firstThrow=FirstRoll;
    this.secondThrow=SecondRoll;
  
    }

    @Override
    public int FirstRoll() {
        return  firstThrow;
    }

    @Override
    public int SecondRoll() {
       return 0;
    }

    @Override
    public String tFrame() {
      return "Final";
    }

   
}
