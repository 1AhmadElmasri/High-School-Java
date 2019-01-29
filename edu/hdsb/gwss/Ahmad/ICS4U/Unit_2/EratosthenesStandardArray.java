/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_2;

import java.util.ArrayList;

/**
 *
 * @author 1elmasriahm
 */
public class EratosthenesStandardArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Integer> numberList = new ArrayList<Integer>();
        int[] valueList = new int[999];
        for (int i = 2; i < 1001; i++) {
            valueList[i-2] = i;
        }
        
        for (int i = 0; i < valueList.length; i++) {
            if (valueList[i] != 0) {
                for (int j = i+1; j < valueList.length; j++) {
                    if (valueList[j] % valueList[i] == 0) {
                        valueList[j] = 0;
                    }
                }
            }
        }
        
//        for (int i = 0; i < numberList.size(); i++) {
//            for (int j = i+1; j < numberList.size(); j++) {
//                    if ((numberList.get(j) % numberList.get(i)) == 0) {
//                        numberList.remove(j);
//                }
//
//            }
//        }
//        for (int i = 0; i < numberList.size(); i++) {
//            if (i % 10 == 0) {
//                System.out.print("\n");
//            }
//            System.out.print(numberList.get(i) + " ");
//        }
            int prints = 0;
          for (int i = 0; i < valueList.length; i++) {
              
              if (valueList[i] != 0) {
                  if (prints % 10 == 0) {
                  System.out.println("");
                  }
                 System.out.print(valueList[i] + " "); 
                 prints++;
                 
              }
              
        }
    }

}
