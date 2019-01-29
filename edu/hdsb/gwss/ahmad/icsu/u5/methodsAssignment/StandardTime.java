/*
 * Standard Time
 * 22/04/2017
 * Ahmad Elmasri
 * This code converts Standard to Traditional and back
 * Version 1.0
 */
package edu.hdsb.gwss.ahmad.icsu.u5.methodsAssignment;

import java.util.Scanner;

/**
 *
 * @author 1elmasriahm
 */
public class StandardTime {

    /**
     * @param args the command line arguments
     */
    //Removes all whitespaces
    public static String trimmer(String holder) {
        holder = holder.trim(); 
        holder = holder.toLowerCase();
        for (int i = 0; i < holder.length(); i++) {
            if (holder.charAt(i) == ' ') {
                holder = holder.substring(0, i) + holder.substring(i + 1, holder.length());
                //skips out the spaces
            }
        }
        return holder;
    }
    
    // makes sure that input such as 1:13 turns into 01:13
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
        //This was just some code to fix a small error
    }

    //makes sure that the format in terms of colons and am is fine
    public static boolean errorChecker(String holder, boolean validInput) {
        if (holder.charAt(2) == ':') {
            validInput = true;
        } else {
            System.out.println("Invalid input, colon is not in the right place");
        }

        try {//try and catch were used due to the fact that users may input short data
            switch (holder.substring(5, holder.length())) {
                case "am":
                    validInput = convertToStandard(validInput, holder, 0);
                    break;
                case "pm":
                    validInput = convertToStandard(validInput, holder, 12);//adds 12 hours
                    break;
                case "":
                    validInput = convertToTraditional(validInput, holder);  
                    break;
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

        //converts the time into minutes and back into hours
    public static boolean convertToTraditional(boolean validInput,String holder) {
        try{
        int hour = Integer.parseInt(holder.substring(0, 2));
        int minute = Integer.parseInt(holder.substring(3, 5));
        if(hour <= 23 && hour >= 0 && minute <= 59 && minute >= 0){
            if(hour >=12){
                hour = ((12/hour) * (12)) + (hour%12);
                holder = hour + holder.substring(2, holder.length()) + "pm";
                System.out.println(holder + " Is the time in Traditional");
            }else{
                //if it is zero, then it converts it into 12
                hour = (int) ((Math.abs((hour - 12)) / 12) * 12) + hour;
                holder = hour + holder.substring(2, holder.length()) + "am";
                System.out.println(holder + " Is the time in Traditional");
            }
            
        }else{
            validInput = false;
            System.out.println("Invalid input, numbers are weird");
        }
        } catch(Exception e){
            System.out.println("Invalid input, numbers are wrong");
            validInput = false;
        }
        return validInput;
    }
  
    public static boolean convertToStandard(boolean validInput,String holder, int pm) {
        try{
        int hour = Integer.parseInt(holder.substring(0, 2));
        int minute = Integer.parseInt(holder.substring(3, 5));
        if(hour <= 12 && hour >= 0 && minute <= 59 && minute >= 0){
            hour = (hour % 12) + pm;
            holder = hour + holder.substring(2, holder.length()-2);
            System.out.println(holder + " Is the time in Standard");
        }else{
            validInput = false;
            System.out.println("Invalid input, numbers are weird");
        }
        
        } catch(Exception e){
            System.out.println("Invalid input, numbers are wrong");
            validInput = false;
        }
        return validInput;
    }
    public static void main(String[] args) {
        while(true){
        //Scanners and variables
        Scanner input = new Scanner(System.in);
        String holder = "";
        int lastDigit = 0;
        int numberOfDigits = 0;
        boolean validInput = false;
        
        //Intro to the program
        System.out.println("Standard Time");
        System.out.println("Thi program is meant to convert"
                + "standard to traditional time, or the other way around");
        System.out.println("Input the time in standard (hh:mm) or"
                + " traditional (hh:mm xx)");
        
        //Asks for input and calls on all the functions
        do {
            holder = input.nextLine();
            holder = trimmer(holder);//removes white space
            holder = numberFormatFixer(holder, numberOfDigits, lastDigit);
            System.out.println(holder);
        } while (!errorChecker(holder, validInput));
        System.out.println("valid input"); 
        }
    }     
}