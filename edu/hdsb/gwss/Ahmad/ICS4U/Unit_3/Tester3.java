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
public class Tester3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(HiCount("xxhixxhixxhixx"));
    }
    public static int HiCount(String input){
	if(input.length() < 2){
		return 0;
	}else{
		if(input.substring(0,2).toLowerCase().equals("hi")){
			return 1 + HiCount(input.substring(2,input.length()));
		}else{
			return 0 + HiCount(input.substring(2,input.length()));
		}
	}
}
}
