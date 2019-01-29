/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_5;

/**
 *
 * @author 1elmasriahm
 */
public class Queue implements QueueInterface  {

    public Integer[] queue;
    private int front = -1;
    private int back = -1;
    private int capacity = 0;
    private final int DEFAULT_CAPACITY = 10;
    
    
    
    public Queue(int capacity){
        this.capacity = capacity;
        this.front = -1;
        this.back = -1;
        this.queue = new Integer[this.capacity];
    }
    
    public Queue(){
        this.capacity = DEFAULT_CAPACITY;
        this.front = -1;
        this.back = -1;
        this.queue = new Integer[DEFAULT_CAPACITY];
    }
    
   
    @Override
    public Integer front() {
        return this.front;
    }

    @Override
    public Integer back() {
        return this.back;
    }

    @Override
    public void enqueue(Integer value) {
        if (this.isEmpty()) {
            this.front = 0;
            this.back = 0;
            this.queue[this.front] = value;
        }else if (!this.isFull()) {
           
                if (this.back < this.capacity-1) {
                    this.back++;
                    this.queue[this.back] = value;
                }else{
                    this.back = 0;
                    this.queue[this.back] = value;
                } 
          
        }else{
            System.out.println("Cannot add, queue is full");
        }
    }

    @Override
    public Integer dequeue() {
        Integer value = -1;
        if (!this.isEmpty()) {
            if (this.back > this.front) {
                value = this.queue[this.front];
                this.front++;
            }else if(this.front > this.back){
                if (this.front < (this.queue.length - 1)) {
                    value = this.queue[this.front];
                    this.front++;
                }else{
                    value = this.queue[this.front];
                    this.front = 0;
                }
            }else{
                value = this.queue[this.front];
                this.front = -1;
                this.back = -1;
            }
        }else{
            System.out.println("Cannot deque, queue is empty");
        }
        return value;
    }

    @Override
    public int size() {
        int size = 0;
        if (!this.isEmpty()) {
            if (this.front > this.back) {
                size = (this.queue.length - this.front) + this.back + 1;
            } else if(this.back > this.front){
                size = this.back - this.front + 1;
            }else{
                size = 1;
            }
        }else{
            size = 0;
        }
        return size;
    }

    @Override
    public int capacity() {
        return this.queue.length;
    }

    @Override
    public boolean isEmpty() {
        if (this.front == - 1 && this.back == -1) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean isFull() {
        int size = 0;
        if (!this.isEmpty()) {
            if (this.size() == this.capacity) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
        
    }

    @Override
    public void makeEmpty() {
        this.front = -1;
        this.back = -1;
    }

    @Override
    public void displayQueue() {
        if (!this.isEmpty()) {
            for (int i = 0; i < this.capacity; i++) {
                if (i == this.back && i == this.front) {
                    System.out.format("%13s", "fb");
                }else if (i == this.front) {
                    System.out.format("%13s", "f");
                } else if (i == this.back) {
                    System.out.format("%13s", "b");
                }  else {
                    System.out.format("%13s", " ");
                }

            }
        }else{
            System.out.println("queue empty");
        }

        System.out.println();
        for (int i = 0; i < this.capacity; i++) {
            System.out.format("%13d", this.queue[i]);
        }
        System.out.println("");
    }

    
    public Integer getValue(int position){
        if (this.isEmpty()) {
            return null;
        }else{
            if (position >= 0 && position <= this.queue.length) {
                return this.queue[position];
            }else{
                return null;
            }
        }
    }
    
    
}
