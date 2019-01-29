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
public class Tester2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        blockCount(5);
        System.out.println(blockCount(3));
    }
    public static int blockCount(int n){
	if(n == 1){
		return n;
	}if(n > 1){
		return n + blockCount(n-1);
	}else{
            return - 1;
        }
}
}
