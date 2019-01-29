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
public class TelltheTime {

    /**
     * @param args the command line arguments
     */
    public static String trimmer(String holder) {
        holder = holder.trim();
        holder = holder.toLowerCase();
        for (int i = 0; i < holder.length(); i++) {
            if (holder.charAt(i) == ' ') {
                holder = holder.substring(0, i) + holder.substring(i + 1, holder.length());
            }
        }
        return holder;
    }

    public static String numberFormatFixer(String holder, int numberOfDigits, int lastDigit) {
        for (int i = 0; i < holder.length(); i++) {
            try {
                Integer.parseInt("" + holder.charAt(i));
                numberOfDigits++;
            } catch (Exception e) {
                lastDigit = i;
            }
        }
        if (numberOfDigits < 4) {
            holder = "0" + holder;
        }
        return holder;
    }

    public static boolean errorChecker(String holder, boolean validInput) {
        int hour = 0;
        int minute = 0;
        if (holder.charAt(2) == ':') {
            validInput = true;
        } else {
            System.out.println("Invalid input, colon is not in the right place");
        }

        try {
            hour = Integer.parseInt(holder.substring(0, 2));
            minute = Integer.parseInt(holder.substring(3, 5));
            validInput = true;
        } catch (Exception e) {
            System.out.println("Invalid input, numbers are wrong");
            validInput = false;
        }

        try {
            switch (holder.substring(5, holder.length())) {
                case "am":
                    validInput = true;
                case "pm":
                    if (hour <= 12 && hour >= 0 && minute <= 60 && minute >= 0) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid input, weird numbers");
                        validInput = false;
                    }
                    break;
                case "":
                    if (hour <= 24 && hour >= 0 && minute <= 60 && minute >= 0) {
                        validInput = true;
                        convertToTraditional(validInput, holder);
                        break;
                    } else {
                        System.out.println("Invalid numbers, too much or too little");
                        validInput = false;
                    }
                default:
                    validInput = false;
                    System.out.println("Invalid input");
                    break;
            }
        } catch (Exception e) {
            validInput = false;
            System.out.println("Invalid input");
        }

        return validInput;
    }

    public static boolean convertToTraditional(boolean validInput,String holder) {
        

        return validInput;
    }
    
    
    
    public static void main(String[] args) {
        //Scanners and variables
        Scanner input = new Scanner(System.in);
        String holder = "";
        int lastDigit = 0;
        int numberOfDigits = 0;
        boolean validInput = false;

        System.out.println("Standard Time");
        System.out.println("Thi program is meant to convert"
                + "standard to traditional time, or the other way around");
        System.out.println("Input the time in standard (hh:mm) or"
                + "traditional (hh:mm xx)");
        
        //fixes the forat
        do {
            holder = input.nextLine();
            holder = trimmer(holder);
            //System.out.println(holder);
            holder = numberFormatFixer(holder, numberOfDigits, lastDigit);
            System.out.println(holder);
            //System.out.println(holder);
        } while (!errorChecker(holder, validInput));
        System.out.println("valid input");

        
    }   
    
}
