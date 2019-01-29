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
public class QueueTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Queue list = new Queue();
        
        //case 0, queue empty
        System.out.println("TEST 0 : QUEUE EMPTY");
        System.out.println("--------------------");
        assert(list.front() == list.back());
        list.displayQueue();
        System.out.println("List Empty : " + list.isEmpty());
        assert(list.isEmpty());
        
        System.out.println("List Front : " + list.front());
        assert(list.front() == -1);
        
        System.out.println("List Back : " + list.back());
        assert(list.back() == -1);
        
        System.out.print("List Dequeue When Already Empty:");
        list.dequeue();
        System.out.println("Success");
        
        System.out.print("List Make Empty When Already Empty : ");
        list.makeEmpty();
        System.out.println("Success");
        
        System.out.println("List Capacity : " + list.capacity());
        assert(list.capacity() == 10);
        
        System.out.println("List Size : " + list.size());
        assert(list.size() == 0);
        
        System.out.println("\n");
        
        
         //case 1, single entry
        System.out.println("TEST 1 : SINGLE ENTRY");
        System.out.println("--------------------");
        list.enqueue(12);
        list.displayQueue();
        
        assert(list.front() == list.back());
        //assert(list.front() == 12);
        
        System.out.println("List Empty : " + list.isEmpty());
        assert(!list.isEmpty());
        
        System.out.println("List Front : " + list.front());
        assert(list.getValue(list.front()) == 12);
        
        System.out.println("List Back : " + list.back());
        assert(list.getValue(list.back()) == 12);
        
        System.out.print("List Dequeue :" + list.dequeue());
        assert(list.size() == 0);
        assert(list.front() == -1);
        assert(list.back() == -1);
        System.out.println(" Success");
        
        list.enqueue(12);
        
        System.out.print("List Make Empty : ");
        list.makeEmpty();
        assert(list.size() == 0);
        assert(list.front() == -1);
        assert(list.back() == -1);
        System.out.println("Success");
        
        System.out.println("List Capacity : " + list.capacity());
        assert(list.capacity() == 10);
        
        System.out.println("\n");
        
        
        //test 3, fill and empty
        //fill
        System.out.println("TEST 3 : FILL THEN EMPTY");
        for (int i = 0; i < list.capacity(); i++) {
            list.enqueue(i);
        }
       
        
        list.displayQueue();
        assert(list.isFull());
        assert(list.size() == list.capacity());
        for (int i = 0; i < list.capacity(); i++) {
            list.dequeue();
       }
        assert(list.isEmpty());
        assert(list.size() == 0);
        
        list.enqueue(1);
        list.enqueue(1);
        list.enqueue(1);
        list.enqueue(1);
        list.enqueue(1);
        list.dequeue();
        list.dequeue();
        list.dequeue();
        list.enqueue(1);
        list.enqueue(1);
        list.enqueue(1);
        list.enqueue(1);
        list.enqueue(1);
        list.enqueue(1);
        list.displayQueue();


        list.displayQueue();
        assert list.size() == 8;
        assert list.isEmpty() == false;
        assert list.isFull() == false;

        //sets queue to full with back right behind front
        list.enqueue(1);
        list.enqueue(1);
        assert list.size() == 10;
        assert list.isEmpty() == false;
        assert list.isFull() == true;

        //return error
        list.enqueue(Integer.MIN_VALUE);

        //makes sure resests to empty
        list.makeEmpty();
        assert list.isEmpty() == true;
        
        
    }
    
}
