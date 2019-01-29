/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageProcessing;

import static ImageProcessing.ImageReading.insertToArrayEnd;
import java.awt.image.BufferedImage;

/**
 *
 * @author ahmad
 */
public class TestParticles {

    /**
     * @param args the command line arguments
     */
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
        int[][][] objectHolder = new int[0][][];
        int cutOff = 0;
        int lastIndexAbove = 0;
        int lastIndexBelow = 0;
        int[] xVal = new int[0];
        int[] yVal = new int[0];
        int[] redX = new int[0];
        int[] redY = new int[0];
        
        for (int y = 0; y < yValues.length - 1; y++) {
            if ((yValues[y + 1] - yValues[y]) <= 8) {
                int[] secArrayHolder = new int[0];
                int[][] secArray = yObjects[y + 1];
                    for (int i = 0; i < secArray.length; i++) {
                        secArrayHolder = secArray[i];
                    }
                    int len2 = secArrayHolder.length;
                    lastIndexBelow = len2;
                    System.out.println(len2);
                for (int x = 0; x < yObjects[y].length-1; x++) {
                    
                    redX = insertToArrayEnd(redX, yObjects[y][0][0]);
                    redY = insertToArrayEnd(redY, yValues[y]);
                    
                    if (yObjects[y][x][0] - secArray[secArray.length-1][0] <= 10 || (secArray[secArray.length-1][0] - yObjects[y][x][0]) <= 10) {
                        if(cutOff <= 10){
                            cutOff = 0;
                            for (int i = 0; i < yObjects[y][x].length; i++) {
                                xVal = insertToArrayEnd(xVal, yObjects[y][x][i]);
                            }
                            yVal = insertToArrayEnd(yVal, yValues[y]);
                            currentObject = insertToArrayEnd(currentObject, xVal);
                            currentObject = insertToArrayEnd(currentObject, yVal);
                            System.out.println(currentObject.length);
                        }
                    }
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

//        for (int i = 0; i < yObjects.length; i++) {
//            redY = insertToArrayEnd(redY, yValues[i]);
//        }
        for (int i = 0; i < redY.length; i++) {
            img.setRGB(redX[i], redY[i], 1000000000);

        }
        System.out.println(yObjects.length);
        return img;
    }

    public static void main(String[] args) {
        // TODO code application logic here
    }

}
