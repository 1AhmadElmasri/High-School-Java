/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unit3_Selection;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author 1elmasriahm
 */
public class BodyMassIndex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Body Mass Index
            /*
                Ahmad Elmasri
                21/03/2017
                Version 0.1
                This program is meant to measure Body Mass Index
                It also allows users to choose either imperial or metric
            */
            
            //Scanners and Variables
            Scanner input = new Scanner(System.in);
            double weight = 0;//has to be given a value here since it is taken in a loop
            double height = 0;
            double bodyMassIndex;
            boolean imperial = false;
            String restartAnswer;
            String holder, imperialOrMetric, results;
            boolean validation = false;
            NumberFormat formatter = NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(1);
            formatter.setMaximumFractionDigits(0);
            int heightMaximum, weightMaximum;
            
            
            //intro to the program
            System.out.println("Hi there! I'm a simple calculator made "
                    + "to calculate your Body Mass Index");
            
            System.out.println("Body mass index (kg/m2) is a measure of the weight of a "
                    + "person scaled according to their height.");
            
            //Asks if the user wants imperial or metric
            System.out.println("But first, would you like to input these values"
                    + "in imperial(inches and pounds) or metric(meters and kg)?");
            System.out.println("Type 'yes' for imperial or just hit enter for metric");
            holder = input.nextLine();
            switch (holder){
                case "yes":
                case "Yes":
                case "YES":
                case "imperial":
                    imperial = true;
                    System.out.println("imperial selected");
                    break;
                default:
                    System.out.println("metric selected");
                    break;
            }
            
        while(!validation){
            //Asks for height
            System.out.println("What is your height?");
            height = input.nextDouble();
            System.out.println("And what is your weight");
            weight = input.nextDouble();
            //ADD USER VALIDATION
            
            if(imperial == true){
                imperialOrMetric = "Imperial is measured in inches and pounds";
                heightMaximum = 120;
                weightMaximum = 800;
            }else{
                imperialOrMetric = "Metric is measured in meters and kilograms";
                heightMaximum = 3;
                weightMaximum = 500;
            }
            
            
            //checking if input is valid
            if(height <= 0 || weight <= 0||height>=heightMaximum||weight >= weightMaximum ){
                System.out.println("Sorry, invalid input, weight and height"
                        + " have to be reasonable. Remember, " + imperialOrMetric);
                System.out.println("Would You like to try again?('Yes' to start again or 'No' to end here)");
                input.nextLine();//to consume the next line in order for this scanner to work
                restartAnswer = input.nextLine();
                switch(restartAnswer){
                        case "Yes":
                        case "yes":
                        case "YES":
                            System.out.println("Alright, let's go");
                            validation = true;
                            break;//allows the loop to restart
                        case "NO":
                        case "no":
                        case "No":
                            System.out.println("Alright. Understandable. Goodbye!");
                            System.exit(0);//exits the program outright, so no need for break
                        default:
                            System.out.println("invalid input, try again");
                            break;
                }
                        
                        
                            
    }else{
                validation = true;
            }
        }
            
            //Calculating the BMI
            if(imperial == true){
               bodyMassIndex = (weight * 703) / Math.pow(height, 2);
            }else{
               bodyMassIndex = weight / (height * height); 
            }
            
            
            //most people using this program would be above 25
            if(bodyMassIndex > 25){
                if(bodyMassIndex <= 30){
                    results = "you are overweight";
                }
                else if(bodyMassIndex <= 40){
                    results = "you are obese";
                }
                else{
                    results = "you are morbidly obese";
                }
                
                
            }else{
                if(bodyMassIndex < 16)
                        results = "yyu are suffering of starvation";
            
                else if(bodyMassIndex < 18.5){
                        results = "you are underweight";
                        }
                else{
                        results = "you have an ideal bodyweight";
                        }
                    }
            System.out.println("Your height is " + formatter.format(height) + " and your weight is "
                    + formatter.format(weight) + " so your bmi is: " + formatter.format(bodyMassIndex) + 
                    ". Meaning " + results);
                    
            }
            
    }
    
