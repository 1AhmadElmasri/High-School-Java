/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarchBreakHomework;

import static java.lang.String.format;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author ahmad
 */
public class OrderChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Code meant to output nuts, bolts and washers
        //It then calculates the total
        
        //constants and scanners
        Scanner input = new Scanner(System.in);
        final double BOLT_PRICE = 0.05;
        final double NUT_PRICE = 0.03;
        final double WASHER_PRICE = 0.01;
        NumberFormat money = NumberFormat.getCurrencyInstance();
        
        //variables
        int bolts, nuts, washers;
        double cost;
        //intros
        System.out.println("Hi there. How many bolts do you need?");
        bolts = input.nextInt();
        
        System.out.println("How many washers do you need?");
        washers = input.nextInt();
        
        System.out.println("How many nuts do you need?");
        nuts = input.nextInt();
        
        
        //processing
        if(nuts == bolts && nuts+bolts == washers ){
            System.out.println("Good to go!");
            System.out.println("Number of bolts: " + bolts);
            System.out.println("Number of nuts: " + nuts);
            System.out.println("Number of washers: " + washers);
            cost = (BOLT_PRICE * bolts) + (WASHER_PRICE * washers) + (NUT_PRICE * nuts);
            System.out.println("Your cost is: " + money.format(cost));
        }else{
            if (nuts+bolts < washers) System.out.println("too many washers");
            if (nuts+bolts > washers) System.out.println("not enough washers");
            if (nuts > bolts) System.out.println("not enough bolts");
            if (bolts < nuts) System.out.println("not enough nuts");
            System.out.println("Good to go!");
            System.out.println("Number of bolts: " + bolts);
            System.out.println("Number of nuts: " + nuts);
            System.out.println("Number of washers: " + washers);
            cost = (BOLT_PRICE * bolts) + (WASHER_PRICE * washers) + (NUT_PRICE * nuts);
            System.out.println("Your cost is: " + money.format(cost));
        }
        
    }
    
}
