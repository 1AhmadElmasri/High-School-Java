package edu.hdsb.gwss.ics3u.u3.assignment;


import java.util.Scanner;

/*
 * Lab Animals
 * 30/03/2017
 * Ahmad Elmasri
 * This code is meant to show when an exponentially growing population crashes
 * as a result of it catching up to it's linearly growing food supply
 * Version 1.0
 */
/**
 *
 * @author 1elmasriahm
 */
public class LabAnimals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanners nd Variables
        Scanner input = new Scanner(System.in);
        int numberOfAnimals = 10;
        int initialFood = 1000;
        int foodToAdd = 4000;
        int hours = 0;
        boolean checker = false;
        String holder;

        //intro
        System.out.println("Lab Animals");
        System.out.println("At present there are X animals in the lab and enough\n"
                + "food for Y animals. Every hour the population doubles,\n"
                + "and the amount of food provided is enough to support Y more"
                + " animals.");
        System.out.println("During any hour each animal eats one unit of food.\n"
                + "This program determines how long it takes for the animals to outgrow"
                + " their supply.");

        //Ask users for input and verifies it
        do {
            try {
                System.out.println("Input the initial amount of animals: ");
                holder = input.nextLine();
                numberOfAnimals = Integer.parseInt(holder);
                System.out.println("Input the initial amount of food: ");
                holder = input.nextLine();
                initialFood = Integer.parseInt(holder);
                System.out.println("Input the amount of food to add each hour: ");
                holder = input.nextLine();
                foodToAdd = Integer.parseInt(holder);
                if (numberOfAnimals <= 0 || initialFood <= 0 || foodToAdd <= 0) {
                    System.out.println("All numbers need to be a value above 0");
                } else {
                    checker = true;
                }
            } catch (Exception e) {
                System.out.println("Make sure the number you input is an integer");
            }
        } while (!checker);

        System.out.println("\nPress enter to see each iteration\n");

        System.out.format(" %-6s %-13s %-15s %-15s %-13s", "Hour |", " Animals at Start |",
                " Food at Start |", "Food at End |", "Animals at End |\n");
        
        //runs the loop to show users how the population transforms
        do {
            hours++;
            System.out.format(" %3s %13s %15s %15s %13s", hours, numberOfAnimals,
                    initialFood, (initialFood + foodToAdd) - numberOfAnimals, numberOfAnimals * 2 + "\n");
            initialFood = (initialFood + foodToAdd) - numberOfAnimals;
            numberOfAnimals = numberOfAnimals * 2;
            input.nextLine();//allows the user to press enter for each iteration
        } while (numberOfAnimals < initialFood);

        System.out.println("The animals have outgrown their food supply after "
                + hours + " hours.");
    }

}
