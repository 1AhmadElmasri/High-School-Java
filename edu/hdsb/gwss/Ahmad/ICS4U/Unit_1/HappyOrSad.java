/*
 * Name: Ahmad Elmasri
 * Date: 10/02/2018
 * Version: 1.0
 * Description: Determine the overall mood of a message
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_1;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 *  Day 05 - Happy or Sad
 * 
 * @author 1elmasriahm
 * @version 2017-18.S2
 */
public class HappyOrSad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String sentenceInput;
        int happyFaces = 0;
        int sadFaces = 0;
        char holder;
        
        System.out.println("Hello, I am a program to determine the overall mood of a message");
        
        sentenceInput = input.nextLine();
        
        StringTokenizer st = new StringTokenizer(sentenceInput, " ,!.");
        
        
        for (int i = 0; i < sentenceInput.length(); i++) {
            if (i+2 < sentenceInput.length()) {
                if (sentenceInput.charAt(i)== ':') {
                    if (sentenceInput.charAt(i+1) == '-') {
                        if (sentenceInput.charAt(i+2) == '(') {
                            sadFaces++;
                        }else if (sentenceInput.charAt(i+2) == ')') {
                            happyFaces++;
                        }
                        
                    }
                }
            }
            
        }
        
        if (sadFaces > happyFaces) {
            System.out.println("sad");
        }else if (sadFaces < happyFaces) {
            System.out.println("happy");
        }else{
            System.out.println("neutral");
        }
        
    }
    
}
