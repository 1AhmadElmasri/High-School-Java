/*
 * Name: Ahmad Elmasri
 * Date: 08/02/2018
 * Version: 1.0
 * Description: Takes in a sentence and counts the palindromes
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_1;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 *  Day 05 - Palindrome
 * 
 * @author 1elmasriahm
 * @version 2017-18.S2
 */
public class Palindrome2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        String originalSentence, flippedWord, wordHolder;
        int palindromeCounter = 0;
        
        
        System.out.println("Hello, I am a palindrome program");
        System.out.println("My task is to take in a sentence and see how many palindromes it has");
        
        System.out.println("Input the sentence: ");
        originalSentence = input.nextLine();
        StringTokenizer st = new StringTokenizer(originalSentence, ", ");
        System.out.println("\n -------------------------------------");
        
        originalSentence = originalSentence.toUpperCase();
        while(st.hasMoreTokens()){
            wordHolder = st.nextToken();
            wordHolder = wordHolder.toUpperCase();
            if(isPalindrome(wordHolder)){
                flippedWord = wordFlipper(wordHolder);
                palindromeCounter ++;
                System.out.println(flippedWord);
            }
            
        }
        System.out.println("There are " + palindromeCounter + " palindromes in your sentence");
        
        
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
    


    

