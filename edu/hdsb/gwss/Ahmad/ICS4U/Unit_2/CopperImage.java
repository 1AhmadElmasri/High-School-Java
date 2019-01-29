/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_2;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ahmad
 */
public class CopperImage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedImage img = null;
        int width, height;
        int red, green, blue;
        int[][][] rgbValues;
        Color holder;
        int rgb;
        
        try {
            img = ImageIO.read(new File("D:\\Arduino\\Java\\ICS4U-Ahmad\\ICS4U-Ahmad\\data\\movie.review\\copper-puzzle.png"));
            
            
            width = img.getWidth();
            height = img.getHeight();
            rgbValues = new int[width][height][3];
            
            
            
//            for (int xValue = 0; xValue < width; xValue++) {
//                for (int yValue = 0; yValue < height; yValue++) {
//                    holder = new Color(img.getRGB(xValue, yValue));
//                    red = holder.getRed();
//                    blue = holder.getBlue();
//                    green = holder.getGreen();
//                    
//                    rgbValues[xValue][yValue][0] = red;
//                    rgbValues[xValue][yValue][1] = green;
//                    rgbValues[xValue][yValue][2] = blue;
//                }
//            }
            
            for (int xValue = 0; xValue < width; xValue++) {
                for (int yValue = 0; yValue < height; yValue++) {
                    holder = new Color(img.getRGB(xValue, yValue));
                    red = holder.getRed();
                    blue = holder.getBlue();
                    green = holder.getGreen();
                    
                    blue *= 19;
                    green *= 19;
                    red = 0;
                    
                    holder = new Color(red, green, blue);
                    rgb = holder.getRGB();
                    img.setRGB(xValue, yValue, rgb);
                }
            }
            
            ImageIcon icon = new ImageIcon(img);
            JFrame frame = new JFrame();
            frame.setLayout(new FlowLayout());
            
            frame.setSize(width, height);
            JLabel lbl = new JLabel();
            lbl.setIcon(icon);
            frame.add(lbl);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        } catch (IOException e) {
        }
    }

}
