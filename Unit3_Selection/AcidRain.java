/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit3_Selection;

import java.util.Scanner;

/**
 *
 * @author 1elmasriahm
 */
public class AcidRain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Acid Rain Detector
            /*
                Ahmad Elmasri
                20/03/2017
                Version 0.1
                This program is meant to determine if it's too alkaline or not
            */
        // It is too alkaline if it is below 6.4 or above 7.4
        
        //variables and scanners
        Scanner input = new Scanner(System.in);
        double alkalinityTest;
        final double BASIC = 7.4;
        final double ACIDIC = 6.4;
        
        
        //user intro to the program
        System.out.println("Hi there. I'm a simple alkilinity detector");
        System.out.println("If the results come back above 7.4, it is too"
                + "basic, and if it's below 6.4, too acidic");
        System.out.println("Once it is too alkaline, life cannot survive");
        
        //taking input
        System.out.println("\n So what is the alkalinity?");
        alkalinityTest = input.nextDouble();
        
        //processing
        if(alkalinityTest > 14 || alkalinityTest < 0){
            System.out.println("Sorry, but that is invalid alkilinity. The"
                    + " range is between 0 and 14, please try again");
        }
        else if( alkalinityTest > 7.4){
            System.out.println("TOO BASIC, FISH WON'T SURVIVE");
        }
        else if( alkalinityTest < 6.4){
            System.out.println("TOO ACIDIC, FISH WON'T SURVIVE");
        }
        else{
            System.out.println("Pond is neutral, fish will survive");
        }
    }
    
}
