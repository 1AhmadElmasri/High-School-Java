/*
 * Mountain Paths - Greedy Algorithm
 * Mr. Muir
 * 2018.03.26 - v1.0
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_3;

import java.util.*;
import java.io.*;
import java.awt.*;

public class MountainPaths {

    /**
     * Mount Paths
     */
    public static void main(String[] args) throws Exception {

        // ***********************************
        // TASK 1:  read data into a 2D Array
        // 
        System.out.println("TASK 1: READ DATA");
        int[][] data = read(".//data//mountain.paths//Colorado.844x480.dat");

        // ***********************************
        // Construct DrawingPanel, and get its Graphics context
        //
        DrawingPanel panel = new DrawingPanel(data[0].length, data.length);
        Graphics g = panel.getGraphics();

        // ***********************************
        // TASK 2:  find HIGHEST & LOWEST elevation; for GRAY SCALE
        //
        System.out.println("TASK 2: HIGHEST / LOWEST ELEVATION");
        int min = findMinValue(data);
        System.out.println("\tMin: " + min);

        int max = findMaxValue(data);
        System.out.println("\tMax: " + max);

        // ***********************************
        // TASK 3:  Draw The Map
        //
        System.out.println("TASK 3: DRAW MAP");
        drawMap(g, data);

        // ***********************************
        // TASK 4A:  implement indexOfMinInCol
        //
        System.out.println("TASK 4A: INDEX OF MIN IN COL 0");
        int minRow = indexOfMinInCol(data, 0);
        System.out.println("\tRow with lowest Col 0 Value: " + minRow);

        // ***********************************
        // TASK 4B:  use minRow as starting point to draw path
        //
        System.out.println("TASK 4B: PATH from LOWEST STARTING ELEVATION");
        g.setColor(Color.RED);
        int totalChange = drawLowestElevPath(g, data, minRow, 0); //
        System.out.println("\tLowest-Elevation-Change Path starting at row " + minRow + " gives total change of: " + totalChange);

        // ***********************************
        // TASK 5:  determine the BEST path
        //
        g.setColor(Color.RED);
        int bestRow = indexOfLowestElevPath(g, data);
        //int bestRow = drawLowestElevPath(g, data, 1, 0);

        // ***********************************
        // TASK 6:  draw the best path
        //
        System.out.println("TASK 6: DRAW BEST PATH");
        //drawMap.drawMap(g); //use this to get rid of all red lines
        g.setColor(Color.GREEN); //set brush to green for drawing best path
        System.out.println("Best Row Being Passed is: " + bestRow);
        totalChange = drawLowestElevPath(g, data, bestRow, 0);
        System.out.println("\tThe Lowest-Elevation-Change Path starts at row: " + bestRow + " and gives a total change of: " + totalChange);

    }

    /**
     * This method reads a 2D data set from the specified file. The Graphics'
     * industry standard is width by height (width x height), while programmers
     * use rows x cols / (height x width).
     *
     * @param fileName the name of the file
     * @return a 2D array (rows x cols) of the data from the file read
     */
    public static int[][] read(String fileName) throws FileNotFoundException {
        int width = 0, height = 0;
        int[][] data = null;
        StringTokenizer dataSorter = new StringTokenizer("");

        File elevationFile = new File(fileName);
        Scanner elevationHolder = new Scanner(elevationFile);
        while (elevationHolder.hasNextLine()) {
            height++;
            dataSorter = new StringTokenizer(elevationHolder.nextLine());
        }
        while (dataSorter.hasMoreTokens()) {
            width++;
            dataSorter.nextToken();
        }

        data = new int[height][width];

        elevationFile = new File(".//data//mountain.paths//Colorado.844x480.dat");
        elevationHolder = new Scanner(elevationFile);

        for (int row = 0; row < height; row++) {
            dataSorter = new StringTokenizer(elevationHolder.nextLine());
            for (int col = 0; col < width; col++) {
                data[row][col] = Integer.parseInt(dataSorter.nextToken());
            }
        }

        return data;
    }

    /**
     * @param grid a 2D array from which you want to find the smallest value
     * @return the smallest value in the given 2D array
     */
    public static int findMinValue(int[][] grid) {
        int lowest = Integer.MAX_VALUE;
        // TODO
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (lowest > grid[row][col]) {
                    lowest = grid[row][col];

                }
            }
        }
        return lowest;

    }

    /**
     * @param grid a 2D array from which you want to find the largest value
     * @return the largest value in the given 2D array
     */
    public static int findMaxValue(int[][] grid) {

        int highest = Integer.MIN_VALUE;
        // TODO
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (highest < grid[row][col]) {
                    highest = grid[row][col];

                }
            }
        }
        return highest;

    }

    /**
     * Given a 2D array of elevation data create a image of size rows x cols,
     * drawing a 1x1 rectangle for each value in the array whose color is set to
     * a a scaled gray value (0-255). Note: to scale the values in the array to
     * 0-255 you must find the min and max values in the original data first.
     *
     * @param g a Graphics context to use
     * @param grid a 2D array of the data
     */
    public static void drawMap(Graphics g, int[][] data) {
        // TODO
        int colorValue = 0;
        double holder = 0;
        int max = 0, min = 0, range = 0, factor = 0;
        max = findMaxValue(data);
        min = findMinValue(data);
        range = max - min;
        factor = range / 256;
        //System.out.println(factor);
        Color positionColor = new Color(0, 0, 255);

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                holder = ((double) (data[row][col] - min) / range) * 255;
                colorValue = (int) holder;
//                System.out.println((double));
                positionColor = new Color(colorValue, colorValue, colorValue);
                g.setColor(positionColor);
                g.fillRect(col, row, 1, 1);
                //System.out.println(holder);

            }
        }

    }

    /**
     * Scan a single column of a 2D array and return the index of the row that
     * contains the smallest value
     *
     * @param grid a 2D array
     * @col the column in the 2D array to process
     * @return the index of smallest value from grid at the given col
     */
    public static int indexOfMinInCol(int[][] grid, int col) {
        // TODO
        int lowest = Integer.MAX_VALUE;
        int index = 0;
        for (int pos = 0; pos < grid.length; pos++) {
            if (grid[col][pos] <= lowest) {
                lowest = grid[col][pos];
                index = pos;
            }
        }
        return index;
    }

    /**
     * Find the minimum elevation-change route from West-to-East in the given
     * grid, from the given starting row, and draw it using the given graphics
     * context
     *
     * @param g - the graphics context to use
     * @param grid - the 2D array of elevation values
     * @param row - the starting row for traversing to find the min path
     * @return total elevation of the route
     */
    public static int drawLowestElevPath(Graphics g, int[][] data, int row, int col) {
        int totalChange = 0;
        g.drawRect(col, row, 0, 0);
        int rowSelected = row;
        if (col < (data[row].length - 1)) {
            int changeStraight = Math.abs(data[row][col] - data[row][col + 1]);
            int changeUp = Integer.MAX_VALUE;
            int changeDown = Integer.MAX_VALUE;
             g.drawRect(col, row, 0, 0);

            if (row < data.length - 1) {
                changeDown = Math.abs(data[row][col] - data[row + 1][col + 1]);
            }
            if (row > 0) {
                changeUp = Math.abs(data[row][col] - data[row - 1][col + 1]);
            }

            if (changeStraight <= Math.min(changeDown, changeUp)) {
                rowSelected = row;
                return changeStraight + drawLowestElevPath(g, data, row, col + 1);
            }

            if ( changeUp == changeDown ) {
                int randomSelection = Math.random() < 0.5 ? 0 : 2;
                rowSelected = (row - 1) + randomSelection;
                return changeUp + drawLowestElevPath(g, data, (row - 1) + randomSelection, col + 1);
            }

            if (changeUp < changeDown ) {
                rowSelected = (row - 1);
                return changeUp +  drawLowestElevPath(g, data, row - 1, col + 1);
            }
            if ( changeDown < changeUp ) {
                rowSelected = (row + 1);
                return changeDown +  drawLowestElevPath(g, data, row + 1, col + 1);
            }

//            totalChange = change;
//           g.drawRect(col, rowSelected, 0, 0);
//            totalChange += drawLowestElevPath(g, data, rowSelected, col + 1);
        }
        //System.out.println(totalChange);

        return totalChange;
    }

    /**
     * Generate all west-to-east paths, find the one with the lowest total
     * elevation change, and return the index of the row that path starts on.
     *
     * @param g - the graphics context to use
     * @param grid - the 2D array of elevation values
     * @return the index of the row where the lowest elevation-change path
     * starts.
     */
    public static int indexOfLowestElevPath(Graphics g, int[][] data) {
        int lowestChange = Integer.MAX_VALUE;
        int bestRow = 0, change = 0;
        for (int row = 0; row < data.length; row++) {
            change = drawLowestElevPath(g, data, row, 0);
            if (change <= lowestChange) {
                bestRow = row;
                lowestChange = change;
            }
        }

        return bestRow;
    }

}
