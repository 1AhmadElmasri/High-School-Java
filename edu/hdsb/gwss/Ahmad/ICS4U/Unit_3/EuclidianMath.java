/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_3;

/**
 *
 * @author ahmad
 */
public class EuclidianMath {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(Euclid(16,8));
    }
    
    public static int Euclid(int m, int n){
        if (m == n) {
            return m;           
        }
        else {
             return Euclid(Math.min(m, n), Math.max(m, n) - Math.min(m, n));
        }
    }
    
}
