/*
                Ahmad Elmasri
                23/03/2017
                Version 0.1
                This program is meant to calculate the cost of mailing a letter
 */
package Unit3_Selection;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author 1elmasriahm
 */
public class LetterCost {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Body Mass Index

        //variables and scanner
        Scanner input = new Scanner(System.in);
        double cost,weight;
        boolean firstClass = false;
        String choice;
        NumberFormat money = NumberFormat.getCurrencyInstance();
        
        //intro
        System.out.println("Hi there, I'm a calculator for the cost of shipping"
                + "a letter.");
        System.out.println("But before we get started, do you ship first class");
        System.out.println("Type 'yes' for first class, or 'no' for second");
        
        choice = input.nextLine();
        
        //checking input and choosing
        switch (choice) {
            case "yes":
            case "Yes":
            case "YES":
                firstClass = true;
                System.out.println("First Class chosen");
                break;

            case "no":
            case "No":
            case "NO":
                firstClass = false;
                System.out.println("Second Class chosen");
                break;

            default:
                System.out.println("invalid input, try again");
                System.exit(0);
        }
        
        System.out.println("Now, what is the weight of the letter?");
        weight = input.nextDouble();
        
        if(weight > 30){
            
        }
        else if(weight<=30){
            cost = 0.4;
        }
    }

}
