/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_4;

import edu.hdsb.gwss.Ahmad.ICS4U.Unit_5.Stack;

/**
 *
 * @author 1elmasriahm
 */
public class Circle {
    static final String SHAPE_NAME = "CIRCLE";
    
    double radius;
    Stack woohoo = new Stack();

    public Circle() {
        System.out.println("A");
    }

    public Circle(double r) {
        System.out.println("B");
        this.radius = r;
    }
    
    double getDiameter() { 
        return this.radius * 2;
    }
    
    double getArea(){
        return Math.PI * Math.pow(this.radius, 2);
    }
    
    double getCircumference(){
        return getDiameter() * Math.PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    
}
