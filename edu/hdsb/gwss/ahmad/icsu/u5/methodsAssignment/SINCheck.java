/*
 * SIN Check
 * 22/04/2017
 * Ahmad Elmasri
 * This code is meant to check the SIN of a person and validate that it is 
 * a real SIN number
 * Version 1.0
 */
package edu.hdsb.gwss.ahmad.icsu.u5.methodsAssignment;

import java.util.Scanner;

/**
 *
 * @author 1elmasriahm
 */
public class SINCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanners, variables, and objects
        Scanner input = new Scanner(System.in);
        String holder = "";
        int evens = 0;
        int product = 0;//reusable variable 
        int odds = 0;
        int checkDigit = 0;
        boolean validInput = false;

        //intro
        System.out.println("Social Insurance Number");
        System.out.println("In Canada, all people are identified by the Government"
                + "with a Social Insurance Number (SIN) consisting of 9 digits");
        System.out.println("The first eight numbers"
                + "are assigned digits,while the last one is a digit check.");
        System.out.println("This program determines if the check digit is corrrect");

        //asks for user input and processes it if it is valid
        do {
            //reset all variables
            evens = 0;
            product = 0;
            odds = 0;
            checkDigit = 0;
            System.out.println("Enter a SIN number: ");
            holder = input.nextLine();
            holder = holder.trim();
            //tries to fix it if the user adds dashes or spaces
            if (holder.length() == 9) {
                //validates the input is actually good
                try {
                    product = Integer.parseInt(holder); //just to make sure it's a number
                    
                    //uses the numbers in the even spaces and takes them out
                    for (int i = 1; i < holder.length(); i = i + 1) {
                        product = 2 * (Integer.parseInt("" + holder.charAt(i)));
                        evens = evens + ((product % 10) + (product / 10));//gets the first and second digit of the product
                        System.out.println("product: " + product + " even: " + evens);
                        holder = holder.substring(0, i) + holder.substring(i + 1, holder.length());
                        validInput = true;
                    }
                    
                    //uses the numbers in the odd spaces
                    for (int i = 0; i < holder.length() - 1; i++) {
                        product = Integer.parseInt("" + holder.charAt(i));
                        odds = odds + product;
                        System.out.println("product: " + product + " odd: " + odds);
                        validInput = true;
                    }
                    
                    //adds the results up
                    product = evens + odds;
                    //gets the check digit
                    checkDigit = Integer.parseInt(holder.substring(holder.length() - 1, holder.length()));
                    System.out.println(checkDigit);//prints it out
                    //subtracts the next multiple of 10 and ensures it equals the check digit
                    if (((product + 10) - (product % 10)) - product == checkDigit) {
                        System.out.println("The SIN number is valid");
                    } else {
                        System.out.println("The SIN number is invalid");
                        validInput = false;
                    }

                } catch (Exception e) {
                    System.out.println("Invalid input, not a proper number");//if it fails
                    validInput = false;
                }
            } else {
                System.out.println("Invalid length, try again");
                validInput = false;
            }
        } while (!validInput);//tries again until the program is valid
    }
}
