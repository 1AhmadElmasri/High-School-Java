/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarchBreakHomework;

import java.util.Scanner;

/**
 *
 * @author ahmad
 */
public class Y2KDetector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //This code is to detec if the Y2K problem is happening or not
        
        //variables and scanners
        Scanner input = new Scanner(System.in);
        int yearOfBirth = 0; 
        int currentYear = 0;
        int age;
        boolean checker = false;
        String holder;
        
        //intro
        System.out.println("Hi there. I offer a solution to the Y2K problem");
        System.out.println("I am a simple program meant to detect Y2K");
        System.out.println("So, in two integer digits, what year were you born on?");
        
        
        //validating input of the year of birth
        while (!checker) {
            try {
                holder = input.nextLine();
                yearOfBirth = Integer.parseInt(holder);
                checker = true;
                continue;
            } catch (Exception e) {
                System.out.println("Incorrect input. Put in two digits");
                checker = false;
            }
        }
        
        //validating input of the current year
        System.out.println("What is the year right now?");
        checker = false;
        while (!checker) {
            try {
                holder = input.nextLine();
                currentYear = Integer.parseInt(holder);
                checker = true;
                continue;
            } catch (Exception e) {
                System.out.println("Incorrect input. Put in two digits");
                checker = false;
            }
        }
        
        //processing input
        if(currentYear == yearOfBirth){
            System.out.println(" ");
            System.out.println("Y2K detected");
            System.out.println("You are either 0 or 100");
        }else{
            if(currentYear < yearOfBirth){
                age = (currentYear + 100) - yearOfBirth;
                System.out.println("You are " + age +" years old");
            }else{
                age = currentYear - yearOfBirth;
                System.out.println("You are " + age +" years old");
            }
        }
        
        
    }
    
}
