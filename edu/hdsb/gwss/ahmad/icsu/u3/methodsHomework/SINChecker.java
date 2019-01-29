/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ahmad.icsu.u3.methodsHomework;

import java.util.Scanner;

/**
 *
 * @author 1elmasriahm
 */
public class SINChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanners, variables, and objects
        Scanner input = new Scanner(System.in);
        String holder = "";
        int evens = 0;
        int product = 0;
        int odds = 0;
        int checkDigit = 0;
        boolean validInput = false;

        System.out.println("Sin Checker");
        System.out.println("This number ensures whether"
                + "or not your SIN number is valid");
        System.out.println("Enter your SIN number:");

        
        do {
            holder = input.nextLine();
            holder = holder.trim();
            if (holder.length() == 9) {
                for (int i = 0; i < holder.length(); i++) {
                    if (holder.charAt(i) == ' ') {
                        holder = holder.substring(0, i) + holder.substring(i + 1, holder.length());
                    }
                }
                try {
                    product = Integer.parseInt(holder);
                    for (int i = 1; i < holder.length(); i = i + 1) {
                        product = 2 * (Integer.parseInt("" + holder.charAt(i)));
                        evens = evens + ((product % 10) + (product / 10));
                        System.out.println("product: " + product + " even: " + evens);
                        holder = holder.substring(0,i) + holder.substring(i+1, holder.length());
                        validInput = true;
                    }
                    for (int i = 0; i < holder.length()-1; i++) {
                        product = Integer.parseInt("" + holder.charAt(i));
                        odds = odds + product;
                        System.out.println("product: " + product + " odd: " + odds);
                        validInput = true;
                    }
                    product = evens + odds;
                    checkDigit = Integer.parseInt(holder.substring(holder.length()-1, holder.length()));
                    System.out.println(checkDigit);
                    if(((product+10) -(product%10)) - product == checkDigit){
                        System.out.println("The sin number is valid");
                    }else{
                        System.out.println("The sin number is invalid");
                        validInput = false;
                    }
                    
                } catch (Exception e) {
                    System.out.println("Invalid input, not a number");
                    validInput = false;
                }
            }else{
                System.out.println("Invalid length, try again");
                validInput = false;
            }
        } while (!validInput);
    }
}
