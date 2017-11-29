/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edison.scoreBowling;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 *
 * @author Jeff
 */
@Category(IntegrationTest.class)
public class PlayerLineTest {
    
    public PlayerLineTest() {
    }
    
    @Before
    public void setUp() {
        initializePlayerLine();
    }
    
    @After
    public void tearDown() {
    }
    


    /**
     * Test of LinePlayer method, of class PlayerLine.
     */
    @Test
    public void testLinePlayer() {       
        ArrayList<Player> lplayer = new ArrayList<>();
        PlayerLine instance = new PlayerLine();
        instance.LinePlayer(lplayer);      
    }

    /**
     * Test of setPlayers method, of class PlayerLine.
     */
    @Test
    public void testSetPlayers() {      
        ArrayList<Player> player = new ArrayList<>();
        PlayerLine instance = new PlayerLine();
        instance.setPlayers(player);       
      
    }

    /**
     * Test of readScoreFile method, of class PlayerLine.
     */
    @Test
    public void testReadScoreFile() {       
        PlayerLine instance = new PlayerLine();
        instance.readScoreFile();     
    }
    
    public void initializePlayerLine(){
    PlayerLine playerLine = new PlayerLine();
    }
    
}
