/*
 * Erosion
 * 30/03/2017
 * Ahmad Elmasri
 * This code is meant to show when the topsoil will erode to 9 cm
 * Version 1.0
 */
package edu.hdsb.gwss.ics3u.u3.assignment;

import java.util.Scanner;

/**
 *
 * @author ahmad
 */
public class Erosion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Variables and Constants
        double soilLevel = 30;
        final double PERCENT_LOST = 0.01;
        final double SOIL_ADDED = 2.5 / 500;
        int year = 0;
        double soilAtEnd;//These two variables are only for readability in code
        double soilLost;
        Scanner input = new Scanner(System.in);

        //intro
        System.out.println("TopSoil Erosion");
        System.out.println("Careless land management causes 1% of topsoil"
                + "to erode each year");
        System.out.println("It takes nature 500 years to produce 2.5 cm of"
                + "topsoil");
        System.out.println("At 9 cm, the topsoil is so shallow that crops"
                + "won't grow on a large scale");
        System.out.println("This calculator tells us how long it will"
                + "take the topsoil to erode\n");
        System.out.println("press enter to skip 5 years each time \n");

        //shows the colums for users to see
        System.out.format("%-5s %20s %20s %20s", "Year", "| Soil at Start |", "Soil Lost |", "Soil Left |\n");
        
        do {
            year++;
            soilLost = (soilLevel * PERCENT_LOST);
            soilAtEnd = (soilLevel - soilLost) + (SOIL_ADDED);
            System.out.format("%5s %20s %20s %20s", year, soilLevel, soilLost, soilAtEnd + "\n");
            soilLevel = soilAtEnd;
            if(year % 5 == 0) input.nextLine();

        } while (soilLevel >= 9);
        System.out.println("It will take " + year + " years to erode the "
                + "topsoil to 9 cm");

        
        
    }
    
}
