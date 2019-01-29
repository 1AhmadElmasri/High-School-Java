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
public class HashTable implements LockHashTableInterface {

    public Lock[] lockList;
    private final int DEFAULT_SIZE = 53;

    public HashTable(int length) {
        this.lockList = new Lock[length];
    }

    public HashTable() {
        this.lockList = new Lock[DEFAULT_SIZE];
    }
    
    
    @Override
    public int size() {
        int lockAmount = 0;
        if (!this.isEmpty()) {
            lockAmount = 0;
            for (int i = 0; i < lockList.length; i++) {
                if (lockList[i] != null) {
                    lockAmount++;
                }
            }
        }

        return lockAmount;
    }

    @Override
    public int capacity() {
        return this.lockList.length;
    }

    @Override
    public double loadFactor() {
        double value = 0;
        if (!this.isEmpty()) {
            value = (((double) this.size() / this.capacity())) * 100;
        }
        return value;
    }

    @Override
    public void makeEmpty() {
         if (!this.isEmpty()) {
            for (int i = 0; i < lockList.length; i++) {
                lockList[i] = null;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < lockList.length; i++) {
            if (lockList[i] != null) {
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    @Override
    public void rehash() {
        if (this.loadFactor() >= 75) {
            Lock[] holder = this.lockList;
            int newCapacity = this.capacity() * 3;
            while (!isPrime(newCapacity)) {
                newCapacity++;
            }

            this.lockList = new Lock[newCapacity];
            for (int i = 0; i < holder.length; i++) {
                if (holder[i] != null) {
                    this.put(holder[i].getSerialNumber(), holder[i]);
                }
            }
        }
    }

    @Override
    public Lock get(long serialNum) {
        int position = this.hash(serialNum);
        Lock holder = new Lock();//so that the to string method still works
        if (this.isEmpty()) {
            return holder;
        } else {
            Lock s;
            boolean found = false;
            do {
                s = this.lockList[position];
                if (s != null && s.getSerialNumber() == serialNum) {
                    found = true;
                    holder = s;
                } else {
                    position = ((position + 1) % this.capacity());
                }
            } while (!found && s != null);

        }
        return holder;
    }

    @Override
    public void put(long serialNum, Lock value) {
        int position = this.hash(serialNum);
        if (this.isEmpty()) {
            this.lockList[position] = value;
        } else if (this.lockList[position] == null && !this.containsSerialNumber(serialNum)) {
            this.lockList[position] = value;
        } else if (!this.containsSerialNumber(serialNum)) {
            int newPosition = ((position + 1) % this.capacity());
            while (this.lockList[newPosition] != null && newPosition != position) {
                newPosition = ((newPosition + 1) % this.capacity());

            }
            if (this.lockList[newPosition] == null) {
                this.lockList[newPosition] = value;
            }
        } else {
            System.out.println("Lock Already Exists");
        }
        this.rehash();
    }

    

    @Override
    public boolean containsSerialNumber(long serialNum) {
        int position = hash(serialNum);
        boolean serialExists = false;
        if (!this.isEmpty()) {
            if (this.lockList[position] != null) {
                if (lockList[position].getSerialNumber() == serialNum) {
                    serialExists = true;
                } else {
                    do {
                        if (this.lockList[position].getSerialNumber() == serialNum) {
                            serialExists = true;
                        } else {
                            position = ((position + 1) % this.capacity());
                        }
                    } while (!serialExists && this.lockList[position] != null);

                }
            }

        }
        return serialExists;
    }

    @Override
    public int hash(long serialNum) {
        int hashCode = (int)(serialNum % this.capacity());
        return hashCode;
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    

    
}
