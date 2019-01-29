/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ahmad.cs.u3.Methods;

/**
 *
 * @author 1elmasriahm
 */
public class MethodStuff {

    /**
     * @param args the command line arguments
     */
    public static void listOfNames(int x){
        String r = Integer.toString(x);
        String name = "name";
        String name3 = "Three";
        
        System.out.println(name+r);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        listOfNames(3);
    }
    
}
