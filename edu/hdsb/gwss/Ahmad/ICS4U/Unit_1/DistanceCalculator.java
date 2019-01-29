/*
 * Name: Ahmad Elmasri
 * Date: 08/02/2018
 * Version: 1.0
 * Description: Uses the curvature of earth to calculate distance between two places
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_1;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

/**
 *
 *  Day 01 - Distance Calculator
 * 
 * @author 1elmasriahm
 * @version 2017-18.S2
 */
public class DistanceCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BigDecimal a;
        double lat1, lat2, lon1, lon2;
        Scanner input = new Scanner(System.in);
        String name1, name2;
        
        
        
        System.out.println("Hello, I am a distance calculator");
        System.out.println("When entering latitude and longtitude, please use degrees");
        System.out.println("For example: 43 degrees 40 minutes would be inserted as 43.67");
        System.out.println("Use positive values for north latitude and west longtitude");
        System.out.println("Use negative values for south latittude and east longtitude");
        System.out.println("");
        
        System.out.println("What is the name of the first location?");
        name1 = input.nextLine();
        System.out.println("Input the latitude of " + name1);
        lat1 = input.nextDouble();
        System.out.println("Input the longtitude of " + name1);
        lon1 = input.nextDouble();
        System.out.println("--------------------------------------");
        System.out.println("");
        
        System.out.println("What is the name of the second location?");
        name2 = input.nextLine();
        System.out.println("Input the latitude of " + name2);
        lat2 = input.nextDouble();
        System.out.println("Input the longtitude of " + name2);
        lon2 = input.nextDouble();
        System.out.println("--------------------------------------");
        System.out.println("");
                
                
        a = new BigDecimal(6378.8 * Math.acos(Math.sin(lat1/57.2958) * Math.sin(lat2/57.2958) + Math.cos(lat1/57.2958) * 
                Math.cos(lat2/57.2958) * Math.cos(lon2/57.2958 - lon1/57.2958)), MathContext.DECIMAL128);
        System.out.println("The distance = " + a + "km as the crow flies");
    }
    
}
