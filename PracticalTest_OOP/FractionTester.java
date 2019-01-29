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
public class FractionTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Test 1 - Size equals to zero
        System.out.println("TEST 1 - SIZE ZERO");
        Fraction a = new Fraction();
        Fraction b = new Fraction();
        assert(a.equals(b));
        System.out.println("To String Test  : " + a.toString() );
        System.out.println("To String Test  : " + b.toString() );
        assert(a.larger(b) == a);
        assert(Fraction.larger(a, b) == a);
        a.invert();
        assert(a.getDenominator() == 1);
        assert(a.getNumerator() == 1);
        assert(Fraction.times(a, b).equals(b));
        b.reduce();
        System.out.println(b.toString());
        
        
        //Test 2 - Different Size
        System.out.println("\n-------------------");
        System.out.println("TEST 2 - REGULAR SIZE");
        Fraction c = new Fraction(12,15);
        Fraction d = new Fraction(3,5);
        assert(!c.equals(d));
        System.out.println("To String Test  : " + c.toString() );
        System.out.println("To String Test  : " + d.toString() );
        assert(c.larger(d) == c);
        assert(Fraction.larger(c, d) == c);
        c.invert();
        assert(c.getDenominator() == 12);
        assert(c.getNumerator() == 15);
        c.invert();
        Fraction hold = new Fraction(36,75);
        assert(Fraction.times(c, d).equals(hold));
        hold.reduce();
        System.out.println(d.toString());
        
        //Test 4 - Improper Size
        System.out.println("\n-------------------");
        System.out.println("TEST 2 - REGULAR SIZE");
        ImproperFraction e = new ImproperFraction(17,5);
        MixedFraction holder = e.toMixed();
        System.out.println(holder.toString());
        
        
        e = holder.toImproper();
        System.out.println(e.toString());
        
        
        
        
        
        
        
        
        
        
    }
    
}
