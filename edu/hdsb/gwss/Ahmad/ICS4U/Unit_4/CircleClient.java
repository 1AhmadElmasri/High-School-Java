/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_4;

/**
 *
 * @author 1elmasriahm
 */
public class CircleClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Circle a = new Circle(4);
        System.out.println(a.radius);
        System.out.println(a.getCircumference());
        System.out.println(a.getArea());
        System.out.println(a.getDiameter());
        
    }
    
}
