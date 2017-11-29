/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.edison.scoreBowling;

/**
 * Interface created to represent one bowling frame parser. Different implementations will have to return different frames.
 * The class responsibility is transform one frame represented with String to a valid Frame implementation.
 *
 * @author edison
 */
interface FrameParser {

    /**
     * Evaluate the frame parameter and return null if no Frame matches with the parameter or one Frame if matches.
     *
     * @param frame to evaluate in string format.
     * @return frame transformed into an object.
     */
    Frame evaluate(String frame);

}
