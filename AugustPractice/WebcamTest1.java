/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AugustPractice;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import static org.opencv.imgcodecs.Imgcodecs.CV_LOAD_IMAGE_COLOR;
import org.opencv.videoio.VideoCapture;

/**
 *
 * @author ahmad
 */
public class WebcamTest1 {

    /**
     * @param args the command line arguments
     */
    public static PicWindow main = new PicWindow("Hello");
    public static JLabel label;
    public static Mat frame;
    public static BufferedImage display;
    public static ImageIcon image;

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws InterruptedException {

        
        String path = "C:\\opencv\\build\\java\\x64\\" ;
        System.setProperty("java.library.path", path);
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME );
        
        ArrayList<Blob> blobs = new ArrayList<Blob>();

        //System.load("C:\\opencv\\build\\java\\x64\\" + Core.NATIVE_LIBRARY_NAME );

        //System.out.println(Core.NATIVE_LIBRARY_NAME + ".jar");
        VideoCapture webCam = new VideoCapture(0);
        if (webCam.isOpened()) {
            System.out.println("Connected to " + webCam.toString());
        }

        initialFrame(webCam);

        JSpinner lowHueSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 255, 1));
        JSpinner highHueSpinner = new JSpinner(new SpinnerNumberModel(255, 0, 255, 1));
        JSpinner lowValSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 255, 1));
        JSpinner highValSpinner = new JSpinner(new SpinnerNumberModel(255, 0, 255, 1));
        JSpinner lowSatSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 255, 1));
        JSpinner highSatSpinner = new JSpinner(new SpinnerNumberModel(255, 0, 255, 1));
        JSpinner areaSpinner = new JSpinner(new SpinnerNumberModel(2500, 0, 5000, 50));

        JSpinner[] spinners = {lowHueSpinner, highHueSpinner, lowValSpinner, highValSpinner, lowSatSpinner, highSatSpinner, areaSpinner};

        for (int i = 0; i < spinners.length; i++) {
            spinners[i].setSize(40, 40);
            main.getFrame().add(spinners[i]);
            spinners[i].setLocation(100 + (50 * i), 650);
            spinners[i].setVisible(true);
        }

        spinners[spinners.length - 1].setSize(40, 40);
        spinners[spinners.length - 1].setLocation(100 + (50 * (spinners.length - 1)), 650);
        spinners[spinners.length - 1].setVisible(true);

        do {

            int[] hue = {Integer.parseInt(lowHueSpinner.getValue().toString()), Integer.parseInt(highHueSpinner.getValue().toString())};
            int[] sat = {Integer.parseInt(lowSatSpinner.getValue().toString()), Integer.parseInt(highSatSpinner.getValue().toString())};
            int[] val = {Integer.parseInt(lowValSpinner.getValue().toString()), Integer.parseInt(highValSpinner.getValue().toString())};

            webCam.read(frame);

            frame = MiscMethods.ThresholdHSV(frame, hue, sat, val);
             frame = Extras.cvErode(frame);
            frame = Extras.cvDilate(frame);
            frame = MiscMethods.blur(frame, 7.5);
//            frame = MiscMethods.blur(frame, 10.5);
            display = MiscMethods.MatGrayConvert(frame);
            display = MiscMethods.setBrightness(display);
//           
            

            blobs = Filter.findBlobs(display);

            Graphics2D g2d = display.createGraphics();
            g2d.drawImage(display, 0, 0, null);

            for (int i = 0; i < blobs.size(); i++) {
                g2d.setColor(Color.RED);

                int[] xVals = {blobs.get(i).minX, blobs.get(i).minX, blobs.get(i).maxX, blobs.get(i).maxX};
                int[] yVals = {blobs.get(i).minY, blobs.get(i).maxY, blobs.get(i).maxY, blobs.get(i).minY,};

                g2d.drawPolygon(xVals, yVals, 4);
            }
            g2d.dispose();

            main.getFrame().getContentPane().add(label);
            label.setIcon(new ImageIcon(display));
            label.setVisible(true);

            main.getFrame().repaint();
            main.getFrame().setVisible(true);
            blobs.clear();
        } while (webCam.isOpened());
    }

    public static void initialFrame(VideoCapture webCam) throws InterruptedException {
        webCam.get(CV_LOAD_IMAGE_COLOR);

        frame = new Mat();

        webCam.read(frame);

        int imageWidth = frame.width();
        int imageHeight = frame.height();
        main.getFrame().setSize(imageWidth + 100, imageHeight + 300);

        display = MiscMethods.MatConvert(frame);

        label = new JLabel(new ImageIcon(display));

        main.getFrame().getContentPane().add(label);
        label.setVisible(true);
        main.getFrame().setLocationRelativeTo(null);
        main.getFrame().repaint();
        main.getFrame().setVisible(true);
        main.getFrame().getContentPane().remove(label);
        Thread.sleep(50);
    }

}
