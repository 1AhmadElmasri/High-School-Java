/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ahmad.icsu.u5.methodsAssignment;

import java.util.Scanner;

/**
 *
 * @author ahmad
 */

public class NumberOfWords2 {
static boolean isTeen = true;
static String holder = "";
    /**
     * @param args the command line arguments
     */
    
    public static void hundreds(char placeHolder){
        if(placeHolder != '0'){
            ones(placeHolder);
            holder = holder + " hundred";
        }
        
    }
    public static boolean teens(String places, boolean isTeen){
        switch (places) {
            case "11":
                holder = holder + " eleven";
                break;
            case "12":
                holder = holder + " twelve";
                break;
            case "13":
                holder = holder + " thirteen";
                break;
            case "14":
                holder = holder + " fourteen";
                break;
            case "15":
                holder = holder + " fifteen";
                break;
            case "16":
                holder = holder + " sixteen";
                break;
            case "17":
                holder = holder + " seventeen";
                break;
            case "18":
                holder = holder + " eightteen";
                break;
            case "19":
                holder = holder + " nineteen";
                break;
            default:
                isTeen = false;
                break;
        }
        return isTeen;
    }
    public static void tens(char place){
        switch(place){
            case '1':
                holder = holder + " ten";
                break;
            case '2':
                holder = holder + " twenty";
                break;
            case '3':
                holder = holder + " thirty";
                break;
            case '4':
                holder = holder + " fourty";
                break;
            case '5':
                holder = holder + " fifty";
                break;
            case '6':
                holder = holder + " sixty";
                break;
            case '7':
                holder = holder + " seventy";
                break;
            case '8':
                holder = holder + " eighty";
                break;
            case '9':
                holder = holder + " ninety";
                break;
            default:
                break;
        }
    }
    public static void ones(char place){
         switch(place){
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
    public static void parser(String parsed) {
        hundreds(parsed.charAt(0));
        if (!teens(parsed.substring(1, 3), isTeen)) {
            tens(parsed.charAt(1));
            ones(parsed.charAt(2));
        }
        
    }
    
    public static void trimmer(String trimmed){
        holder = holder.trim();
        for(int i = 0; i < holder.length(); i++){
            if(holder.charAt(i) == ' '){
                holder = holder.substring(0, i ) + holder.substring(i+1,holder.length());
            }
            System.out.println(holder);
        }
    }
    
    public static boolean isANumber(boolean isValid, String holder){
        try{
            int x = Integer.parseInt(holder);
            x = 0/x;
            isValid = true;
        }catch(Exception e){
            isValid = false;
        }
        return isValid;
    }
    
    public static void main(String[] args) {
        while(true){
        //Scanners and Variables
        Scanner input = new Scanner(System.in);
        boolean isValid = false;
        
        do {
            holder = input.nextLine();
            isValid = isANumber(isValid, holder);
            trimmer(holder);
           if(isValid){ 
            if (holder.length() <= 3) {
                while (holder.length() < 3) {
                    holder = "0" + holder;
                }
                parser(holder);
                System.out.println(holder);
            } else {
                System.out.println("Invalid input, the input has to be shorter than three digits");
            }
           }else{
               System.out.println("Invalid input, input has to be an integer "
                       + "between 1 and 999");
           }
            
        
        }while (!isValid);
        }
    }
    
}
