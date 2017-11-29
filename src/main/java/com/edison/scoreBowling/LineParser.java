/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edison.scoreBowling;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * Class created to parse an String representing a bowling line and return Frames with different implementations.
 *
 * @author edison
 */
class LineParser {

    public  final char ONE_CHAR_VALID_FRAME = 'X';
    public  final char SPARE = '/';
    private final Collection<FrameParser> evaluators;
    private int parsingIndex;
    int countparseFrame;
    /**
     * Construcotr 
     *  @param a Collection different implementations FrameParser
     **/
    public LineParser(Collection<FrameParser> evaluator) {
        this.evaluators = evaluator;
    }

    /**
     * Analyze one line and return a List<Frame> with the associated value for each frame.
     *
     * @param line to split in different frames.
     * @return List<Frame>
     */
    public List<Frame> parse(final String line) {
        List<Frame> frames = new LinkedList<Frame>();
        countparseFrame = 1;
        System.out.print("PinFalls  ");
        for (parsingIndex = 0; parsingIndex < line.length(); parsingIndex++) {           
            Frame frame = parseFrame(line);
            frames.add(frame);       
        }
         System.out.println();
        return frames;
    }
    
     /**
     * @return boolean validate is One Char Frame Apply to Strike Frame
     **/
    private boolean isOneCharFrame(String line, int i) {
        return line.charAt(i) == ONE_CHAR_VALID_FRAME;
        
    }
    
    /**
     * Parse the String Line get type Substring and send to Analyze in getFrame Method
     * @param String 
     * @return type of Frame
     **/
    private Frame parseFrame(String line) {
        String frameToAnalyze;       
        int FirstThrow=0,SecondThrow=0,sumFrame;
        
        
        if (isOneCharFrame(line, parsingIndex)) {
        	    if(countparseFrame==10) {countparseFrame=9;}
                frameToAnalyze = line.charAt(parsingIndex) + "";
        } else if (countparseFrame <= 10) {
            frameToAnalyze = line.substring(parsingIndex, parsingIndex + 2); 
            if(StringUtils.isNumeric(String.valueOf(frameToAnalyze.charAt(0)))){
              FirstThrow = Integer.valueOf(String.valueOf(frameToAnalyze.charAt(0)));
            }
            if(StringUtils.isNumeric(String.valueOf(frameToAnalyze.charAt(1)))){
             SecondThrow = Integer.valueOf(String.valueOf(frameToAnalyze.charAt(1)));
            }
            sumFrame=FirstThrow+SecondThrow; 
            if (sumFrame== 10) {
                frameToAnalyze = String.valueOf(FirstThrow) + String.valueOf(SPARE);
            } 
            parsingIndex++;
        } else {           
            frameToAnalyze = line.substring(parsingIndex, parsingIndex + 1);
        }
        /***************Block Print******************/
        Print(frameToAnalyze);
        /***************Block Print******************/
      
        countparseFrame++;
        return getFrame(frameToAnalyze);
    }
    
    /***************Method Print******************/
    void Print(String line) {
        if (line.equals(String.valueOf(ONE_CHAR_VALID_FRAME))) {
            System.out.print("      " + line);               
        } else if (line.length()==1) {
            System.out.print("   " + line.charAt(0));
        } else {
            System.out.print("   " + line.charAt(0) + "   " + line.charAt(1));
        }
    }

     /**
     * Evaluate String frameToAnalyze belongs which Frame Evaluator
     * @param String 
     * @return type of Frame
     **/
    private Frame getFrame(String frameToAnalyze) {
        Frame result = null;   
       
        for (FrameParser frameParser : evaluators) {           
                Frame frame = frameParser.evaluate(frameToAnalyze);             
                if (frame != null) {  
                result = frame;
                break;
                }         
        }
        return result;
    }

}
