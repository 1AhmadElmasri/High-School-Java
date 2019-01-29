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
public class Fraction implements FractionInterface {
    
    private int numerator;
    private int denominator;

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;//Cannot have fractions with a denominator of zero, as zero is impossible
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        
        if (denominator == 0) {
            this.denominator = 1;
            System.out.println("Invalid denominator, cannot be set to zero");
            System.out.println("Please set the denominator again, current value is " + this.denominator);  
        }else{
            if (denominator < 0) {
                this.numerator *= -1;
                this.denominator = -denominator;
            }else{
                this.denominator = denominator;
            }
            
        }
        
        
    }
    
    public int getNumerator() {
        return numerator;
    }


    public int getDenominator() {
        return denominator;
    }
    
    
    @Override
    public double size(){ 
        return ((double)this.numerator / this.denominator);
    }
    
    @Override
    public Fraction larger(Fraction f){
        if (f.size() > this.size()) {
            return f;
        }else if(f.size() < this.size()){
            return this;
        }else{
            return this;
        }
    }
    
    
    public static Fraction larger(Fraction a, Fraction b){
        if (a.size() > b.size()) {
            return a;
        }else if(a.size() < b.size()){
            return b;
        }else{
            return a;
        }
    }
    
    @Override
    public Fraction times( Fraction f ){
        Fraction holder = new Fraction();
        holder.numerator = this.numerator * f.numerator;
        
        if (this.denominator != 0 && f.denominator != 0) {
            holder.denominator = this.denominator * f.denominator;
        }else{
            System.out.println("Cannot Divide by zero, denominator set to 1");
            holder.denominator = 1;
        }

        return holder; 
    }
    
    public static Fraction times( Fraction a, Fraction b ){
        Fraction holder = new Fraction();
        holder.numerator = a.numerator * b.numerator;
        
        if (a.denominator != 0 && b.denominator != 0) {
            holder.denominator = a.denominator * b.denominator;
        }else{
            System.out.println("Cannot Divide by zero, denominator set to 1");
            holder.denominator = 1;
        }

        return holder; 
    }
    
    @Override
    public void reduce(){
        if ((this.numerator % this.denominator) == 0) {
            this.numerator = this.numerator / this.denominator;
            this.denominator = 1;
        }else{
            int remainder = Math.max(this.numerator, this.denominator) % Math.min(this.numerator, this.denominator);
            if ((this.numerator % remainder) == 0 && (this.denominator % remainder) == 0) {
                this.numerator = this.numerator / remainder;
                this.denominator = this.denominator / remainder;
            }
        }
    }
    
    @Override
    public boolean equals(Fraction f){
        if (this.numerator == f.numerator && this.denominator == f.denominator) {
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public void invert(){
        int num = this.numerator;
        int den = this.denominator;
        
        this.numerator = den;
        this.denominator = num;
        
        if (this.denominator == 0) {
            System.out.println("Cannot have a denominator of 0, set to 1");
            this.denominator = 1;
        }else if (this.denominator < 0) {
            this.denominator *= -1;
            this.numerator *= -1;
        }
        
       
    }
    
    

    @Override
    public String toString() {
        return "Fraction{" + "numerator=" + numerator + ", denominator=" + denominator + '}';
    }
    
    
    
    
    
    
    
    
}
