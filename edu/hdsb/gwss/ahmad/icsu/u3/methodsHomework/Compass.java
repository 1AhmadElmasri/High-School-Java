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
public class Compass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanners and Variables
        Scanner input = new Scanner(System.in);
        String holder;
        int charValue;
        int length;
        //32 is the code for space
        //intro
        System.out.println("Compass Directions");
        
        holder = input.nextLine();
        holder = holder.trim();
        holder = holder.toUpperCase();
        length = holder.length();
        
        
        
        //makes sure that user error(spaces) don't cause errors
        System.out.println(holder);
        for(int i = 0; i < length; i++){
            charValue = holder.codePointAt(i);
            if(charValue == ' '){
                holder = holder.substring(0, i ) + holder.substring(i+1,length);
                length--;
            }
            System.out.println(holder);
        }
        
        //Makes sure length is accurate
        if(holder.length() != 4){
            System.out.println("Invalid length. Try again");
        }else{
            System.out.println("Valid Length");
        }
        
        for(int i = 0; i < holder.length(); i++){
            charValue = holder.charAt(i);
            switch(charValue){
                case 'S':
                    System.out.println("Go south");
                    break;
                case 'N':
                    System.out.println("Go north");
                    break;
                case 'W':
                    System.out.println("Go west");
                    break;
                case 'E':
                    System.out.println("Go east");
                    break;
                default:
                    System.out.println("error, invalid input, try again");
            }
                    
        }
        
    }
    
}
