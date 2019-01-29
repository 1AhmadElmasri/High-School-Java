/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QuadraticEquation;

import java.util.Scanner;

/**
 *
 * @author ahmad
 */
public class QuadraticStuff {

    public static void main(String[] args) {
        // This code will take the input of a user and print out the results
            Scanner quadin = new Scanner(System.in);
            //initializes the variables needed
            double x,y,c,result;
            
                //tells users what they have to do
                System.out.println("Hi there! This is a simple quadratic calculator meant to investigate 3x2 - 8X + 4");
                System.out.println("So what's the first possible value of x?");
                x = quadin.nextDouble(); //Scans for input
                result = 3*(x*x) - 8*x +4; //Takes in the input and calculates it
                System.out.println(result);  //outputs the results
                
                System.out.println("So what's the second possible value of x?");
                y = quadin.nextDouble();// bialzaboop
                result = 3*(y*y) - 8*y +4;
                System.out.println(result);
                
                System.out.println("So what's the third possible value of x?");
                c = quadin.nextDouble();
                result = 3*(c*c) - 8*c +4;
                System.out.println(result);
        }
    
}
