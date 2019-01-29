/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StandardForm;

import static java.lang.Math.sqrt;
import java.util.Scanner;

/**
 *
 * @author 1ELMASRIAHM
 */
public class Standard {

    /**
     * @param args the command line arguments
     */
    
    
            
    public static void main(String[] args) {
        // Scanner
            Scanner input = new Scanner(System.in);
            
        //objects
        double a,b,c,root1, root2;
            
        //Asks for input
        System.out.println("Hi there! This is a simple quadratic calculator.");
        System.out.println("What is the value of a?");
        a = input.nextDouble();
        System.out.println("What is the value of b?");
        b = input.nextDouble();
        System.out.println("What is the value of c?");
        c = input.nextDouble();
        
        
        //Processing
        root1 = (-(b) + sqrt(b*b - (4*a*c))) / (2*a);
        root2 = (-(b) - sqrt((b*b) - (4*a*c))) / (2*a);
        System.out.println(root1);
        System.out.println(root2);
        
    }
    
}
