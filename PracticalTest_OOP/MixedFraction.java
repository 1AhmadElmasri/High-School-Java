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
public class MixedFraction extends Fraction{
    private int mixedNum;

    public MixedFraction() {
        super();
        this.mixedNum = 1;
    }

    public MixedFraction(int numerator, int denominator, int mixedNum) {
        super(numerator, denominator);
        this.mixedNum = mixedNum;
    }
    
    public MixedFraction(int numerator, int denominator) {
        super(numerator, denominator);
        this.mixedNum = 1;
    }
    
    public ImproperFraction toImproper(){
        ImproperFraction holder;
        int num = 0, den = 0;
        
        int addedNum = (Math.abs(this.mixedNum)) * this.getDenominator();
        
        num = this.getNumerator() + addedNum;
        den = this.getDenominator();
        
        if (this.mixedNum < 0) {
            num *= -1;
        }
        
        holder = new ImproperFraction(num,den);
        
        return holder;
        
    }
    
    

    @Override
    public String toString() {
        
        return super.toString() + "mixedNum=" + mixedNum + '}';
    }
    
    
    
    
}
