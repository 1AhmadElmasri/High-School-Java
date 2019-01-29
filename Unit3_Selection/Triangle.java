/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit3_Selection;

import java.util.Scanner;

/**
 *
 * @author 1elmasriahm
 */
public class Triangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Triangle Detector
            /*
                Ahmad Elmasri
                21/03/2017
                Version 0.1
                This program is meant to determine if it's a triangle or not
            */
        /*The logic here is that if the two smallest sides of the trangle
            are already bigger than the largest side, then any otheroperation
            would yield a similar result, giving us a final answer*/
        
        //variables and scanners
        Scanner input = new Scanner(System.in);
        double sideA = 0;
        double sideB = 0;
        double sideC = 0;
        double holder;
        double checkingRightAngle;
        boolean validation = false;
        
        
        //intro for users
        System.out.println("Hello there. I'm a simple triangle detector");
        System.out.println("My job is to tell you whether or not three"
                + " sides make a triangle");
        System.out.println("This is based off the fact that if two sides"
                + "added together are larger than the other, they are a triangle");
        
        //taking input
        while (!validation){
        System.out.println("Please put in the first side");
        sideA = input.nextDouble();
        System.out.println("Please put in the second side");
        sideB = input.nextDouble();
        System.out.println("Please put in the third side");
        sideC = input.nextDouble();
        
        if(sideA <= 0 || sideB <= 0 || sideC <= 0){
            System.out.println("Invalid input, numbers have to be above 0");
            validation = false;
        }else{
            validation = true;
        }
        }
        
        
        
        //Orders the sides by size and swaps them with one another
        if(sideA > sideC){
            holder = sideA;
            sideA = sideC;
            sideC = holder;
            
        }
        if(sideA > sideB){
            holder = sideA;
            sideA = sideB;
            sideB = holder;
        }
        if(sideB > sideC){
            holder = sideB;
            sideB = sideC;
            sideC = holder;
        }
        
        
        System.out.println( "After: " + sideA + " " + sideB + " " + sideC );
        
        //checking if it is a triangle or not
        if(sideA + sideB > sideC){
            System.out.println("Hooray, it is a triangle!");
        }else{
            System.out.println("Sorry, not a triangle, try again");
        }
        
        
        checkingRightAngle = Math.pow(sideA, 2) + Math.pow(sideB, 2);
        if(checkingRightAngle == Math.pow(sideC, 2)){
            System.out.println("It is a right angle triangle, hooray!");
        }else{
            System.out.println("Sorry, not a right triangle, try again");
        }
        
        
        
    }
    
}
