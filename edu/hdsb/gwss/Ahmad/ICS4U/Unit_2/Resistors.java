/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_2;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author ahmad
 */
public class Resistors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner input =  new Scanner(System.in);
        StringTokenizer valueFinder;
        String holder;
        boolean allGood = false;
        int firstInt = 0, secondInt = 0, thirdInt = 0;
        
        String[] valueNames = { "BLACK",  "BROWN",  "RED", 
            "ORANGE",  "YELLOW",  "GREEN",  "BLUE",  "VIOLET",
             "GREY",  "WHITE"};
        
        int[] resistorValues = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        holder = input.nextLine();
        holder = holder.trim().toUpperCase();
        holder = holder.replaceAll(" ", holder);
        System.out.println(holder);
        
        
        valueFinder = new StringTokenizer(holder,"-");
        
        
        if (valueFinder.countTokens() == 3) {
                holder = valueFinder.nextToken();
                
                for (int j = 0; j < valueNames.length; j++) {
                    if (holder.equals(valueNames[j])) {
                       firstInt = resistorValues[j] * 10;
                       allGood = true;
                    }
                }
                
                holder = valueFinder.nextToken();
                allGood = false;
                for (int j = 0; j < valueNames.length; j++) {
                    if (holder.equals(valueNames[j])) {
                       secondInt = resistorValues[j];
                       allGood = true;
                    }
                }
                
                holder = valueFinder.nextToken();
                allGood = false;
                for (int j = 0; j < valueNames.length; j++) {
                    if (holder.equals(valueNames[j])) {
                       thirdInt = (int) Math.pow(10.0, ((double) resistorValues[j]));
                       allGood = true;
                    }
                }
            
        }
        
        if (allGood) {
            int finalAnswer = (firstInt + secondInt) * thirdInt;
            System.out.println("The value of the resistor is " + finalAnswer
             + " Ohms");
        }else{
            System.out.println("Invalid Input");
        }
        }
    
        
    }
    

