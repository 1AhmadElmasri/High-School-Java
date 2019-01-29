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
public interface FractionInterface {
    
    public double size();
    
    public Fraction larger(Fraction f);
    
    public Fraction times(Fraction f);
    
    public void reduce();
    
    public boolean equals(Fraction f);
    
    public void invert();
    
    @Override
    public String toString();
    
    
    
}
