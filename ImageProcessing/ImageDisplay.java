/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageProcessing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ahmad
 */
public class ImageDisplay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws URISyntaxException {
        // TODO code application logic here
        BufferedImage img = null;
        
         File oldImage = new File("Markings.jpg");
        try {
            img = ImageIO.read(oldImage);
//        int width = img.getWidth();
//        int height = img.getHeight();
//        
//        int[][] values = new int[height][];
//        
//        for (int i = 0; i < height; i++) {
//            values[i] = new int[width];
//            for (int j = 0; j < width; j++) {
//                values[i][j] = j;
//            }
//        }
//        
//        for (int i = 0; i < height; i++) {
//            System.out.println("");
//            for (int j = 0; j < width; j++) {
//                System.out.print(values[i][j] + " ");
//            }
//        }
        } catch (IOException ex) {
            Logger.getLogger(ImageReading.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        JLabel label = new JLabel(new ImageIcon(img));
        frame.add(label);
        frame.setVisible(true);
    }
    
}
