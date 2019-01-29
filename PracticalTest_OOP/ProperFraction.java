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
public class ProperFraction  extends Fraction{
    
    public ProperFraction() {
        super();
    }

    public ProperFraction(int numerator, int denominator) {
        super(numerator, denominator);
        
        if (this.getNumerator() > this.getDenominator()) {
            System.out.println("Cannot Be Done, Improper Fraction, inverting fraction");
            this.invert();  
        }  
    }
    
    
    public MixedFraction toMixed(){
        MixedFraction holder;
        int num = 0,den = 0,mixed = 0;
        mixed = 1;
        num = this.getNumerator();
        den = this.getDenominator();
        if(num == 0){
            num = 1;
            den = 1;
        }
        holder = new MixedFraction(num,den,mixed);
        
        return holder;
        
    }
    
    
}
