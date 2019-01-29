/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ahmad.icsu.u3.methodsHomework;

import java.util.Scanner;

/**
 *
 * @author ahmad
 */
public class NumberToWords {

    /**
     * @param args the command line arguments
     */
    public static int x;
    public static String holder;
    public static String inputHolder;
    public static boolean checker = false;
    public static Scanner input = new Scanner(System.in);
    
    
    
    
    
    //made to ensure it is an integer
    /*The reason it is like this is to be able to be copied and pasted into 
    other programs so I don't have to rewrite java code everytime
    */
    public static boolean validator(boolean checker) {
        while (!checker) {
            try {
                inputHolder = input.nextLine();
                inputHolder = inputHolder.trim();
                x = Integer.parseInt(inputHolder);
                checker = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Try again");
            }
        }
        return checker;
    }
    
public static void teens() {
        switch(inputHolder){
                case"11":
                    holder = "eleven";
                    break;
                case"12":
                    holder = "twelve";
                    break;
                case"13":
                    holder = "thirteen";
                    break;
                case"14":
                    holder = "fourteen";
                    break;
                case"15":
                    holder = "fifteen";
                    break;
                case"16":
                    holder = "sixteen";
                    break;
                case"17":
                    holder = "seventeen";
                    break;
                case"18":
                    holder = "eightteen";
                    break;
                case"19":
                    holder = "nineteen";
                    break;
        }
}
public static void tens() {
        switch(inputHolder.charAt(0)){
            case '1':
                holder = "ten";
                break;
            case '2':
                holder = "twenty";
                break;
            case '3':
                holder = "thirty";
                break;
            case '4':
                holder = "fourty";
                break;
            case '5':
                holder = "fifty";
                break;
            case '6':
                holder = "sixty";
                break;
            case '7':
                holder = "seventy";
                break;
            case '8':
                holder = "eighty";
                break;
            case '9':
                holder = "ninety";
                break;
        }
}
public static void ones() {
        switch(inputHolder.charAt(1)){
            case '1':
                holder = holder + " one";
                break;
            case '2':
                holder = holder + " two";
                break;
            case '3':
                holder = holder + " three";
                break;    
            case '4':
                holder = holder + " four";
                break;    
            case '5':
                holder = holder + " five";
                break;    
            case '6':
                holder = holder + " six";
                break;    
            case '7':
                holder = holder + " seven";
                break;
            case '8':
                holder = holder + " eight";
                break;
            case '9':
                holder = holder + " nine";
                break;
            default :
                break;
           
        }
}

//Should I do one for weird numbers and one for normal ones?
    

    public static void main(String[] args) {
        while (!checker) {
            validator(checker);
            checker = false;//generally this is bad coding, but I want to reuse it
            if (x >= 10 && x <= 99) {
               
                if (x >= 11 && x <= 19) {
                    teens();
                    System.out.println(holder);
                } else  {
                    tens();
                    ones();
                }
                System.out.println("You wrote " + x + " which is " + holder);
            } else {
                System.out.println("Number must be between 10 and 99");
            }
        }
        
       
        }
}
    






