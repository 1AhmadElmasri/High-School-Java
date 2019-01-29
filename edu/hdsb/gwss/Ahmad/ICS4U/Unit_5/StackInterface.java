/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_5;

/**
 * Stack Interface.
 *
 * @author Wm.Muir
 * @version 2017-18.S2
 */
public interface StackInterface {

    public int top();

    public int pop();

    public void push( int value );

    public int size();
    
    public int capacity();

    public boolean isEmpty();
    
    public boolean isFull();

    public void makeEmpty();
    
    public void display();
    
    @Override
    public String toString();

}


