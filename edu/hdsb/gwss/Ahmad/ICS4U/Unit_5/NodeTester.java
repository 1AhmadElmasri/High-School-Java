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
public class NodeTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Node objOne = new Node("A");
        Node objTwo = new Node("B");
        Node objThree = new Node("C");
        Node objFour = new Node("D");
        
        objOne.setNext(objTwo);
        objTwo.setNext(objThree);
        objThree.setNext(objFour);
        objFour.setNext(null);
        
        Node tempNode = objOne;
        while(!tempNode.getNext().equals(null)){
            
            System.out.println(tempNode.getValue());
          
            
        }

    }
    
}
