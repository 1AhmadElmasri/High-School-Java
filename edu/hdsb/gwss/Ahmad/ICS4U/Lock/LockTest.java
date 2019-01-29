/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Lock;

import java.util.Arrays;

/**
 *
 * @author ahmad
 */
public class LockTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //Fixed Locks Test
        
        System.out.println("Test 1 ( Dubdley Lock ) : ");
        int[] rightCombo = new int[3];
        int[] wrongCombo = new int[3];
        
        DubdleyLock dubd = new DubdleyLock();
        rightCombo = dubd.getCombo();
        assert(dubd.isLocked());
        assert(dubd.isDisplayed());
        System.out.print("\nCombo Grab Test : ");
        wrongCombo = dubd.getCombo();
        
        for (int i = 0; i < wrongCombo.length; i++) {
            assert(wrongCombo[i] == -1);
        }
        
        System.out.print("\nInvalid Combo Test : ");
        for (int i = 0; i < wrongCombo.length; i++) {
            wrongCombo[i] = -1;
        }
        
        dubd.unLock(wrongCombo);
        
        System.out.print("\nInvalid Combo Length Test : ");
        wrongCombo = new int[4];
        
        dubd.unLock(wrongCombo);
        
        System.out.print("\nLocking when Already Locked : ");
        dubd.Lock();
        
        assert(dubd.isLocked());
        
        System.out.print("\nUnlock with right combo : ");
        dubd.unLock(rightCombo);
        
        assert(!dubd.isLocked());
        
        dubd.Lock();
        
        assert(dubd.isLocked());
        
        System.out.println("\nToo Many Unlock Attempts Test : ");
        dubd.unLock(wrongCombo);
        dubd.unLock(wrongCombo);
        dubd.unLock(wrongCombo);
        dubd.unLock(rightCombo);
        assert(dubd.isLocked());
        
        ///////////////////////////////////////
        
        System.out.println(" \n \nTest 2 ( Master Lock ) : ");
        
        rightCombo = new int[3];
        wrongCombo = new int[3];
        
        MasterLock mast = new MasterLock();
        rightCombo = mast.getCombo();
        assert(mast.isLocked());
        assert(mast.isDisplayed());
        System.out.print("\nCombo Grab Test : ");
        wrongCombo = mast.getCombo();
        
        for (int i = 0; i < wrongCombo.length; i++) {
            assert(wrongCombo[i] == -1);
        }
        
        System.out.print("\nInvalid Combo Test : ");
        for (int i = 0; i < wrongCombo.length; i++) {
            wrongCombo[i] = -1;
        }
        
        mast.unLock(wrongCombo);
        
        System.out.print("\nInvalid Combo Length Test : ");
        wrongCombo = new int[4];
        
        mast.unLock(wrongCombo);
        
        System.out.print("\nLocking when Already Locked : ");
        mast.Lock();
        
        assert(mast.isLocked());
        
        System.out.print("\nUnlock with right combo : ");
        mast.unLock(rightCombo);
        
        assert(!mast.isLocked());
        
        mast.Lock();
        
        assert(mast.isLocked());
        
        System.out.println("\nToo Many Unlock Attempts Test : ");
        mast.unLock(wrongCombo);
        mast.unLock(wrongCombo);
        mast.unLock(wrongCombo);
        mast.unLock(rightCombo);
        assert(mast.isLocked());
        
        
        //////////////////////////
        
        
        System.out.println("\n \nTest 3 ( MasterULock ) :  ");
        
        MasterULock mul = new MasterULock();
        
        rightCombo = new int[4];
        wrongCombo = new int[4];
        
        //Test 1 : Attempt to get Combo before it's set
        assert(!mul.isLocked());
        System.out.print("\nGet combo before it's set : ");
        rightCombo = mul.getCombo();
        
        for (int i = 0; i < rightCombo.length; i++) {
            assert(rightCombo[i] == -1);
        }
        
        //Test 2 : Attempt to set invalid combos
        //A : invalid combo Length
        System.out.print("\nInvalid Combo Length Test : ");
        wrongCombo = new int[5];
        mul.changeCombo(wrongCombo);
        assert(!mul.isLocked());
        
        //B : invalid combo Numbers
        System.out.print("\nNegative Combo Values Test : ");
        wrongCombo = new int[4];
        for (int i = 0; i < wrongCombo.length; i++) {
            wrongCombo[i] = -1;
        }
        mul.changeCombo(wrongCombo);
        
        
        assert(!mul.isLocked());
        
        //C : invalid combo Numbers
        System.out.print("\nOut of Bounds Combo Values Test : ");
        for (int i = 0; i < wrongCombo.length; i++) {
            wrongCombo[i] = 10;
        }
        mul.changeCombo(wrongCombo);
        
        System.out.print("\nInvalid Unlock Test : ");
        mul.unLock(wrongCombo);
        assert(!mul.isLocked());
        
        
        //Test 3 : Set Valid Combo
        rightCombo[0] = 5;
        rightCombo[1] = 7;
        rightCombo[2] = 3;
        rightCombo[3] = 4;
        
        mul.changeCombo(rightCombo);
        
        assert(!mul.isLocked());
        
        int[] arrayHolder = new int[4];
        
        System.out.print("\nGrabbing Valid Combo : ");
        
        arrayHolder = mul.getCombo();
        
        mul.Lock();
        
        assert(mul.isLocked());
        
        System.out.println("\nThree Unlock Attempts Test : ");
        mul.unLock(wrongCombo);
        mul.unLock(wrongCombo);
        mul.unLock(wrongCombo);
        mul.unLock(rightCombo);
        
        
        //////////////////////////
        
        
        System.out.println("\n \nTest 4 ( Android Lock ) : ");
        
        AndroidLock aL = new AndroidLock();
        
        rightCombo = new int[4];
        wrongCombo = new int[4];
        
        //Test 1 : Attempt to get Combo before it's set
        assert(!aL.isLocked());
        System.out.print("\nGet combo before it's set : ");
        rightCombo = aL.getCombo();
        
        for (int i = 0; i < rightCombo.length; i++) {
            assert(rightCombo[i] == -1);
        }
        
        //Test 2 : Attempt to set invalid combos
        //A : invalid combo Length
        System.out.print("\nInvalid Combo Length Test : ");
        wrongCombo = new int[5];
        aL.changeCombo(wrongCombo);
        assert(!aL.isLocked());
        
        //B : invalid combo Numbers
        System.out.print("\nNegative Combo Values Test : ");
        wrongCombo = new int[4];
        for (int i = 0; i < wrongCombo.length; i++) {
            wrongCombo[i] = -1;
        }
        aL.changeCombo(wrongCombo);
        
        
        assert(!aL.isLocked());
        
        //C : invalid combo Numbers
        System.out.print("\nOut of Bounds Combo Values Test : ");
        for (int i = 0; i < wrongCombo.length; i++) {
            wrongCombo[i] = 10;
        }
        aL.changeCombo(wrongCombo);
        
        System.out.print("\nInvalid Unlock Test : ");
        aL.unLock(wrongCombo);
        assert(!aL.isLocked());
        
        
        //Test 3 : Set Valid Combo
        rightCombo[0] = 5;
        rightCombo[1] = 7;
        rightCombo[2] = 3;
        rightCombo[3] = 4;
        
        aL.changeCombo(rightCombo);
        
        assert(!aL.isLocked());
        
        arrayHolder = new int[4];
        
        System.out.print("\nGrabbing Valid Combo : ");
        
        arrayHolder = aL.getCombo();
        
        aL.Lock();
        
        assert(aL.isLocked());
        
        System.out.println("\nThree Unlock Attempts Test : ");
        aL.unLock(wrongCombo);
        aL.unLock(wrongCombo);
        aL.unLock(wrongCombo);
        aL.unLock(rightCombo);
        
        
        
        
    }
    
    
    
    
    
    
}
