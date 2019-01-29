/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ahmad.icsu.u3.methodsHomework;

import java.util.Scanner;

/**
 *
 * @author ahmad
 */
public class RockPaperScissorsFinal {

    /**
     * @param args the command line arguments
     */
    //This method is to randomly generate a rock paper scissors value for the computer
    public static int generateRockPaperScissors(double randomChoice, int computer) {
        randomChoice = Math.random() * 3;
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

    public static void main(String[] args) {

        //Scanners and Variables 
        Scanner input = new Scanner(System.in);
        String holder;
        int user = 0;
        int computer = 0;
        double randomChoice = 0;
        boolean validInput = false;
        int larger = 0;
        int smaller = 0;
        //intro
        System.out.println("Rock Paper Scissors");
            System.out.println("This code is meant to play a little game of"
                    + "rock paper scissors");
            System.out.println("Go ahead, choose rock, paper or scissors");

        while (true) {
            
            //preselects the computer's choice
            do {//validates user input and assigns the number based on choice
                holder = input.nextLine();
                holder = holder.toLowerCase().replaceAll("\\s+","");
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

            computer = 6 / computer;//makes all the numbers able to be % by 3
            user = 6 / user;
            larger = Math.max(user, computer);
            smaller = Math.min(user, computer);

            if (larger == computer) {
                holder = "computer";
            } else {
                holder = "user";
            }

            //converts it into numbers so that the computer is able to run a mathematical algorithm
            if (larger > smaller) {
                if ((larger / smaller) % 3 == 0) {
                    System.out.println(holder + " wins");
                } else {
                    System.out.println(holder + " loses");
                }
            } else {
                System.out.println("its a tie");
            }
        }
    }
}
