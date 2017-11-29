/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edison.scoreBowling;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * class of Bowling Score. This class has the responsibility of instrument all the application dependencies and
 * create a facade to offer the implementation using a single access point.
 *
 * @author edison
 */
public class Bowling {

    private LineParser lineParser;

    //constructor Class
    public Bowling() {
        initializeLineEvaluator();
    }


    /**
     * Calculate the score of a roll sequence for a bowling game.
     *
     * @param rolls valid sequence of rolls in one line.
     * @return calculated score.
     */
    public int getScore(String rolls) {
        List<Frame> frames = lineParser.parse(rolls);
        return getScore(frames);
    }
    
    /**
     * initialize all evaluators
     */
    private void initializeLineEvaluator() {
        Collection<FrameParser> evaluators = new LinkedList<FrameParser>();
        evaluators.add(new StrikeFrameParser());
        evaluators.add(new SpareFrameParser());
        evaluators.add(new NormalFrameParser());
        evaluators.add(new ZeroFrameParser());
        evaluators.add(new ExtraFinalFrameParser());
        lineParser = new LineParser(evaluators);
    }
     /**
     * Create the sequence Frame for a bowling game.
     * @return bowlingGame getscore.
     **/
    private int getScore(final List<Frame> frames) {
        BowlingFrame bowlingGame = createBowlingGame(frames);
        return bowlingGame.getScore();
    }

    /**
     * createBowlingGame Add Frame in bowlingGame .
     **/
    private BowlingFrame createBowlingGame(List<Frame> frames) {       
        BowlingFrame bowlingGame = new BowlingFrame();       
        for (Frame frame : frames) {
            if(frame.getBonus()){
             bowlingGame.addBonus(frame);
            }else{
              bowlingGame.addFrame(frame);
            }            
        }
        return bowlingGame;
    }
  /*  
    public static void main(String []args){
    Bowling b = new Bowling();
        try {
        int score= b.getScore("XXXXXXXXXXXX");
            System.out.println("final:"+score);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } 
    }
    */
}
