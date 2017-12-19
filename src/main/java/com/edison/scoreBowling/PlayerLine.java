/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edison.scoreBowling;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Class of PlayerLine. The Main class have the responsability read and Extract Line from File and Create Object Player
 * that contains all lines.
 * Create the player for start to evaluate the score 
 * @author edison
 */
public class PlayerLine{
   
   public Set players = new HashSet();
   static String linePlayer;
   static ArrayList<Player> lPlayer = new ArrayList<>();
   public static ArrayList<String> pintFalls = new ArrayList<>();
  
    /**
     * 
     * @param Arraylist 
     **/
    public void LinePlayer(ArrayList<Player> lplayer) {
        Bowling bowling = new Bowling();
        setPlayers(lplayer);  
     
        for (Object player : players) {
            
            /***************Block Print******************/
            System.out.println(player);
            /***************Block Print******************/
            
            linePlayer = "";
            for (int i = 0; i < lplayer.size(); i++) {
                if (player.equals(lplayer.get(i).getPlayer())) {
                    linePlayer = linePlayer + lplayer.get(i).getScore();
                }
            }
            bowling.getScore(linePlayer);          
        }
       
    }
    /**
     * Create the players 
     * @param Arraylist 
     **/
    public  void setPlayers(ArrayList<Player> player) {         
         for (Player lplayer : player) {
            players.add(lplayer.getPlayer());
        } 
    }
    
     /**
     * Read the File and put each line into an Object Player ArrayList
     **/
    void readScoreFile(){
        
        String line = null;        
        File file  = new File("src\\main\\java\\com\\score\\txt\\bowling-game.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
               line = sc.nextLine();   
               String [] split = line.split(" ");
               Player player = new Player();
               player.setPlayer(split[0]);
                
               if (split[1].equals("10")) {
                player.setScore("X"); 
                }else{
                player.setScore(split[1]);
                }
               
               lPlayer.add(player);              
            }
           
            sc.close();           
        } catch (Exception e) {
        }        
         LinePlayer(lPlayer); 
    }
    
    /**
     * Main method when all start. :) 
     **/
    public static void main(String args[]){
      
        /***************Block Print******************/
        System.out.println("Frame       1       2       3       4       5       6       7       8       9       10");
        /***************Block Print******************/
         
        PlayerLine begin = new PlayerLine();
        begin.readScoreFile();            
    }
}
