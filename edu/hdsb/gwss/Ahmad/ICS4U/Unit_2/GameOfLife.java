/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_2;

import java.util.Scanner;

/**
 *
 * @author 1elmasriahm
 */
public class GameOfLife {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        boolean playing = true;
        int cellChoice = 0;
        int generationCount = 1;
        
        System.out.println("Enter the number of living cells you want"
                + " (between 0 and 399)");
        cellChoice = Integer.parseInt(input.nextLine());
        if (cellChoice > 400 || cellChoice <= 0) {
            System.out.println("Invalid input, try again");
            cellChoice = Integer.parseInt(input.nextLine());
        }
        
        char[][] cellGrid;
        
        if (cellChoice <= (int) ((20*20)/2)) {
            cellGrid = liveCellFiller(cellChoice);
        }else{
            cellGrid = deadCellFiller(cellChoice);
        }

        
        while(playing){
            System.out.println("Generation " + generationCount + " : ");
            System.out.println("--------------------");
            cellPrinter(cellGrid);
            System.out.println("--------------------");
            System.out.println("Press enter to begin the next generation");
            input.nextLine();
            
            cellGrid = lifeChanger(cellGrid);
            generationCount ++;
            
        }
        
        
        
    }
    
    public static char[][] liveCellFiller(int liveCellCount){
        char[][] cellGrid = new char[20][20];
        int liveCells = 0;
        int column, row;
        for (column = 0; column < 20; column++) {
            for (row = 0; row < 20; row++) {
                cellGrid[column][row] = '.';
            }
        }
        while(liveCells < liveCellCount){
            column = (int) (Math.random() * 20);
            row = (int) (Math.random() * 20);
            if (cellGrid[column][row] != 'o') {
                cellGrid[column][row] = 'o';
                liveCells ++;
            }
        }
        return cellGrid;
    }
    
    public static char[][] deadCellFiller(int liveCellCount){
        char[][] cellGrid = new char[20][20];
        int liveCells = 0;
        int column, row;
        for (column = 0; column < 20; column++) {
            for (row = 0; row < 20; row++) {
                cellGrid[column][row] = 'o';
            }
        }
        while(liveCells < (400 - liveCellCount)){
            column = (int) (Math.random() * 20);
            row = (int) (Math.random() * 20);
            if (cellGrid[column][row] != '.') {
                cellGrid[column][row] = '.';
                liveCells ++;
            }
        }
        return cellGrid;
    }
    
    public static int lifeCounter(char[][] cellGrid, int yPosition, int xPosition){
        int liveCount = 0;
        int columnStart = -1, columnEnd = 1;
        int rowStart = -1, rowEnd = 1;
        
        if(cellGrid[yPosition][xPosition] == 'o'){
            liveCount --;
        }
        
        if (xPosition == 19) {
            rowEnd = 0;
        }else if(xPosition == 0){
            rowStart = 0;
        }
        
        if (yPosition == 19) {
            columnEnd = 0;
        }else if(yPosition == 0){
            columnStart = 0;
        }
        
        for (int col = (yPosition + columnStart); col <= (yPosition + columnEnd); col++) {
            for (int row = (xPosition + rowStart); row <= (xPosition + rowEnd); row++) {
                if (cellGrid[col][row] == 'o') {
                    liveCount++;
                }
            }
        }
        return liveCount;
    }
    
    public static char[][] lifeChanger(char[][] cellGrid){
        char[][] cellHolder = cellGrid;
        for (int col = 0; col < 20; col++) {
            for (int row = 0; row < 20; row++) {
                int lifeCount = 0;
                lifeCount = lifeCounter(cellGrid, col, row);
                
                if (cellGrid[col][row] == '.') {
                    if (lifeCount == 3 ) {
                        cellHolder[col][row] = 'o';
                    }
                }else{
                    if (lifeCount > 3 || lifeCount < 2) {
                        cellHolder[col][row] = '.';
                    }
                }
            }
        }
        return cellHolder;
    }
    
    public static void cellPrinter(char cellGrid[][]){
        int column, row;
        for (column = 0; column < 20; column++) {
            for (row = 0; row < 20; row++) {
                System.out.print(cellGrid[column][row] + " ");
            }System.out.println("");
        }
    }
    
    
    
    
    
}
