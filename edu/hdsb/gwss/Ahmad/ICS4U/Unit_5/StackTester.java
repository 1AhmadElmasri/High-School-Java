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
public class StackTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack list = new Stack();
        
        //case 1, empty stack
        System.out.println("Case 1 : Empty Stack");
        System.out.println("--------------------");
        System.out.println(list.toString());
        
        System.out.println("List Size : " + list.size());
        assert(list.size() == 0);
        
        System.out.println("List Capacity : " + list.capacity());
        assert(list.capacity() == 10);
        
        System.out.println("List is Empty : " + list.isEmpty());
        assert(list.isEmpty());
        
        System.out.println("List is Full : " + list.isFull());
        assert(!list.isFull());
        
        System.out.println("List Top : " + list.top());
        assert(list.top() == -1);
        
        list.makeEmpty();
        list.pop();
        
        //case 2, single stack
        list.push(12);
        System.out.println("Case 2 : Signle Stack");
        System.out.println("--------------------");
        System.out.println(list.toString());
        
        System.out.println("List Size : " + list.size());
        assert(list.size() == 1);
        
        System.out.println("List Capacity : " + list.capacity());
        assert(list.capacity() == 10);
        
        System.out.println("List is Empty : " + list.isEmpty());
        assert(!list.isEmpty());
        
        System.out.println("List is Full : " + list.isFull());
        assert(!list.isFull());
        
        System.out.println("List Top : " + list.top());
        assert(list.top() == 12);
        
        assert(list.pop() == 12);
        assert(list.size() == 0);
        assert(list.isEmpty());
        
        list.push(12);
        list.makeEmpty();
        assert(list.size() == 0);
        assert(list.isEmpty());
        
        //case 3, full stack
        for (int i = 0; i < list.capacity(); i++) {
            list.push(i);
        }
        System.out.println("Case 3 : Full Stack");
        System.out.println("--------------------");
        System.out.println(list.toString());
        
        System.out.println("List Size : " + list.size());
        assert(list.size() == list.capacity());
        
        System.out.println("List Capacity : " + list.capacity());
        assert(list.capacity() == 10);
        
        System.out.println("List is Empty : " + list.isEmpty());
        assert(!list.isEmpty());
        
        System.out.println("List is Full : " + list.isFull());
        assert(list.isFull());
        
        System.out.println("List Top : " + list.top());
        assert(list.top() == 9);
        
        assert(list.pop() == 9);
        assert(list.size() == 9);
        assert(!list.isEmpty());
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
