/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_3;

/**
 *
 * @author 1elmasriahm
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] data = {1,2,5,8,9,13,15,17,25,54,56,78,87,95,100,123,145,156};
        System.out.println(bS(78, data));
        
    }
    
    public static int bS(int sV, int[] data){
        return bS(sV, data , 0, data.length -1);
    }
    
    public static int bS(int sV, int[] data, int leftIndex, int rightIndex){
        if(leftIndex > rightIndex || rightIndex < 0) return -1;
        
        int mid = (leftIndex + rightIndex) / 2;
        if(data[mid] == sV) return mid;
        
        
        if(data[mid] < sV) return bS(sV, data, mid+1, rightIndex);
        
        return bS(sV, data, leftIndex, mid-1);
    }

    
}
