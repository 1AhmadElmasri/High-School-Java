package edu.hdsb.gwss.ics3u.u3.assignment;

import java.util.Scanner;

/*
 * Closer to Two
 * 30/03/2017
 * Ahmad Elmasri
 * This code is meant to show how you can never get to the next number if you
 * keep adding half
 * Version 1.0
 */


/**
 *
 * @author 1elmasriahm
 */
public class CloserToTwoTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanners and Variables
        Scanner input = new Scanner(System.in);
        double starterNumber = 0; 
        double endingNumber = 0;
        double holder;
        double result;
        String inputHolder;
        boolean checker = false;
        long exponent = 0;
        
        //user introduction
        System.out.println("Closer To Two");
        System.out.println("The original point of this program was to prove "
                + "that theoretically if you add a half of a number each time to one,");
        System.out.println("you will never reach 2.");
        System.out.println("I realized it's more fun with scanners, though");
        
        
        //user input and verification
        do {
            System.out.println("What is the first number?");
            try {
                inputHolder = input.nextLine();
                starterNumber = Integer.parseInt(inputHolder);
                checker = true;
            } catch (Exception e) {
                System.out.println("The first number has to be an integer");
                continue;
            }
        } while (checker == false);

        //gives the values to the numbers
        endingNumber = starterNumber + 1;
        starterNumber = starterNumber - 1;

        //have to add one because we took one away due to looping purposes
        System.out.println("The two numbers are " + (starterNumber + 1)
                + " and " + endingNumber);

        
        //runs the loop
        while (starterNumber < endingNumber) {
            holder = 1 / Math.pow(2, exponent);
            result = starterNumber + holder;
            System.out.println(starterNumber + " + 1/" + (Math.pow(2, exponent)) + " = " + result);
            starterNumber = result;
            exponent++;
            System.out.println("Press enter to see the next operation");
            input.nextLine();//allows users to press enter to see the sequence evolve
        }
        
        exponent = exponent - 2;/*Java literaly doesnt show that anything was
        subtracted, so the exponent has to be made smaller*/
        System.out.println("\n" + (endingNumber - 1/Math.pow(2, exponent)) + " Is the closest number"
                + " to " + endingNumber + " that java can display in terms of double");
        System.out.println("If we had a much larger data type, we'd be able to display "
                + "an infinite number of digits");
        
    }
    
}
