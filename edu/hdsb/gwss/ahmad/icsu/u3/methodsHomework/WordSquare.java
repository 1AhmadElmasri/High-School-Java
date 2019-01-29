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
public class WordSquare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanners and Variables
        Scanner input = new Scanner(System.in);
        String holder, newHolder;
        int length;
        
        
        holder = input.nextLine();
        holder = holder.toUpperCase();
        
        for(int i = 0; i < holder.length(); i++){
            newHolder = holder.substring(1, holder.length()) + holder.charAt(0);
            System.out.println(holder);
            holder = newHolder;
        }
        
    }
    
}
