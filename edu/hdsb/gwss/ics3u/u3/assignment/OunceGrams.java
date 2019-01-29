package edu.hdsb.gwss.ics3u.u3.assignment;


import java.text.NumberFormat;
import java.util.Scanner;

/*
 * Ounce to Grams
 * 30/03/2017
 * Ahmad Elmasri
 * This code is meant to print out a small table of conversion from grams to ounces
 * Version 1.0
 */
/**
 *
 * @author 1elmasriahm
 */
public class OunceGrams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Scanners and variables
        int numberOfIterations = 0;//Had to give this a value for the loop below
        double ounceConversion = 28.35;
        double weightOunces, weightGrams;
        Scanner input = new Scanner(System.in);
        boolean checker = false;
        String holder;

        
        //fraction digits
        NumberFormat number = NumberFormat.getNumberInstance();
        number.setMaximumFractionDigits(2);
        number.setMinimumFractionDigits(2);

        
        //intro
        System.out.println("Ounce to Gram Conversion Chart");
        System.out.println("The point of this program is to make a titled"
                + "table listing conversion from ounces to grams");
        System.out.println("This will be based on the number users put in (15"
                + "is recommended)");

        
        //asks users how many times they want to do things and checks input
        do {
            try {
                System.out.println("How many times would you like to convert?");
                holder = input.nextLine();
                numberOfIterations = Integer.parseInt(holder);//Had to parse through a line so it doesnt run infinitely
                if (numberOfIterations > 15 || numberOfIterations < 1) {
                    System.out.println("You can only do this between 1 and 15 times");
                } else {
                    checker = true;
                }
            } catch (Exception e) {//what happens if its wrong entirely
                System.out.println("Incorrect input. Can only be an integer");
            }
        } while (!checker);

        
        //printing loop
        System.out.format("%-10s %-10s", "Ounces", "Grams" + "\n");
        for (int i = 1; i < (numberOfIterations + 1); i++) {
            weightOunces = i;
            weightGrams = weightOunces * ounceConversion;
            System.out.format("%-10s %-10s", weightOunces, number.format(weightGrams) + "\n");
        }
    }

}
