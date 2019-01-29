/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MarchBreakHomework;

import java.util.Scanner;

/**
 *
 * @author ahmad
 */
public class AlienDetector {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //This code detects the kind of alien that we need
        
        //variables and scanner
        boolean troyMartian1, vladSaturnian1, graemeMercurian1;
        boolean troyMartian2, vladSaturnian2, graemeMercurian2;
        int eyeNumber, antennaNumber;
        Scanner input = new Scanner(System.in);
        
        //intro
        System.out.println("Hi there, I'm a program meant to know the kind of"
                + "alien that you saw");
        
        //antennas input
        System.out.println("What is the number of antennas?");
        antennaNumber = input.nextInt();
        troyMartian1 = false;
        vladSaturnian1 = false;
        graemeMercurian1 = false;
        if (antennaNumber <= 6 ){
            vladSaturnian1 = true;
        }
        if (antennaNumber >= 3 ){
            troyMartian1 = true;
        }
        if (antennaNumber <= 2 ){
            graemeMercurian1 = true;
        }
        
        //eyes input
        System.out.println("What is the number of eyes?");
        eyeNumber = input.nextInt();
        troyMartian2 = false;
        vladSaturnian2 = false;
        graemeMercurian2 = false;
        if (eyeNumber <= 4){
           troyMartian2 = true;
        }
        if (eyeNumber <= 3){
           graemeMercurian2 = true;
        }
        if (eyeNumber >= 2){
           vladSaturnian2 = true;
        }
        
        
        if(vladSaturnian1 && vladSaturnian2) System.out.println("vladSaturnian");
        if(troyMartian1 && troyMartian2) System.out.println("troyMartian");
        if(graemeMercurian1 && graemeMercurian2) System.out.println("graemeMercurian");
    }
    
}
