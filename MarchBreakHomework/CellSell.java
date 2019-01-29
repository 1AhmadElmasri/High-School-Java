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
public class CellSell {

    /**
     * @param args the command line arguments
     */
    static int daytimeUse, eveningUse, weekendUse;
    static double costB, costA;
    public static void main(String[] args) {
        // This program is meant to decide the best cell plan for users
        //This is based on their usage during different times of the day

        //variables and scanner
        Scanner input = new Scanner(System.in);
        boolean checker = false;
        String holder;
        NumberFormat money = NumberFormat.getCurrencyInstance();

        //constants and variables for plan A
        final double DAYPLAN_A = 0.25;
        final double EVENINGPLAN_A = 0.15;
        final double WEEKENDPLAN_A = 0.20;
        
        //constants for plan B
        final double DAYPLAN_B = 0.45;
        final double EVENINGPLAN_B = 0.35;
        final double WEEKENDPLAN_B = 0.25;
        
        
        //intro
        System.out.println("Hi there! I'm a simple cell plan chooser");
        System.out.println("");
        System.out.println("I look at your usage and find the best plan for you");
        System.out.println("");
        
        //makes sure the input is correct for daytime usage
        while (!checker) {
            try {
                System.out.println("What is your weekday daytime usage, in minutes?");
                holder = input.nextLine();
                daytimeUse = Integer.parseInt(holder);
                checker = true;
            } catch (Exception e) {
                System.out.println("Incorrect input. Try again using only integers");
                checker = false;
            }
        }
        
        //makes sure input is correct for evening use
        checker = false;
        while (!checker) {
            try {
                System.out.println("What is your weekday evening usage, in minutes?");
                holder = input.nextLine();
                eveningUse = Integer.parseInt(holder);
                checker = true;
            } catch (Exception e) {
                System.out.println("Incorrect input. Try again using only integers");
                checker = false;
            }
        }
        
        checker = false;
        while (!checker) {
            try {
                System.out.println("What is your weekend usage, in minutes?");
                holder = input.nextLine();
                weekendUse = Integer.parseInt(holder);
                checker = true;
            } catch (Exception e) {
                System.out.println("Incorrect input. Try again using only integers");
                checker = false;
            }
        }
        
        //processing for plan A
        if(100 >= daytimeUse){
            costA = 0 + (eveningUse * EVENINGPLAN_A) + (weekendUse * WEEKENDPLAN_A);
            System.out.println("Plan A costs " + money.format(costA));
        }
        else{
            costA = ((daytimeUse - 100) * DAYPLAN_A) + (eveningUse * EVENINGPLAN_A) + (weekendUse * WEEKENDPLAN_A);
            System.out.println("Plan A costs " + money.format(costA));
        }
        
        //processing for plan B
        if(250 >= daytimeUse){
            costB = 0 + (eveningUse * EVENINGPLAN_B) + (weekendUse * WEEKENDPLAN_B);
            System.out.println("Plan B costs " + money.format(costB));
        }
        else{
            costB = ((daytimeUse - 250) * DAYPLAN_B) + (eveningUse * EVENINGPLAN_B) + (weekendUse * WEEKENDPLAN_B);
            System.out.println("Plan B costs " + money.format(costB));
        }
        
        costB = Math.abs(costB);
        costA = Math.abs(costA);
        //finding the cheapest one
        
        if(costA > costB) {
            System.out.println("Plan B is cheaper");
        }
        if(costA < costB){
            System.out.println("Plan A is cheaper");
        }
        if(costA == costB) {
            System.out.println("Both plans cost the same");
        }
        
    }
    
}
