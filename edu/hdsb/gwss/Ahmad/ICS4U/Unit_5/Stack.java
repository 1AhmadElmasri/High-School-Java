/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_5;

/**
 *
 * @author ahmad
 */
public class Stack implements StackInterface {

    public int[] stack;
    public static final int DEFAULT_SIZE = 10;

    public Stack(int size) {
        stack = new int[size];
        this.makeEmpty();
    }

    public Stack() {
        stack = new int[DEFAULT_SIZE];
        this.makeEmpty();
    }

    @Override
    public int top() {
        if (!this.isEmpty()) {
            return this.stack[0];
        }else{
            return -1;
        }
    }

    @Override
    public int pop() {

        if (!this.isEmpty()) {
            int holder = this.stack[0];
            for (int i = 0; i < this.stack.length - 1; i++) {
                this.stack[i] = this.stack[i + 1];
            }
            

            if (this.isFull()) {
                this.stack[this.size() - 1] = -1;
            }else{
                this.stack[this.size() ] = -1;
            }

            return holder;
        } else {
            return -1;
        }

    }

    @Override
    public void push(int value) {
        if (value >= 0) {
            if (!this.isFull()) {
                for (int i = this.stack.length - 1; i > 0; i--) {
                    this.stack[i] = this.stack[i - 1];
                }
                this.stack[0] = value;
            } else {
                System.out.println("Cannot push " + value + ", stack full");
            }
        } else {
            System.out.println("Cannot push " + value + ", value below zero");
        }
    }

    @Override
    public int size() {
        int counter = 0;
        if (this.isEmpty()) {
            counter = 0;
        }else if (this.isFull()) {
            counter = this.capacity();
        } else {
            for (int i = 0; i < this.stack.length; i++) {
                if (this.stack[i] >= 0) {
                    counter++;
                }
            }
        }

        return counter;
    }

    @Override
    public int capacity() {
        return this.stack.length;
    }

    @Override
    public boolean isEmpty() {
        boolean empty = true;
        for (int i = 0; i < this.stack.length; i++) {
            if (stack[i] >= 0) {
                empty = false;
            }
        }
        return empty;
    }

    @Override
    public boolean isFull() {
        boolean full = true;
        for (int i = 0; i < this.stack.length; i++) {
            if (stack[i] < 0) {
                full = false;
            }
        }
        return full;
    }

    @Override
    public void makeEmpty() {
        for (int i = 0; i < this.stack.length; i++) {
            this.stack[i] = -1;
        }
    }

    @Override
    public void display() {
        for (int i = 0; i < this.stack.length - 1; i++) {
            System.out.print(this.stack[i] + ", ");
        }
        System.out.print(this.stack[this.capacity() - 1]);
        System.out.println("");
    }
    
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.stack.length - 1; i++) {
            s += this.stack[i] + ", ";
        }
        s += this.stack[this.capacity() - 1];
        return s;        
    }

}
