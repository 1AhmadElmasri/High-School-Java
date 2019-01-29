/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AugustPractice;

import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author ahmad
 */
public class Spinners {
    
    public static SpinnerModel lowerColorModel = new SpinnerNumberModel(0, 0, 255, 1);
    public static SpinnerModel higherColorModel = new SpinnerNumberModel(255, 0, 255, 1);
    public static SpinnerModel miscModel = new SpinnerNumberModel(100, 0, 10000, 1);
    public static SpinnerModel areaModel = new SpinnerNumberModel(100, 0, 10000, 1);
    
}
