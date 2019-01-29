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
public class Animal {
    
    int age;
    int weight;
    String name;

    public Animal(int age, int weight, String name) {
        this.age = age;
        this.weight = weight;
        this.name = name;
    }

    public Animal(String name) {
        this.name = name;
        this.age = 1;
        this.weight = 2;
    }

    public Animal() {
        this.age = 1;
        this.weight = 2;
        this.name = "Animal";
    }
    
    public void move(){
        System.out.println("Animal Movement : ");
    }
    
    public void speak(){
        System.out.println("Animal Voice : ");
    }
    
    
}
