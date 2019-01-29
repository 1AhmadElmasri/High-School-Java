/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageProcessing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
public class ImageReading {

    /**
     * @param args the command line arguments
     */
    public static void filtering(int top, int bottom) {
        // TODO code application logic here
        BufferedImage img = null;
        Color color;
        int extractedColor;
        int sizeCutter = 0;
        boolean objectComplete = false;
        int size = 0;
        try {
            img = ImageIO.read(new File("Markers.jpg"));
            int width = img.getWidth();
            int height = img.getHeight();

            int[][] values = new int[height][];

            for (int y = 0; y < height; y++) {
                values[y] = new int[width];
                for (int x = 0; x < width; x++) {
                    color = new Color(img.getRGB(x, y));
                    int green = color.getGreen();
                    if (green > top) {
                        green = 0;
                    }
                    if (green < bottom) {
                        green = 0;
                    }
                    values[y][x] = green;

                }
            }
            System.out.println(height);

            for (int y = 0; y < height; y++) {
                System.out.println("");
                for (int x = 0; x < width; x++) {
                    sizeCutter = 0;

                    if (values[y][x] != 0) {
                        objectComplete = false;
                        for (int i = x; i < width; i++) {
                            if (values[y][i] != 0 && objectComplete == false) {
                                sizeCutter++;
                            } else {
                                objectComplete = true;
                                size = i;
                            }
                        }
                        if (sizeCutter < 5) {
                            for (int i = x; i < x + size; i++) {
                                values[y][x] = 0;
                            }
                        }
                    } else {

                    }
                    color = new Color(0, values[y][x], 0);
                    extractedColor = color.getRGB();

                    img.setRGB(x, y, extractedColor);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ImageReading.class.getName()).log(Level.SEVERE, null, ex);
        }

        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        JLabel label = new JLabel(new ImageIcon(img));
        frame.add(label);
        frame.setVisible(true);
    }

    public static void filteringTwo(int top, int bottom) {
        // TODO code application logic here
        BufferedImage img = null;
        Color color;
        int extractedColor;
        int sizeCutter = 0;
        boolean objectComplete = false;
        int width = 0;
        int height = 0;
        int[][] values = new int[0][];
        int size = 0;
        try {
            img = ImageIO.read(new File("Markers.jpg"));
            BufferedImage oldImg = img;
            width = img.getWidth();
            height = img.getHeight();

            values = new int[height][];

            for (int y = 0; y < height; y++) {
                values[y] = new int[width];
                for (int x = 0; x < width; x++) {
                    color = new Color(img.getRGB(x, y));
                    int green = color.getGreen();
                    if (green > top) {
                        green = 0;
                    }
                    if (green < bottom) {
                        green = 0;
                    }
                    values[y][x] = green;

                }
            }
            System.out.println(height);

            for (int y = 0; y < height; y++) {
                System.out.println("");
                for (int x = 0; x < width; x++) {
                    sizeCutter = 0;

                    if (values[y][x] != 0) {
                        objectComplete = false;
                        int blue = (new Color(oldImg.getRGB(x, y))).getBlue();
                        int red = (new Color(oldImg.getRGB(x, y))).getRed();
                        if (values[y][x] >= blue - 20 && values[y][x] <= blue + 20) {
                            values[y][x] = 0;
                        }
                        if (values[y][x] >= red - 20 && values[y][x] <= red + 20) {
                            values[y][x] = 0;
                        }
                        for (int i = x; i < width; i++) {
                            if (values[y][i] != 0 && objectComplete == false) {
                                sizeCutter++;
                            } else {
                                objectComplete = true;
                                size = i;
                            }
                        }
                        if (sizeCutter < 20) {
                            for (int i = x; i < x + size; i++) {
                                values[y][x] = 0;
                            }
                        }
                    } else {

                    }
                    color = new Color(0, values[y][x], 0);
                    extractedColor = color.getRGB();

                    img.setRGB(x, y, extractedColor);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ImageReading.class.getName()).log(Level.SEVERE, null, ex);
        }
         img = TestParticles.particleAnalysis(width, height, values, img);

        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        JLabel label = new JLabel(new ImageIcon(img));
        frame.add(label);
        frame.setVisible(true);

    }

    public static BufferedImage particleAnalysis(int width, int height, int[][] values, BufferedImage img) {
        int[][][] yObjects = new int[0][][];
        int startingPosition;
        int[] rowSearched;
        int[][] xObjects = new int[0][];
        int[][] lastRowObjects;
        int[] xRowHolder = new int[0];
        int cutOffScoreX = 0;
        int[] yValues = new int[0];

        for (int y = 0; y < height; y++) {
            if (xObjects.length > 0) {
                yObjects = insertToArrayEnd(yObjects, xObjects);
                yValues = insertToArrayEnd(yValues, y - 1);
            }
            xObjects = new int[0][];
            cutOffScoreX = 0;

            for (int x = 0; x < width; x++) {

                if (values[y][x] != 0) {
                    if (cutOffScoreX <= 8) {
                        xRowHolder = insertToArrayEnd(xRowHolder, x);
                        cutOffScoreX = 0;
                    } else {
                        if (xRowHolder.length > 0) {
                            xObjects = insertToArrayEnd(xObjects, xRowHolder);
                        }
                        xRowHolder = new int[0];
                        cutOffScoreX = 0;
                    }
                } else {
                    cutOffScoreX++;
                }

            }
        }

        int[][][] objectsArray = new int[0][][];//the first is the object number
        //The second has two values, 0 or 1, 0 is for x, 1 is for yValues
        //the third is the actual numbers stored in the array
        int[][] currentObject = new int[0][];
        int cutOff = 0;
        int lastIndexAbove = 0;
        int lastIndexBelow = 0;
        int[] xVal = new int[0];
        int[] yVal = new int[0];

        for (int y = 0; y < yObjects.length - 1; y++) {
            if ((yValues[y + 1] - yValues[y]) <= 8) {
                for (int x = 0; x < yObjects[y].length; x++) {
                    int[] secArrayHolder = new int[0];
                    int[][] mainArr = new int[0][];
                    int[] mainArrHold = new int[0];

                    mainArr = yObjects[y];
                    mainArrHold = mainArr[x];
                    int len1 = mainArrHold.length;
                    lastIndexAbove = len1;

                    int[][] secArray = yObjects[y + 1];
                    for (int i = 0; i < secArray.length; i++) {
                        secArrayHolder = secArray[i];
                    }
                    int len2 = secArrayHolder.length;
                    lastIndexBelow = len2;
                    System.out.println(len2);


//                    for (int i = 0; i < yObjects[y][x].length; i++) {
//                        if (secArrayHolder[0] - yObjects[y][x][0] <= 20 || secArrayHolder[0] - yObjects[y][x][0] >= -20) {
////                            if (cutOff <= 10) {
////                                cutOff = 0;
////                                xVal = insertToArrayEnd(xVal, yObjects[y][x][i]);
////                                yVal = insertToArrayEnd(xVal, yValues[y]);
////                                currentObject = insertToArrayEnd(currentObject, xVal);
////                                currentObject = insertToArrayEnd(currentObject, yVal);
////                            } else {
////                                if (currentObject.length > 0) {
////                                    objectsArray = insertToArrayEnd(objectsArray, currentObject);
////                                }
////                                currentObject = new int[0][];
////                                cutOff = 0;
////
////                            }
//
//                        } else if (secArrayHolder[lastIndexBelow] - yObjects[y][x][lastIndexAbove] <= 20 || secArrayHolder[lastIndexBelow] - yObjects[y][x][lastIndexAbove] >= -20) {
////                            if (cutOff <= 10) {
////                                cutOff = 0;
////                                xVal = insertToArrayEnd(xVal, yObjects[y][x][i]);
////                                yVal = insertToArrayEnd(xVal, yValues[y]);
////                                currentObject = insertToArrayEnd(currentObject, xVal);
////                                currentObject = insertToArrayEnd(currentObject, yVal);
////                            } else {
////                                
////                                if (currentObject.length > 0) {
////                                    objectsArray = insertToArrayEnd(objectsArray, currentObject);
////                                }
////                                currentObject = new int[0][];
////                                cutOff = 0;
////                            }
//                        } else {
//                            cutOff++;
//                            System.out.println(cutOff);
//                        }
//                    }
                }

            } else {
                if (currentObject.length > 0) {
                    objectsArray = insertToArrayEnd(objectsArray, currentObject);
                }
                currentObject = new int[0][];
                cutOff = 0;
            }
        }

        System.out.println(objectsArray.length);
        int[] redY = new int[0];
        int[] redX = new int[0];
        int[][] valuesToChange = new int[0][];
//        for (int i = 0; i < objectsArray.length; i++) {
//            for (int x = 0; x < objectsArray[i][0].length; x++) {
//                redX = insertToArrayEnd(redX, objectsArray[i][0][x]);
//            }
//            for (int y = 0; y < objectsArray[i][1].length; y++) {
//                redY = insertToArrayEnd(redY, objectsArray[i][1][y]);
//            }
//        }
//        for (int x = 0; x < redX.length; x++) {
//            System.out.println(redX[x] + ", " + redY[x]);
//        }

//        for (int i = 0; i < objectsArray.length; i++) {
//            for (int j = 0; j < objectsArray[i][0].length; j++) {
//                System.out.println(objectsArray[i][0][j]);
//            }
//        }

        return img;
    }

    public static int[] insertToArrayEnd(int[] originalArray, int valueAdded) {
        int[] holder = new int[originalArray.length + 1];
        for (int i = 0; i < originalArray.length; i++) {
            holder[i] = originalArray[i];
        }
        holder[holder.length - 1] = valueAdded;
        return holder;
    }

    public static int[][][] insertToArrayEnd(int[][][] originalArray, int[][] valueAdded) {
        int[][][] holder = new int[originalArray.length + 1][][];
        for (int i = 0; i < originalArray.length; i++) {
            holder[i] = originalArray[i];
        }
        holder[holder.length - 1] = valueAdded;
        return holder;
    }

    public static int[][] insertToArrayEnd(int[][] originalArray, int[] valueAdded) {
        int[][] holder = new int[originalArray.length + 1][];
        for (int i = 0; i < originalArray.length; i++) {
            holder[i] = originalArray[i];
        }
        holder[holder.length - 1] = valueAdded;
        return holder;
    }

    public static void main(String[] args) {

        filteringTwo(200, 95);
    }

}


//                    for (int i = 0; i < yObjects[y][x].length; i++) {
//                        if (yObjects[y + 1][x][0] - yObjects[y][x][0] <= 10 || yObjects[y + 1][x][0] - yObjects[y][x][0] >= -10) {
//                            if (cutOff <= 8) {
//                                cutOff = 0;
//                                xVal = insertToArrayEnd(xVal, yObjects[y][x][i]);
//                                yVal = insertToArrayEnd(xVal, yValues[y]);
//                                currentObject = insertToArrayEnd(currentObject, xVal);
//                                currentObject = insertToArrayEnd(currentObject, yVal);
//                            } else {
//                                if (currentObject.length > 0) {
//                                    objectsArray = insertToArrayEnd(objectsArray, currentObject);
//                                }
//                                currentObject = new int[0][];
//                                cutOff = 0;
//
//                            }