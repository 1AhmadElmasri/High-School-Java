/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.ahmad.icsu.u3.methodsHomework;

/**
 *
 * @author ahmad
 */
public class PracticeMakesPerfect {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "ABC-DEF-GHI";
        char holder;
        System.out.println(s.length());
        System.out.println(s.charAt(3));
        for (int i = 0; i < s.length(); i++){
            holder = s.charAt(i);
            System.out.print(s.indexOf(holder) + " || ");
            System.out.print(holder + " || ");
            System.out.print(s.codePointAt(i) + " || \n");
            //toString()
            //toLowerCase()
            //toUpperCase()
            //indexOf()
        }
    }
    
}
