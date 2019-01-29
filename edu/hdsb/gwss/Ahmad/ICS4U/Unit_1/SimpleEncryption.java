/*
 * Name: Ahmad Elmasri
 * Date: 10/02/2018
 * Version: 1.0
 * Description: Simple encryption by rotating letters
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_1;

import static java.lang.Integer.parseInt;
import java.util.Scanner;

/**
 *
 *  Day 05 - Simple Encryption
 * 
 * @author 1elmasriahm
 * @version 2017-18.S2
 */
public class SimpleEncryption {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        
        String originalSentence, modifiedSentence, wordHolder, outputSentence = "";
        
        int charValue,spinValue;
        System.out.println("This program will encrypt or decrypt a phrase using"
                + "\nthe simple encryption method of rotating the letters");
        System.out.println("=============================================\n");
        System.out.println("Input 1 for encryption, 2 for decryption");
        choice = parseInt(input.nextLine());
        
        
        
        //StringTokenizer st = new StringTokenizer(modifiedSentence, ",.! ");
        
        System.out.println("\nNow input the rotation amount in whole integers: ");
        spinValue = parseInt(input.nextLine());
        
        System.out.println("----------------------------------------------------\n");
        System.out.println("Now input the phrase");
        
        originalSentence = input.nextLine();
        
        modifiedSentence = originalSentence;
        modifiedSentence = originalSentence.toUpperCase();
        
        if (choice == 1) {
            modifiedSentence = encryptor(modifiedSentence, spinValue);
        }else{
            modifiedSentence = decryptor(modifiedSentence, spinValue);
        }
        
        
        System.out.println(modifiedSentence);
        
        
        
        
        
    }
    public static String encryptor(String modifiedSentence, int spinValue){
        int charValue;
        spinValue = Math.abs(spinValue);
        String outputSentence = "";
        for(int i = 0; i < modifiedSentence.length(); i++) {
            
            charValue = (int) modifiedSentence.charAt(i);
            
            if (charValue > 64 && charValue < 91) {
                charValue = charValue + spinValue;
                
                while(charValue>90){
                    charValue = (charValue - 90) + 64;
                }
                
            }
           outputSentence += (char) charValue; 
        }
        return outputSentence;
    }
    
    public static String decryptor(String modifiedSentence, int spinValue){
        int charValue;
        spinValue = Math.abs(spinValue);
        String outputSentence = "";
        for(int i = 0; i < modifiedSentence.length(); i++) {
            
            charValue = (int) modifiedSentence.charAt(i);
            if (charValue > 64 && charValue < 91) {
                charValue = Math.abs(charValue - spinValue);
                
                while(charValue<65){
                    charValue = (charValue - 64) +90;
                }
                
            }
           outputSentence += (char) charValue; 
        }
        return outputSentence;
    }
    
}
