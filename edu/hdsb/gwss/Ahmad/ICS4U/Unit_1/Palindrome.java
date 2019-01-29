/*
 * Name: Ahmad Elmasri
 * Date: 08/02/2018
 * Version: 1.0
 * Description: Takes in a word and sees if the word is a palindrome
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_1;

import java.util.Scanner;

/**
 *
 *  Day 05 - Palindrome
 * 
 * @author 1elmasriahm
 * @version 2017-18.S2
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        String originalWord, outputWord;
        
        System.out.println("Hello, I am a palindrome program");
        System.out.println("My task is to take in a string and see if is a palindrome");
        
        System.out.println("Input the word: ");
        originalWord = input.nextLine();
        System.out.println("\n -------------------------------------");
        
        originalWord = originalWord.toUpperCase();
        System.out.println(originalWord);
        outputWord = wordFlipper(originalWord);
        
        
        if(isPalindrome(originalWord)){
            System.out.println(originalWord + " flipped is " + outputWord + ", so it is a palindrome");
        }else{
            System.out.println(originalWord + " flipped is " + outputWord  + ", which is not a palindrome");
        }
        
        
        
    }
    
    
    
    public static String wordFlipper(String inputWord){
        inputWord = inputWord.trim();
        String outputWord = "";
        int wordLength = inputWord.length();
        
        for (int i = 1; i <= wordLength; i++) {
            outputWord += inputWord.charAt(wordLength - i);
        }
       
        outputWord = outputWord.trim();
        return outputWord;
    }
    
    public static boolean isPalindrome(String originalWord){
      boolean palindromeChecker = false;
      String outputWord = "";
      
      outputWord  = wordFlipper(originalWord);
      
      if(originalWord.equals(outputWord)){
          palindromeChecker = true;
      }
      
      return palindromeChecker;  
    }
    }
    


    

