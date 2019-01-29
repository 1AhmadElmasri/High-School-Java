/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarchBreakHomework;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author ahmad
 */
public class DiscountPrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    //Scanner and Variables
    Scanner input = new Scanner(System.in);
    int cost = 0;
    double totalCost;
    final double DISCOUNT = 0.10;
    boolean checker = false;
    String holder;
    NumberFormat money = NumberFormat.getCurrencyInstance();
    
    //Intros
    System.out.println("Hi! What is the cost of the thing you're buying?");
    
    
    //checker for incorrect input
    while (!checker) {
            try {
                holder = input.nextLine();
                cost = Integer.parseInt(holder);
                checker = true;
            } catch (Exception e) {
                System.out.println("Incorrect input. Put in one number");
                checker = false;
                
            }

        }
    
    
        totalCost = cost - (cost * DISCOUNT);
        System.out.println(money.format(totalCost));
    }
    
    
   
}
