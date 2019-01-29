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
public class Filter {

    public static int colorThreshold = 25;
    public int[] pixelsFound;
    public int pixelCount = 0;
    public static double distanceThreshold = 140;

    public static int getColorThreshold() {
        return colorThreshold;
    }

    public static void setColorThreshold(int colorThreshold) {
        Filter.colorThreshold = colorThreshold;
    }

    public static double getDistanceThreshold() {
        return distanceThreshold;
    }

    public static void setDistanceThreshold(int distanceThreshold) {
        Filter.distanceThreshold = distanceThreshold;
    }

    public static int getThreshold() {
        return colorThreshold;
    }

    public static void setThreshold(int threshold) {
        Filter.colorThreshold = threshold;
    }

    public int[] getPixelsFound() {
        return pixelsFound;
    }

    public void setPixelsFound(int[] pixelsFound) {
        this.pixelsFound = pixelsFound;
    }

    public int getPixelCount() {
        return pixelCount;
    }

    public void setPixelCount(int pixelCount) {
        this.pixelCount = pixelCount;
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

    public static boolean isNear2(int pointX, int pointY) {
        for (int i = 0; i < Blob.blobs.size(); i++) {
            int centerX = (int) ((Blob.blobs.get(i).minX + (Blob.blobs.get(i).maxX)) / 2d);
            int centerY = (int) ((Blob.blobs.get(i).minY + (Blob.blobs.get(i).maxY)) / 2d);
            int maxX = Blob.blobs.get(i).maxX;
            int minX = Blob.blobs.get(i).minX;
            int maxY = Blob.blobs.get(i).maxY;
            int minY = Blob.blobs.get(i).minY;

            boolean isNear = false;

            double distance = dist(pointX, pointY, centerX, centerY);
//        System.out.println(distance);
            if (distance < (Blob.blobs.get(i).width / 2) + 20) {
                return true;
            }
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

        double distance = dist(pointX, pointY, centerX, centerY);
//        System.out.println(distance);
        if (distance < distanceThreshold) {
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
                    if (Blob.blobs.isEmpty()) {
                        b = new Blob(imageX, imageY);
                        Blob.blobs.add(b);
                    } else if (isNear2(imageX, imageY)) {
                        b.add(imageX, imageY, gray);
                    } else if (Blob.blobs.size() < 20000) {
                        b = new Blob(imageX, imageY);
                        Blob.blobs.add(b);
                    }
                }

            }
        }

//        for (int x = 0; x < width; x++) {
//                for (int y = 0; y < height; y++) {
//                    rgb = image.getRGB(x, y);
//                    red = (int) (((rgb >> 16) & 0x000000FF));
//                    green = (int) (((rgb >> 8) & 0x000000FF));
//                    blue = (int) (((rgb) & 0x000000FF));
//                    gray = (int) ((red + blue + green) / 3d);
//
//                    if (gray > 150) {
//                        if (Blob.blobs.isEmpty()) {
//                            b = new Blob(x, y);
//                            Blob.blobs.add(b);
//                        } else if (isNear(x, y, b)) {
//                            b.add(x, y);
//                        } else if (Blob.blobs.size() < 10) {
//                            b = new Blob(x, y);
//                            Blob.blobs.add(b);
//                        }
//                    }
//
//                }
//            }
        int position = 0;
        Blob largest = null;
        ArrayList<Blob> larges = new ArrayList<Blob>();

        if (Blob.blobs.size() > 2) {
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < Blob.blobs.size() - 1; i++) {

                    if (Blob.blobs.get(i).score > Blob.blobs.get(i + 1).score) {
                        largest = Blob.blobs.get(i);
                        position = i;
                    } else if (Blob.blobs.get(i).score < Blob.blobs.get(i + 1).score) {
                        largest = Blob.blobs.get(i + 1);
                        position = i + 1;
                    } else if (Blob.blobs.get(i).score == Blob.blobs.get(i + 1).score) {
                        largest = Blob.blobs.get(i);
                        position = i;
                    }
                }

                larges.add(largest);
                Blob.blobs.remove(position);
            }
        } else if (Blob.blobs.size() <= 2) {
            larges = Blob.blobs;
        }

//        if (Blob.blobs.size() > 2) {
//            for (int j = 0; j < 2; j++) {
//                for (int i = 0; i < Blob.blobs.size() - 1; i++) {
//                    if (Blob.blobs.get(i).pixelCount > Blob.blobs.get(i + 1).pixelCount) {
//                        largest = Blob.blobs.get(i);
//                        position = i;
//                    } else if (Blob.blobs.get(i).pixelCount < Blob.blobs.get(i + 1).pixelCount) {
//                        largest = Blob.blobs.get(i + 1);
//                        position = i + 1;
//                    } else if (Blob.blobs.get(i).pixelCount == Blob.blobs.get(i + 1).pixelCount){
//                        largest = Blob.blobs.get(i);
//                        position = i;
//                    }
//                }
//                larges.add(largest);
//                Blob.blobs.remove(position);
//            }
//        } else if (Blob.blobs.size() <= 2) {
//            larges = Blob.blobs;
//        }
//
        for (int i = 0; i < Blob.blobs.size(); i++) {
            Blob temp = Blob.blobs.get(i);
            for (int j = 0; j < larges.size(); j++) {
                if (isClose(temp.centerX, temp.centerY, larges.get(j))) {
                    larges.get(j).absorbBlob(temp);
                }
            }
            //Blob.blobs.remove(i);

        }
        return larges;
    }

  

}
