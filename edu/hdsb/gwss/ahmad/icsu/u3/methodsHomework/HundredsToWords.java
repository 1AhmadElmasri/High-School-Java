/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ahmad.icsu.u3.methodsHomework;

import static edu.hdsb.gwss.ahmad.icsu.u3.methodsHomework.NumberToWords2.input;
import static edu.hdsb.gwss.ahmad.icsu.u3.methodsHomework.NumberToWords2.inputHolder;
import static edu.hdsb.gwss.ahmad.icsu.u3.methodsHomework.NumberToWords2.x;
import java.util.Scanner;

/**
 *
 * @author ahmad
 */
public class HundredsToWords {

    /**
     * @param args the command line arguments
     */
    public static String inputHolder;
    public static int number;
    public static boolean checker = false;
    public static boolean isTeen = false;
    public static int x;
    public static String output = "";
    
        public static boolean validator(boolean checker) {
        while (!checker) {
            try {
                inputHolder = input.nextLine();
                x = Integer.parseInt(inputHolder);
                checker = true;
            } catch (Exception e) {
                System.out.println("Invalid input. Try again");
            }
        }
        return checker;
    }
        
    public static void ones(int position){
        checker = true;
        switch(inputHolder.charAt(position)){
            case '1':
                output = output + " one";
                break;
            case '2':
                output = output + " two";
                break;
            case '3':
                output = output + " three";
                break;
            case '4':
                output = output + " four";
                break;
            case '5':
                output = output + " five";
                break;
            case '6':
                output = output + " six";
                break;
            case '7':
                output = output + " seven";
                break;
            case '8':
                output = output + " eight";
                break;
            case '9':
                output = output + " nine";
                break;
            default:
                break;           
        }
        
        
    }
    public static void hundreds(int position){
        ones(0);
        if(checker == true){
        output = output + " hundred";
        }
    }
    
        public static void tens(int position){
        switch(inputHolder.charAt(position)){
            case '1':
                teens(2);
                if (!checker) output = output + " ten";
                break;
            case '2':
                output = output + " twenty";
                break;
            case '3':
                output = output + " thirty";
                break;
            case '4':
                output = output + " forty";
                break;
            case '5':
                output = output + " fifty";
                break;
            case '6':
                output = output + " sixty";
                break;
            case '7':
                output = output + " seventy";
                break;
            case '8':
                output = output + " eighty";
                break;
            case '9':
                output = output + " ninety";
                break;
            default:
                break;           
        }
        if(isTeen == false) ones(2);
        }
        
        public static void teens(int position){
            isTeen = true;
        switch(inputHolder.charAt(position)){
            case '1':
                output = output + " eleven";
                break;
            case '2':
                output = output + " twelve";
                break;
            case '3':
                output = output + " thirteen";
                break;
            case '4':
                output = output + " forteen";
                break;
            case '5':
                output = output + " fifteen";
                break;
            case '6':
                output = output + " sixteen";
                break;
            case '7':
                output = output + " seventeen";
                break;
            case '8':
                output = output + " eighteen";
                break;
            case '9':
                output = output + " nineteen";
                break;
            default:
                isTeen = false;
                break;           
        }
        }
    

    
    public static void main(String[] args) {
        //SCanners
        Scanner input = new Scanner(System.in);
        validator(checker);
        number = inputHolder.length();
        if (inputHolder.length() % 3 != 0) {
            for (int i = number % 3; (3-i) > 0; i++) {
                inputHolder = "0" + inputHolder;
                System.out.println(inputHolder);
            }
        }
        
        hundreds(0);
        tens(1);
        System.out.println(output);
        
        
    }
    
}
