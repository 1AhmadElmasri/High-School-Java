/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.OOP;

/**
 *
 * @author 1elmasriahm
 */
public class Dog extends Animal{

    private String breed;
    
    public Dog(String name) {
        super(name);
    }
    
    public Dog(int age, int weight, String name) {
        super(age, weight, name);
    }

    public Dog(int age, int weight, String name, String breed) {
        this(age, weight, name);
        this.breed = breed;
    }

    public Dog() {
        super("Dog");
    }
    
    
    public void move(){
        super.move();
        System.out.println("Walk");
    }
}
