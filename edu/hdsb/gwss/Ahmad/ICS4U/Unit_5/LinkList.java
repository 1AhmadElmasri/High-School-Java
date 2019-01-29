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
public class LinkList implements LinkListInterface {

    private Node head = null;
    private Node tail = null;
    private Node temp = null;

    public LinkList() {

    }

    @Override
    public int size() {

        if (this.isEmpty()) {
            return 0;
        }

        if (this.head == this.tail) {
            return 1;
        }

        int counter = 1;
        this.temp = this.head;
        while (this.temp.getNext() != null) {
            counter++;
            this.temp = this.temp.getNext();
        }

        return counter;

    }

    @Override
    public void makeEmpty() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean isEmpty() {
        return (this.head == null && this.tail == null);
    }

    @Override
    public void addAtFront(String str) {
        if (this.isEmpty()) {
            this.head = new Node(str);
            this.tail = this.head;
            this.head.setNext(null);
        } else if (this.size() == 1) {
            this.tail = head;
            this.head = new Node(str);
            this.head.setNext(tail);
        } else {
            this.temp = new Node(str);
            this.temp.setNext(this.head);
            this.head = this.temp;

        }
    }

    @Override
    public void addAtEnd(String str) {
        if (this.isEmpty()) {
            this.head = new Node(str);
            this.tail = this.head;
            this.head.setNext(null);
        } else if (this.size() == 1) {
            this.head = tail;
            this.tail = new Node(str);
            this.head.setNext(tail);
        } else {
            this.temp = new Node(str);
            this.tail.setNext(this.temp);
            this.tail = this.temp;
        }
    }

    @Override
    public void remove(String str) {

        if (this.isEmpty()) {
            System.out.println("LinkList already empty");
        } else if (this.size() == 1 && this.head.getValue().equals(str)) {
            this.makeEmpty();
        } else {
            Node holder;
            boolean valueFound = false;
            if (this.head.getValue().equals(str)) {
                removeHead();
                valueFound = true;
            } else if (this.tail.getValue().equals(str)) {
                removeTail();
                valueFound = true;
            } else {
                this.temp = this.head;

                while (this.temp.getNext() != this.tail && !valueFound) {
                    if (this.temp.getNext().getValue().equals(str)) {
                        holder = this.temp.getNext();
                        this.temp.setNext(this.temp.getNext().getNext());
                        holder.setNext(null);
                        valueFound = true;
                    } else {
                        this.temp = this.temp.getNext();
                    }
                }
            }
            if (!valueFound) {
                System.out.println("Value not Found, could Not remove");
            }
        }
    }

    @Override
    public String removeHead() {
        if (this.isEmpty()) {
            return "LinkList empty, no head found";
        }
        if (this.size() == 1) {
            String str = this.head.getValue();
            this.makeEmpty();
            return str;
        }
        String str = this.head.getValue();
        this.temp = this.head.getNext();
        this.head.setNext(null);
        this.head = this.temp;

        return str;
    }

    @Override
    public String removeTail() {
        if (this.isEmpty()) {
            return "LinkList empty, no tail found";
        }
        String str;
        if (this.size() == 1) {
            str = this.tail.getValue();
            this.makeEmpty();
            return str;
        }
        this.temp = this.head;
        while (this.temp.getNext() != this.tail) {
            this.temp = this.temp.getNext();
        }
        str = this.tail.getValue();
        this.temp.setNext(null);
        this.tail = this.temp;
        return str;
    }

    @Override
    public String head() {
        if (this.isEmpty()) {
            return null;
        }
        return this.head.getValue();
    }

    @Override
    public String tail() {
        if (this.isEmpty()) {
            return null;
        }
        return this.tail.getValue();
    }

    @Override
    public String toString() {
        this.temp = this.head;
        if (this.isEmpty()) {
            return "List Empty";
        }
        if (this.size() == 1) {
            return "Head/Tail → " + this.head.getValue();
        }

        String holder = "";

        holder += "Head → ";
        this.temp = this.head;

        while (this.temp.getNext() != null) {
            holder += this.temp.getValue() + " → ";
            this.temp = this.temp.getNext();
        }

        holder += this.temp.getValue() + " → ";

        holder += "Tail";

        return holder;
    }

}
