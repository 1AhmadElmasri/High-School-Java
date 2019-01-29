package edu.hdsb.gwss.ics3u.u3.assignment;


import java.text.NumberFormat;
import java.util.Scanner;

/*
 * Compound Investing
 * 30/03/2017
 * Ahmad Elmasri
 * This code is meant to calculate compound interest
 * Version 1.0
 */

/**
 *
 * @author 1elmasriahm
 */
public class CompoundInvesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Scanners and Variables
        Scanner input = new Scanner(System.in);
        double yearlyInvestment, interestRate, interest, amountInAccount,total;
        int numberOfYears;
        final int MAX_YEARS = 15;
        NumberFormat money = NumberFormat.getCurrencyInstance();
        boolean checker = false;
        
        
        //intro
        System.out.println("Interest Calculator");
        System.out.println("This calculator is meant to calculate the interest"
                + "after a set amount of years");
        System.out.println("max number of years is 15");
        
        //asks users for input and verifies it
        do {
            System.out.println("Input the yearly investment into this account:");
            yearlyInvestment = input.nextDouble();
            System.out.println("Input the interest rate on this investment:");
            interestRate = input.nextDouble();
            interestRate = interestRate / 100;
            System.out.println("Input the number of years: ");
            numberOfYears = input.nextInt();
            if (numberOfYears > MAX_YEARS || numberOfYears <= 0) {
                System.out.println("The number of years cannot be above 15. They also cannot"
                        + "be less than or equal to zero. Try again.");
            } else if (interestRate >= 1 || interestRate <= 0) {
                System.out.println("Interest rate cannot be equal to or above 100");
                System.out.println("It also can't be below or equal to zero");
            } else if (yearlyInvestment <= 0) {
                System.out.println("The yearly Investment cannot be equal to or below zero");
            }else checker = true;

        } while (checker == false);
        amountInAccount = yearlyInvestment;

        //prints out and formats the table of returns
        System.out.format("%-10s %-20s %10s %10s", "Year", "Amount In Account", "Interest", "Total\n");
        for (int i = 1; i < (numberOfYears + 1); i++) {
            interest = amountInAccount * interestRate;
            total = interest + yearlyInvestment + amountInAccount;
            System.out.format("%-10s %-20s %10s %10s", i,
                    money.format(amountInAccount), money.format(interest),
                    money.format(total) + "\n");
            amountInAccount = total;
        }
        
        
        
                }
}