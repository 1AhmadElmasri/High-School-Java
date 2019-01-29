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

/**
 *
 * @author ahmad
 */
public class MatFilter {

    public int pixelCount = 0;
    public static double distanceThreshold = 140;

    public static double getDistanceThreshold() {
        return distanceThreshold;
    }

    public static void setDistanceThreshold(int distanceThreshold) {
        MatFilter.distanceThreshold = distanceThreshold;
    }


    public static double dist(int x1, int y1, int x2, int y2) {
        return Math.abs(Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
    }

    public static boolean isNear(int pointX, int pointY, Blob b) {
        int centerX = (int) ((b.minX + b.maxX) / 2);
        int centerY = (int) ((b.minY + b.maxY) / 2);
        int maxX = b.maxX;
        int minX = b.minX;
        int maxY = b.maxY;
        int minY = b.minY;

        boolean isNear = false;

        double distance = dist(pointX, pointY, centerX, centerY);
//        System.out.println(distance);
        if (distance < distanceThreshold) {
            return true;
        }

        return false;
    }

    public static boolean isClose(int pointX, int pointY, Blob b) {
        int centerX = (int) ((b.minX + b.maxX) / 2);
        int centerY = (int) ((b.minY + b.maxY) / 2);
        int maxX = b.maxX;
        int minX = b.minX;
        int maxY = b.maxY;
        int minY = b.minY;

        int cX = Math.max((Math.min(pointX, maxX)), minX);
        int cY = Math.max((Math.min(pointY, maxY)), minY);
//        System.out.println(distance);

        double distance = dist(pointX, pointY, cX, cY);
//        System.out.println(distance);
        if (distance < 40) {
            return true;
        }

        return false;
    }

    public static ArrayList<Blob> findBlobs(BufferedImage image) {
        Blob.blobs.clear();
        int width = image.getWidth();
        int height = image.getHeight();

        int rgb = 0;
        int red = 0, green = 0, blue = 0;
        int gray = 0;
        int count = 0;
        Blob b = null;

        boolean found = false;

        for (int imageY = 0; imageY < height; imageY++) {
            for (int imageX = 0; imageX < width; imageX++) {
                rgb = image.getRGB(imageX, imageY);
                red = (int) (((rgb >> 16) & 0x000000FF));
                green = (int) (((rgb >> 8) & 0x000000FF));
                blue = (int) (((rgb) & 0x000000FF));
                gray = (int) ((red + blue + green) / 3d);

                if (gray > 100) {
                    if (Blob) {
                        
                    }
                }

            }
        }
        
        return Blob.blobs;

    }

  

}
