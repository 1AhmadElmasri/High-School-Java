/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Lock;

import java.util.Arrays;

/**
 *
 * @author 1elmasriahm
 */
public class Lock extends HashTable implements LockInterface {

    private static final HashTable lockList = new HashTable();
    private long serialNumber;
    private boolean locked;
    protected int[] combo;
    private int unlockAttempts = 0;

    private boolean inheritedCombo = false;

    public Lock() {
        this.initializeSerialNumber(serialNumber);
        this.locked = false;
    }

    public Lock(int size) {
        this.initializeSerialNumber(serialNumber);
        this.locked = false;

        this.combo = new int[size];

        for (int i = 0; i < this.combo.length; i++) {
            this.combo[i] = -1;
        }
    }

    public Lock(int highVal, int lowVal, int size) {
        this.initializeSerialNumber(serialNumber);
        this.locked = false;

        this.combo = new int[size];

        for (int i = 0; i < this.combo.length; i++) {
            this.combo[i] = -1;
        }
    }

    @Override
    public boolean lockExists(long serialNumber) {
        boolean valid = false;
        if (serialNumber > 0 && this.combo.length > 0) {
            if (lockList.containsSerialNumber(this.serialNumber)) {
                valid = true;
            }
        }

        return valid;
    }

    @Override
    public boolean comboValid() {
        boolean valid = true;
        for (int i = 0; i < this.combo.length; i++) {
            if (this.combo[i] < 0) {
                valid = false;
            }
        }

        return valid;
    }

    @Override
    public long getSerialNumber() {
        return this.serialNumber;
    }

    @Override
    public boolean isLocked() {
        return this.locked;
    }

    @Override
    public void unLock(int[] incomingCombo) {
        if (this.unlockAttempts < 3) {
            if (this.isLocked()) {
                if (incomingCombo.length == this.combo.length) {
                    if (this.comboValid()) {
                        if (Arrays.equals(incomingCombo, this.combo)) {
                            System.out.println("Unlock Successful");
                            this.locked = false;
                            this.unlockAttempts = 0;
                        } else {
                            System.out.println("Incorrect Combo, try again");
                            this.unlockAttempts++;
                        }
                    } else {
                        System.out.println("Set combo before attempting to unlock");
                        this.unlockAttempts++;
                    }
                } else {
                    System.out.println("Could not unlock, combo length invalid");
                    this.unlockAttempts++;
                }
            } else {
                System.out.println("Already Unlocked");
            }
        } else {
            System.out.println("Too Many Unlock Attempts");
        }

    }

    @Override
    public void Lock() {
        if (this.comboValid()) {
            if (!locked) {
                this.locked = true;
            } else {
                System.out.println("Already Locked");
            }

        } else {
            System.out.println("Initialize Combo First");
        }
    }

    @Override
    public void displayLockInfo() {
        System.out.println("Lock{" + "serialNumber=" + serialNumber + ", locked=" + locked);
    }

    @Override
    public int[] getCombo() {
        return this.combo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Lock other = (Lock) obj;
        if (this.serialNumber != other.getSerialNumber()) {
            return false;
        }
        return true;
    }

    @Override
    public int unlockAttempts() {
        return this.unlockAttempts;
    }

    @Override
    public HashTable getlockList() {
        return this.lockList;
    }

    //Privates
    private static long randomizeSerialNumber() {
        return (long) ((Math.random() * 9999999999L)) + 1;
    }

    private void initializeSerialNumber(long serialNumber) {
        do {
            this.serialNumber = this.randomizeSerialNumber();
        } while (this.lockList.containsSerialNumber(this.serialNumber));
        Lock.lockList.put(this.serialNumber, this);
    }

}
