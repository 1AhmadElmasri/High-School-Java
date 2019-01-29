/*
 * Name: Ahmad Elmasri
 * Date: 08/02/2018
 * Version: 1.0
 * Description: Uses the year to calculate the month and day of easter
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_1;

import java.util.Scanner;

/**
 *
 *  Day 05 - Easter Comes
 * 
 * @author 1elmasriahm
 * @version 2017-18.S2
 */
public class EasterComes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here\
        Scanner input = new Scanner(System.in);
        int partA, partB, partC, partD, partE, partF, partG, partH, partI,
                partJ, partK, partL, partM, partN, partO, partP;//Initialize ints
        int month, day;
        
        System.out.println("Hello, this is a simple easter day calculator");
        Thread.sleep(2000);
        
        System.out.println("Please input the year and I will find easter: ");
        int year = input.nextInt();//Take in the input
        
        
        partA = year % 19;//proccess the remainder
        
        partB = (int) year / 100; // proccess b
        partC = year % 100;
        
        partD = (int) partB / 4;
        partE = partB % 4;//step 3
        
        partF = (int) (partB + 8) / 25;//step 4
        
        partG = (int) ((partB - partF) + 1) / 3;//Step 5
        
        partH = (int) (19 * partA + partB - partD - partG + 15) % 30;//step 6
        
        partI = (int) partC / 4;
        partK = (int) partC % 4;//step 7
        
        partJ = (int) (32 + (2*partE) + (2*partI) - partH - partK) % 7;//step8
        
        partM = (int) (partA + (11*partH) + (22*partJ)) / 451;//step 9
        
        month = (int) (partH + partJ - (7*partM) + 114) / 31;//step 10, find month and day
        partP = (int) (partH + partJ - (7*partM) + 114) % 31;
        day = partP + 1;
        
        String monthName = monthNamer(month);
        
        
        
        System.out.println( "Easter will be on " + monthName + "(" + month + ")" + " " + day);
        
        
        
    }
    
    public static String monthNamer(int month){
        String monthName = "";
        int MonthHolder  = month - 1;// adapts to array numbers
        String[] months = { "January" , "February", "March", "April", "May", "June" ,"July" ,"August" ,"September"
                ,"October", "November", "December"};
        monthName = months[MonthHolder];
        return monthName;
    }
    
}
