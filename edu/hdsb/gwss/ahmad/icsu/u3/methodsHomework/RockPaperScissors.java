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
public class RockPaperScissors {

    /**
     * @param args the command line arguments
     */
    //This method is to randomly generate a rock paper scissors value for the computer
    public static int generateRockPaperScissors(double randomChoice, int computer) {
        randomChoice = Math.random() * 3;
        computer = ((int) randomChoice) + 1;//make only 3 choices from 1-3
        if (computer == 1) {
            System.out.println("Computer chose rock");
        } else if (computer == 2) {
            System.out.println("Computer chose paper");
        } else if(computer == 3) {
            System.out.println("computer chose scissors");
        }
        return computer;
    }
    public static void main(String[] args) {
        while(true){
        //Scanners and Variables 
        Scanner input = new Scanner(System.in);
        String holder;
        int user = 0;
        int computer = 0;
        double randomChoice = 0;
        boolean validInput = false;
        
        //preselects the computer's choice
        
      
        do {//validates user input and assigns the number based on choice
            holder = input.nextLine();
            holder = holder.toLowerCase();
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
        
        computer = 6 / computer;
        System.out.println(computer);
        user = 6 / user;
        System.out.println(user);
        //converts it into numbers so that the computer is able to run a mathematical algorithm
        if (computer > user) {
            if((computer / user) % 3 == 0){
                System.out.println("user loses");
                System.out.println((computer / user) % 3 );
            }else{
                System.out.println("user wins");
            }
        }else if (computer < user) {
            if((user / computer) % 3 == 0){
                System.out.println("user wins");
                System.out.println((computer / user) % 3 );
            }else{
                System.out.println("user loses");
            }
          
        }else{
            System.out.println("its a tie");
        }
        }
    }
    }
    
    

