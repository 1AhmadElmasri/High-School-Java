/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ahmad.icsu.u5.methodsAssignment;

/**
 *
 * @author 1elmasriahm
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static int toFarenheit(int celsius){
    celsius = ((9/5) * celsius) + 32;
    return celsius; //the caller will be assigning farenheit to this value. The original celsius doesn't change
}
public static int toCelsius(int farenheit){
    farenheit = (farenheit - 32) * (5 / 9);
    return farenheit;
}

    public static void main(String[] args) {
        // TODO code application logic here
        int farenheit = 76;
int celsius = 25;
System.out.println("Before: " + farenheit + " After: " );
System.out.println( toCelsius(farenheit) ) ;
System.out.println("Before: " + celsius + " After: " );
System.out.println( toFarenheit(celsius) ) ;
    }
    
}
