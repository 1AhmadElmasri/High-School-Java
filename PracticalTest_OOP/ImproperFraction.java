/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PracticalTest_OOP;

/**
 *
 * @author 1elmasriahm
 */
public class ImproperFraction extends Fraction{
    
    
    public ImproperFraction() {
        super(5,2); //Cannot have 0/1 as an improper fraction, as 0/1 is proper
        System.out.println("Setting it to default value (5/2)");
        
    }

    public ImproperFraction(int numerator, int denominator) {
        super(numerator, denominator);
     
        if (this.getNumerator() < this.getDenominator()) {
            System.out.println("Cannot Be Done, Proper Fraction, inverting fraction");
            this.invert();  
        }  
    }
    
    
    public MixedFraction toMixed(){
        MixedFraction holder;
        int num = 0,den = 0,mixed = 0;
        
        mixed = Math.abs(this.getNumerator()) / Math.abs(this.getDenominator());
        num = Math.abs(this.getNumerator()) % Math.abs(this.getDenominator());
        den = Math.abs(this.getDenominator());
        
        
        
        if (this.getNumerator() < 0) {
            mixed *= -1; 
        }
        
        holder = new MixedFraction(num,den,mixed);
        
        return holder;
        
    }
    
}
