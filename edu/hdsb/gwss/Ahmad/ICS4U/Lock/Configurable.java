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
public class Configurable extends Lock implements ConfigurableInterface{

    private static final int DEFAULT_SIZE = 4;
    private int highValue = 9;
    private int lowValue = 0;

    public Configurable() {
        super(DEFAULT_SIZE);
    }

    
    public Configurable(int size) {
        super(size);
    }
    
    public Configurable( int highVal, int lowVal, int size ) {
        super(highVal, lowVal, size);
        this.highValue = highVal;
        this.lowValue = lowVal;
    }

    private boolean isValid(int[] incomingCombo) {
        
        if (incomingCombo.length != this.combo.length) {
            System.out.println("Invalid Combo Length");
            return false;
        } else {
            for (int i = 0; i < incomingCombo.length; i++) {
                if(incomingCombo[i] < 0){
                    System.out.println("Combo can't have negative numbers");
                    return false;
                }else if (incomingCombo[i] > this.highValue || incomingCombo[i] < this.lowValue ) {
                    System.out.println("Combo values out of bounds");
                    return false;
                }
            }
        }

        return true;
    }

    public void changeCombo(int[] incomingCombo) {
        if (!this.isLocked()) {
            if (this.isValid(incomingCombo)) {
                this.combo = incomingCombo;
            }
        } else {
            System.out.println("Unlock the Lock First");
        }
    }
    
    
    @Override
    public int[] getCombo() {
        if (!this.isLocked() && this.comboValid() ) {
            System.out.println("Combo Grabbed");
            int[] returnValue = super.getCombo();
            return returnValue; 
        } else {
            if (this.comboValid()) {
                System.out.println("Unlock Lock First");
            }else{
                System.out.println("Set Valid Combo First");
            }
            

            int[] empty = new int[this.combo.length];
            for (int i = 0; i < empty.length; i++) {
                empty[i] = -1;
            }
            return empty;
        }

    }
}
