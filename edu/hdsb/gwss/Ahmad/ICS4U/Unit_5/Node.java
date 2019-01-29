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
public class Node implements NodeInterface {

    public String data;
    private Node next;

    public Node() {
        this.data = null;
        this.next = null;
    }

    public Node(String incoming) {

        this.data = incoming;
        this.next = null;

    }

    @Override
    public Node getNext() {
        return this.next;
    }

    @Override
    public void setNext(Node newNode) {
        this.next = newNode;
    }

    @Override
    public String getValue() {
        return this.data;
    }

    @Override
    public void setValue(String incomingData) {
        this.data = incomingData;
    }

}
