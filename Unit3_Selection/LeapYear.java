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
public class LeapYear {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Leap Year Detecttor
            /*
                Ahmad Elmasri
                20/03/2017
                Version 0.1
                This program is meant to determine if it's a leap year or not
            */
        /*It is a leap year if its divisible by 4 but not by 100, or it's
        divisible by 400*/
        
        //variables and scanners
        Scanner input = new Scanner(System.in);
        int currentYear;
        
        //into
        System.out.println("Hi there, I'm a leap year detector");
        System.out.println("It is a leap year if it is divisbile by 4 but not"
                + " 100, or it is divisible by 400");
        System.out.println("So, what is the year right now?");
        
        //taking input
        currentYear = input.nextInt();
        
        //processing
        if (currentYear <= 0) {
            System.out.println("Leap years were introduced in AD (after 0)."
                    + "Please try again");
        }
        else if(currentYear % 4 != 0 || currentYear % 100 == 0 && currentYear % 400 != 0){
            System.out.println("Not a leap year, sorry.");
        }
        else{
            System.out.println("It is a leap year");
        }
        
        
        
    }
    
}
