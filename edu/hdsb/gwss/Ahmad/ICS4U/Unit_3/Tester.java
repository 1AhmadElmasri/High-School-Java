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
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(f(7,6));
    }
    public static int f(int x, int y){
        System.out.println(x + " " + y);
	if(x > 2 && x % 2 == 0){
		return f(y - 3, x + 2) + 3;
	}if(x % 2 == 1 && x > 2){
		return f(x - 3, y + 1) - 4;
	}else{
		return (int) Math.pow(x,2) + y + 1;
	}

}
}
