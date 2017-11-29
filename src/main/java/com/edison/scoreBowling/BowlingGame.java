/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package com.edison.scoreBowling;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a bowling game.
 * will be able to use this entity to indicate a new Frame and will return the result using getScore() method.
 *
 * @author edison
 */
class BowlingGame {

    private  final int FRAMES_PER_GAME = 10;

    private List<Frame> frames = new LinkedList<Frame>();

     /**
     * Remove last Frame and replace for FinalExtraFrame .
     **/
    void addBonus(Frame frame){
        int updateBonusFrame = frame.getScore()+frames.get(FRAMES_PER_GAME-1).getScore();    
        frame.Edit(frames.get(FRAMES_PER_GAME-1).FirstRoll(),frames.get(FRAMES_PER_GAME-1).SecondRoll(),updateBonusFrame);
        frames.remove(FRAMES_PER_GAME-1);   
        frames.add(frame); 
    }
    
    void addFrame(Frame frame) {
        frames.add(frame);
    }

     /**
     * Calculated Score for each Frame and evaluated shouldDuplicateNextScores.
     **/
    int getScore() {
        int score = 0;
        
        /***************Block Print******************/
        System.out.print("Score       ");
        /***************Block Print******************/
       
        for (int currentFrame = 0; currentFrame < FRAMES_PER_GAME; currentFrame++) {           
            Frame frame = frames.get(currentFrame);
            score = incrementScore(score, frame);
            if (shouldDuplicateNextScores(frame)) {
                score = duplicateNextScores(score, currentFrame, frame);              
            } 
           /***************Block Print******************/
            if (score<99) {
                 System.out.print(score+"      ");
            }else{
                 System.out.print(score+"     ");
            }
           /***************Block Print******************/
        } 
        /***************Block Print******************/
        System.out.println();
        /***************Block Print******************/
        return score;
    }
     
    /**
     * @return score for the Line.
     **/
    private int incrementScore(int score, Frame frame) {
        return score + frame.getScore();
    }

    /**
     * @return boolean shouldDuplicateNextScores.
     **/
    private boolean shouldDuplicateNextScores(Frame frame) {
        return frame.hasToDuplicateNextFrame() && frame.getDuplicationDuration() > 0;
    }

     /**
     * Calculated Score for each shouldDuplicateNextScores.
     * @return score
     **/
    
    private int duplicateNextScores(int score, int currentFrame, Frame frame) {

        int topNextFrame = currentFrame + 1;
        if (frame.getDuplicationDuration() == 1) {

            score = score + frames.get(topNextFrame).FirstRoll();
        } else if (frame.getDuplicationDuration() == 2) {

            if (frames.get(topNextFrame).tFrame() == "Strike") {
                score = score + frames.get(topNextFrame).getScore();
                topNextFrame++;
                if (frames.get(topNextFrame).tFrame() == "Strike") {
                    score = score + frames.get(topNextFrame).getScore();
                } else {
                    score = score + frames.get(topNextFrame).FirstRoll();
                }
            } else if (frames.get(topNextFrame).tFrame() == "Spare") {
                score = score + frames.get(topNextFrame).getScore();
            } else {
                score = score + frames.get(topNextFrame).FirstRoll() + frames.get(topNextFrame).SecondRoll();
            }

        }
        return score;
    }

}
