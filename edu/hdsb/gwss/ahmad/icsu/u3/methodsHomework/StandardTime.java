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
public class StandardTime {

    /**
     * @param args the command line arguments
     */
     public static String trimmer(String holder){
        holder = holder.trim();
        for(int i = 0; i < holder.length(); i++){
            if(holder.charAt(i) == ' '){
                holder = holder.substring(0, i ) + holder.substring(i+1,holder.length());
            }           
        }
        
        
        return holder;
    }
     
     public static int numberOfIntegers(String holder, int numberOfNumbers){
        for(int i = 0; i < holder.length(); i++){
            try{
                Integer.parseInt(""+ holder.charAt(i));
                numberOfNumbers++;
            }catch(Exception e){
                
            }
        }
        return numberOfNumbers;
    }
     
    public static String numberFormChanger(String holder){
        if(holder.length() < 5){
        holder = "0" + holder; 
        }
        return holder;
    }
    
     public static boolean colonChecker(String holder, boolean colonAvailable){
             if (holder.charAt(2) != ':') {
                 colonAvailable = true;
             }else{
                 colonAvailable = false;
             }
         
         return colonAvailable;
    }
     
     
     public static String accidentRemover(String numberHolder){
         int i = 0;
         while(i <= numberHolder.length()-1){
             if(numberHolder.charAt(i) != ':'){
            try{
                Integer.parseInt(""+ numberHolder.charAt(i));
                i++;
            }catch(Exception e){
                numberHolder = numberHolder.substring(0,i) + numberHolder.substring(i+1, numberHolder.length());
                System.out.println(numberHolder);
            }
            
         }else{
                 i++;
             }
        }
         return numberHolder;
     }
     
  
        public static String inputFixer(String holder, Scanner input){
        
            int numberOfNumbers = 0;
        boolean colonAvailable = false;
        boolean validInput = false;
        
        while(!validInput){
        holder = input.nextLine();
         holder = trimmer(holder);
        holder = accidentRemover(holder);
        System.out.println(holder);
        numberOfNumbers = numberOfIntegers(holder,numberOfNumbers);
        holder = numberFormChanger(holder);
        
        
        
        if(numberOfNumbers < 3 || numberOfNumbers > 4){
            System.out.println("Invalid input, amount of digits is between 3 and 4");
        }else if (colonChecker(holder, colonAvailable)) {
            System.out.println("Colon missing, try again");
        

        }else{
            System.out.println(holder);
            validInput = true;
        }
        }
        return holder;
     }
     
    public static void main(String[] args) {
        //Scanners and Variables
        Scanner input = new Scanner(System.in);
        String holder = "";
        int time;
        boolean validInput = false;
        String typeOfTime;
        boolean isStandard = false;
        
        
        while(!validInput){
        System.out.println("Would You like to input Standard or Traditional");
        typeOfTime = input.nextLine();
        typeOfTime = typeOfTime.toLowerCase();
        
        
        switch(typeOfTime){
            case "standard":
                validInput = true;
                isStandard = true;
                break;
            case "traditional":
                validInput = true;
                break;
            default:
                System.out.println("Invalid input, try again");
                break;
            
        }
        }
        
        
        //processing and error checking
        validInput = false;
        if (isStandard == false) {
            holder = inputFixer(holder, input);
            System.out.println(holder);
            while (!validInput) {
                System.out.println("Is it AM or PM?");
                typeOfTime = input.nextLine();
                typeOfTime = typeOfTime.toLowerCase();
                switch (typeOfTime) {
                    case "pm":
                        time = Integer.parseInt(holder.substring(0,2));
                        if(time < 12){
                        time = time + 12;
                        holder = time + holder.substring(2, holder.length());
                        System.out.println(holder + " is the time in standard");
                        validInput = true;
                        }else{
                            System.out.println("Invalid Input, reenter number");
                            holder = inputFixer(holder, input);
                            
                        }
                        break;
                    case "am":
                        System.out.println(holder + " is the time in standard");
                        validInput = true;
                        break;
                    default:
                        System.out.println("Invalid input, try again");
                        break;
                    
                        
                }
            }
        }else{
            holder = inputFixer(holder, input);
            System.out.println(holder);
        }
       
        
        
        
       
    }
    
}
