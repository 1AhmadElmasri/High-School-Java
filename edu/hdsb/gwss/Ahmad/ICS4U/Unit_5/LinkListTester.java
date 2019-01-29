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
public class LinkListTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Beginning of the LinkList
        LinkList list = new LinkList();
        
        //case 0: Empty 
        System.out.println("TEST 1 : EMPTY LINKLIST");
        System.out.println("------------------------");
        
        System.out.println("List Size : " + list.size());
        assert(list.size() == 0);
        
        System.out.println("List head : " + list.head());
        assert(list.head() == null);
        
        System.out.println("List tail : " + list.tail());
        assert(list.tail() == null);
        
        System.out.println("List is Empty : " + list.isEmpty());
        assert(list.isEmpty());
        
        System.out.println("List to String : " + list.toString());
        assert(list.toString().equals("List Empty"));
        
        
        System.out.println("List Remove : A ");
        list.remove("A");
        assert(list.removeHead().equals("LinkList empty, no head found"));
        assert(list.removeTail().equals("LinkList empty, no tail found"));
        
        System.out.println("\n");
        
        
        
        //case 1 A : Size 1 (From front)
        list.addAtFront("A");
        System.out.println("TEST 2 A : SINGLE LINKLIST (FROM FRONT)");
        System.out.println("------------------------");
        
        System.out.println("List is Empty : " + list.isEmpty());
        assert(!list.isEmpty());
        
        System.out.println("List Size : " + list.size());
        assert(list.size() == 1);
        
        System.out.println("List head : " + list.head());
        assert(list.head().equals("A"));
        
        System.out.println("List tail : " + list.tail());
        assert(list.tail().equals("A"));
        
        System.out.println("List to String : " + list.toString());
        assert(list.toString().equals("Head/Tail → A"));
        
        
        System.out.println("List Remove : A ");
        list.remove("A");
        assert(list.size() == 0);
        
        list.addAtFront("A");
        assert(list.size() == 1);
        assert(list.removeHead().equals("A"));
        assert(list.size() == 0);
        assert(list.head() == null);
        assert(list.head() == null);
        
        list.addAtFront("A");
        assert(list.size() == 1);
        assert(list.removeTail().equals("A"));
        assert(list.size() == 0);
        assert(list.head() == null);
        assert(list.head() == null);
        
        System.out.println("\n");

        //case 1 B : Size 1 (From Behind)
        list.addAtEnd("A");
        System.out.println("TEST 2 B : SINGLE LINKLIST (FROM BEHIND)");
        System.out.println("------------------------");
        
        System.out.println("List is Empty : " + list.isEmpty());
        assert(!list.isEmpty());
        
        System.out.println("List Size : " + list.size());
        assert(list.size() == 1);
        
        System.out.println("List head : " + list.head());
        assert(list.head().equals("A"));
        
        System.out.println("List tail : " + list.tail());
        assert(list.tail().equals("A"));
        
        System.out.println("List to String : " + list.toString());
        assert(list.toString().equals("Head/Tail → A"));
        
        
        System.out.println("List Remove : A ");
        list.remove("A");
        assert(list.size() == 0);
        
        list.addAtEnd("A");
        assert(list.size() == 1);
        assert(list.removeHead().equals("A"));
        assert(list.size() == 0);
        assert(list.head() == null);
        assert(list.head() == null);
        
        list.addAtEnd("A");
        assert(list.size() == 1);
        assert(list.removeTail().equals("A"));
        assert(list.size() == 0);
        assert(list.head() == null);
        assert(list.head() == null);
        
        System.out.println("\n");
        
        
        //case 2 A : Size 2 (From Front)
        
        list.addAtFront("B");
        list.addAtFront("A");
        System.out.println("TEST 3 A : DOUBLE LINKLIST (FROM FRONT)");
        System.out.println("------------------------");
        
        System.out.println("List is Empty : " + list.isEmpty());
        assert(!list.isEmpty());
        
        System.out.println("List Size : " + list.size());
        assert(list.size() == 2);
        
        System.out.println("List head : " + list.head());
        assert(list.head().equals("A"));
        
        System.out.println("List tail : " + list.tail());
        assert(list.tail().equals("B"));
        
        System.out.println("List to String : " + list.toString());
        assert(list.toString().equals("Head → A → B → Tail"));
        
        System.out.println("List Remove : C ");
        list.remove("C");
        assert(list.size() == 2);
        assert(list.toString().equals("Head → A → B → Tail"));
        
        
        System.out.println("List Remove : A ");
        list.remove("A");
        assert(list.size() == 1);
        assert(list.toString().equals("Head/Tail → B"));
        
        list.addAtFront("A");
        assert(list.size() == 2);
        assert(list.removeHead().equals("A"));
        assert(list.size() == 1);
        assert(list.head().equals("B"));
        assert(list.head().equals("B"));
        
        list.addAtFront("A");
        assert(list.size() == 2);
        assert(list.removeTail().equals("B"));
        assert(list.size() == 1);
        assert(list.head().equals("A"));
        assert(list.head().equals("A"));
        
       System.out.println("\n");
       
       
        //case 2 B : Size 2 (From Behind)
        list.makeEmpty();
        assert(list.size() == 0);
        assert(list.head() == null);
        assert(list.head() == null);
        list.addAtEnd("A");
        list.addAtEnd("B");
        System.out.println("TEST 3 B : DOUBLE LINKLIST (FROM FRONT)");
        System.out.println("------------------------");
        
        System.out.println("List is Empty : " + list.isEmpty());
        assert(!list.isEmpty());
        
        System.out.println("List Size : " + list.size());
        assert(list.size() == 2);
        
        System.out.println("List head : " + list.head());
        assert(list.head().equals("A"));
        
        System.out.println("List tail : " + list.tail());
        assert(list.tail().equals("B"));
        
        System.out.println("List to String : " + list.toString());
        assert(list.toString().equals("Head → A → B → Tail"));
        
        System.out.println("List Remove : C ");
        list.remove("C");
        assert(list.size() == 2);
        assert(list.toString().equals("Head → A → B → Tail"));
        
        
        System.out.println("List Remove : A ");
        list.remove("A");
        assert(list.size() == 1);
        assert(list.toString().equals("Head/Tail → B"));
        
        list.addAtFront("A");
        assert(list.size() == 2);
        assert(list.removeHead().equals("A"));
        assert(list.size() == 1);
        assert(list.head().equals("B"));
        assert(list.head().equals("B"));
        
        list.addAtFront("A");
        assert(list.size() == 2);
        assert(list.removeTail().equals("B"));
        assert(list.size() == 1);
        assert(list.head().equals("A"));
        assert(list.head().equals("A"));
        
        System.out.println("\n");
        
        //case 3 : Large Size 
        list.makeEmpty();
        list.addAtEnd("A");
        list.addAtEnd("B");
        list.addAtEnd("C");
        list.addAtEnd("D");
        list.addAtEnd("E");
        list.addAtEnd("F");
        list.addAtEnd("G");
        list.addAtEnd("H");
        System.out.println("TEST 4 : LARGE LINKLIST");
        System.out.println("------------------------");
        
        System.out.println("List is Empty : " + list.isEmpty());
        assert(!list.isEmpty());
        
        System.out.println("List Size : " + list.size());
        assert(list.size() == 8);
        
        System.out.println("List head : " + list.head());
        assert(list.head().equals("A"));
        
        System.out.println("List tail : " + list.tail());
        assert(list.tail().equals("H"));
        
        System.out.println("List to String : " + list.toString());
        assert(list.toString().equals("Head → A → B → C → D → E → F → G → H → Tail"));
        
        System.out.println("List Remove : Z ");
        list.remove("Z");
        assert(list.size() == 8);
        assert(list.toString().equals("Head → A → B → C → D → E → F → G → H → Tail"));
        
        
        System.out.println("List Remove : E ");
        list.remove("E");
        assert(list.size() == 7);
        assert(list.toString().equals("Head → A → B → C → D → F → G → H → Tail"));
        
        assert(list.removeHead().equals("A"));
        assert(list.size() == 6);
        assert(list.head().equals("B"));
        assert(list.head().equals("B"));
        list.addAtFront("A");


        assert(list.removeTail().equals("H"));
        assert(list.size() == 6);
        assert(list.head().equals("A"));
        assert(list.tail().equals("G"));
//        
       System.out.println("\n");
        
        //case 5, large linklist make empty
        list.makeEmpty();
        
        //case 0: Empty 
        System.out.println("TEST 5 : EMPTY LINKLIST AGAIN");
        System.out.println("------------------------");
        
        System.out.println("List Size : " + list.size());
        assert(list.size() == 0);
        
        System.out.println("List head : " + list.head());
        assert(list.head() == null);
        
        System.out.println("List tail : " + list.tail());
        assert(list.tail() == null);
        
        System.out.println("List is Empty : " + list.isEmpty());
        assert(list.isEmpty());
        
        System.out.println("List to String : " + list.toString());
        assert(list.toString().equals("List Empty"));
        
        
        System.out.println("List Remove : A ");
        list.remove("A");
        assert(list.removeHead().equals("LinkList empty, no head found"));
        assert(list.removeTail().equals("LinkList empty, no tail found"));
        
        System.out.println("\n");
        
    }
    
}
