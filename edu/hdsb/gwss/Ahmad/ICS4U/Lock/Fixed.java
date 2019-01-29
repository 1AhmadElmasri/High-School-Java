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
public class Fixed extends Lock {

    private boolean displayed = false;
    private boolean initialized = false;
    private static final int DEFAULT_HIGH = 59;
    private static final int DEFAULT_LOW = 0;
    private static final int DEFAULT_SIZE = 3;

    public Fixed() {
        super();
        super.Lock();
        this.initializeCombo(DEFAULT_HIGH, DEFAULT_LOW, DEFAULT_SIZE);
    }

    public Fixed(int size) {
        super();
        this.initializeCombo(DEFAULT_HIGH, DEFAULT_LOW, size);
        super.Lock();
    }

    public Fixed(int highVal, int lowVal, int size) {
        super();
        this.initializeCombo(highVal, lowVal, size);
        super.Lock();

    }

    @Override
    public int[] getCombo() {
        if (!this.displayed) {
            System.out.println("Combo Grabbed");
            this.displayed = true;
            return super.getCombo();
        } else {
            System.out.println("Combo Already Grabbed");

            int[] empty = new int[this.combo.length];
            for (int i = 0; i < empty.length; i++) {
                empty[i] = -1;
            }
            return empty;
        }

    }

    private void initializeCombo(int highVal, int lowVal, int size) {
        int[] comboGen = new int[size];
        if (!initialized) {
            if (highVal > 0 && lowVal < highVal && size > 0) {
                for (int i = 0; i < size; i++) {
                    comboGen[i] = ((int) ((Math.random() * highVal) + lowVal) % highVal);
                }
                initialized = true;
                this.combo = comboGen;
            } else {
                for (int i = 0; i < size; i++) {
                    comboGen[i] = -1;
                }
                this.combo = comboGen;
                System.out.println("Invalid Combo, Try Again");
            }
        }else{
            System.out.println("Combo already initialized");
        }

    }

    public boolean isDisplayed() {
        return displayed;
    }
    
    

}
