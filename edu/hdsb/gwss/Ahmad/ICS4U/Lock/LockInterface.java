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
public interface LockInterface{
    
    
    public boolean lockExists(long serialNumber);
    
    public boolean comboValid();
    
    public long getSerialNumber();
    
    public boolean isLocked();
    
    /**
     *
     * @return
     */
    public HashTable getlockList();
    
    public void unLock(int[] incomingCombo);
    
    public void Lock();
    
    public int unlockAttempts();
    
    public void displayLockInfo();
    
    public int[] getCombo();
    
    public boolean equals(Object obj);
    
    
}
