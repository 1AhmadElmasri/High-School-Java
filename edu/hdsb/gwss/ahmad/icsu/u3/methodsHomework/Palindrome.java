/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ahmad.icsu.u3.methodsHomework;

import static java.time.Clock.system;
import java.util.Scanner;

/**
 *
 * @author ahmad
 */
public class Palindrome {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanners and Variables
        Scanner input = new Scanner(System.in);
        String holder, newHolder;
        String carrier = "";
        int length;
        
        
        holder = input.nextLine();
        holder = holder.toUpperCase();
        length = holder.length()-2;
        
        for(int i = 0; i <= length; i++){
            carrier = carrier + holder.substring(holder.length()-1) ;
            newHolder = holder.substring(0,holder.length()-1);
            holder = newHolder;
            newHolder = carrier + ""+newHolder;
            
            
            System.out.println(newHolder);
            
        }
        
    }
    
}
