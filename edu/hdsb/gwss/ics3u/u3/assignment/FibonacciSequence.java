package edu.hdsb.gwss.ics3u.u3.assignment;

/*
 * Fibonacci Sequence
 * 30/03/2017
 * Ahmad Elmasri
 * This code is meant to show the first 20 digits of the Fibonacci Sequence
 * Version 1.0
 */

/**
 *
 * @author 1elmasriahm
 */
public class FibonacciSequence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //intro
        System.out.println("Fibonacci Series");
        System.out.println("This program prints out the first 20 numbers of the"
                + " fibonacci sequence");
        //variables
        int numberA = 1;
        int numberB = 1; 
        int holder;
        System.out.print(numberA + ", ");
        System.out.print(numberB);
        for(int i = 0; i < 18; i++){
            holder = numberB;
            numberB = numberA + numberB;
            numberA = holder;
            System.out.print(", " + numberB) ;
        }
    }
    
}