/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edison.scoreBowling;

/**
 * Represents a Frame inside a bowling line.
 *
 * @author edison
 */
interface Frame {
    
    String tFrame();
    
    void Edit(int FirstRoll,int SecondRoll,int LastBonusFrame);
    
    int FirstRoll();
    
    int SecondRoll();
    
    boolean getBonus();
    
    int getScore();

    boolean hasToDuplicateNextFrame();

    int getDuplicationDuration();

}
