/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Lock;

import edu.hdsb.gwss.Ahmad.ICS4U.Lock.*;

/**
 *
 * @author 1elmasriahm
 */

/**
 * Lesson: 6.04 - (Closed) Hash Table
 */
public interface LockHashTableInterface {


    /**
     * @return Returns the number of keys in this hashtable.
     */
    public int size();
    
    /**
     * @return Returns the capacity of this hash table.
     */
    public int capacity();
    
    /**
     * @return The load factor of the hashtable.
     */
    public double loadFactor();
    
    /**
     * Clears this hashtable so that it contains no keys.
     */
    public void makeEmpty();
    
    /**
     * Tests if this hashtable maps no keys to values.
     */
    public boolean isEmpty();
    
    /**
     * Increases the capacity of and internally reorganizes this hashtable, in 
     * order to accommodate and access its entries more efficiently.
     */
    public void rehash();
    
    /**
     * Returns the value to which the specified key is mapped, or null if this 
     * map contains no mapping for the key.
     * @param key
     * @return
     */
    public Lock get(long serialNum);
    
    /**
     *
     * @param key
     * @param value
     */
    public void put( long serialNum, Lock value);
    
    
    /**
     *
     * @param key
     * @return
     */
    public boolean containsSerialNumber( long serialNum );
    
    /**
     *
     * @param key
     * @return
     */
    public int hash( long serialNum );

}
