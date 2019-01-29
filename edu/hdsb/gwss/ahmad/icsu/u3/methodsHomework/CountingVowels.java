/*
 * Ahmad Elmasri
 * Counting Vowels
 * 4/6/2017
 * This program is meant to count how many vowels are in a user's input
 * It has one if statement and a nested loop, so it searches through a string like an 
array and for each char, it searches a list of vowels like an array to match up, then
it moves on to the next one. This is to reduce the amount of if statements.

 */
package edu.hdsb.gwss.ahmad.icsu.u3.methodsHomework;

import java.util.Scanner;

/**
 *
 * @author ahmad
 */
public class CountingVowels {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanners and Variables
        Scanner input = new Scanner(System.in);
        String holder;
        char potentialVowel;
        int numberOfVowels = 0;

        holder = input.nextLine();
        holder = holder.toLowerCase();

        for (int i = 0; i < holder.length(); i++) {
            potentialVowel = holder.charAt(i);
            switch (potentialVowel) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    numberOfVowels++;
                    break;
                default:
                    numberOfVowels = numberOfVowels;
                    break;

            }
        }

        
        System.out.println("There are " + numberOfVowels + " "
                + "vowels in your sentence");
    }
    
}
