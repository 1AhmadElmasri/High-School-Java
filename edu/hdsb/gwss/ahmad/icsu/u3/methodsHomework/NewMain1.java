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
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        while(true){
        Scanner input = new Scanner(System.in);
        String holder = input.nextLine();
        int variable = Integer.parseInt(holder);
        System.out.println(variable % 10 + " " + variable / 10 );
        }
    }
    
}
