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
public class MathematicalRecursion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double finalValue = recursionTerms(2,5);
        System.out.println(finalValue);
        
    }
    
    public static int recursiveTerms(int firstTerm, int numOfRuns){
        int totalValue = 0;
        if(numOfRuns > 1){ 
            return recursiveTerms( (firstTerm * 3) + 1, numOfRuns - 1);
        }else{
            totalValue = firstTerm;
            
        }
        return totalValue;
    }
    
    public static double recursionTerms(double term, int numOfRuns){
        double totalValue = 0;
        if (numOfRuns > 0) {
            System.out.println(term);
//            System.out.print( " " + numOfRuns);
            return recursionTerms( 1 - (1/term) , numOfRuns-1);
        }else{
            totalValue = term;
        }
        return totalValue;
    }
    
}
