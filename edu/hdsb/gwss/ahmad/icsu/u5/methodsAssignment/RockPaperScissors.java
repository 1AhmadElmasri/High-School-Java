/*
 * Rock Paper Scissors
 * 22/04/2017
 * Ahmad Elmasri
 * Ths code is meant to play a game of rock paper scissors
 * Version 1.0
 */
package edu.hdsb.gwss.ahmad.icsu.u5.methodsAssignment;

import java.util.Scanner;

/**
 *
 * @author ahmad
 */
public class RockPaperScissors{

    /**
     * @param args the command line arguments
     */
    //This method is to randomly generate a rock paper scissors value for the computer
    public static int generateRockPaperScissors(double randomChoice, int computer) {
        randomChoice = Math.random() * 3;//makes only 3 options visible
        computer = ((int) randomChoice) + 1;//make only 3 choices from 1-3
        if (computer == 1) {
            System.out.println("Computer chose rock");//tells users what the the computer chose
        } else if (computer == 2) {
            System.out.println("Computer chose paper");
        } else if (computer == 3) {
            System.out.println("computer chose scissors");
        }
        return computer;
    }
    //determines the outcome of the game
    public static String determineOutcome(int computer, int user, String holder) {
        computer = 6 / computer;//makes all the numbers able to be % by 3
            user = 6 / user;
            int larger = Math.max(user, computer);//picks the larger of the two
            int smaller = Math.min(user, computer);
                
            //assigns which one will be the one to be written out
            if (larger == computer) {
                holder = "computer";
            } else {//this code is so I can have one if statement
                holder = "user";
            }

            //converts it into numbers so that the computer is able to run a mathematical algorithm
            if (larger > smaller) {
                if ((larger / smaller) % 3 == 0) {
                    holder = holder + " wins";
                } else {
                    holder = holder + " loses";
                }
            } else {
                holder = "its a tie";
            }
            return holder;
    }

    public static void main(String[] args) {

        //Scanners and Variables 
        Scanner input = new Scanner(System.in);
        String holder;
        int user = 0;
        int computer = 0;
        double randomChoice = 0;
        boolean validInput = false;
        //intro
        System.out.println("Rock Paper Scissors");
            System.out.println("This code is meant to play a little game of"
                    + "rock paper scissors");
            System.out.println("Go ahead, choose rock, paper or scissors");

        while (true) {//infinite game!
            
            //preselects the computer's choice
            do {//validates user input and assigns the number based on choice
                holder = input.nextLine();
                holder = holder.toLowerCase().replaceAll("\\s+","");//take out spaces
                switch (holder) {
                    case "rock":
                        user = 1;
                        validInput = true;
                        break;//User selected alues are the same as the computer ones
                    case "paper":
                        user = 2;
                        validInput = true;
                        break;
                    case "scissors":
                        user = 3;
                        validInput = true;
                        break;
                    default://in case of bad input
                        System.out.println("invalid input, try again");
                        break;
                }
            } while (!validInput);//if at first you don't succeed, try, try again
            System.out.println("User chose " + holder);

            computer = generateRockPaperScissors(randomChoice, computer);//calls the method
            System.out.println(determineOutcome(computer, user, holder));//prints out the outcome

            
        }
    }
}
