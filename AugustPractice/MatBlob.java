/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AugustPractice;

import java.util.ArrayList;

/**
 *
 * @author ahmad
 */
public class MatBlob {
   
    public int[][] pixels;
    public int pixelCount;
    public int width , height;
    public int minX, maxX, minY, maxY;
    public int area;
    public int centerX = 0, centerY = 0;
    public double score = 0;

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public static ArrayList<MatBlob> blobs = new ArrayList<MatBlob>();
    
    public void add(int x, int y){
        this.minX = Math.min(x, this.minX);
        this.minY = Math.min(y, this.minY);
        this.maxX = Math.max(x, this.maxX);
        this.maxY = Math.max(y, this.maxY);
        
        this.width = this.maxX - this.minX;
        this.height = this.maxY - this.minY;
        
        this.area = (this.maxX - this.minX) * (this.maxY - this.minY);
        this.centerX = (int) ((this.minX + this.maxX) / 2);
        this.centerY = (int) ((this.minY + this.maxY) / 2);
        
    }
    
    public void add(int x, int y, int gray){
        this.minX = Math.min(x, this.minX);
        this.minY = Math.min(y, this.minY);
        this.maxX = Math.max(x, this.maxX);
        this.maxY = Math.max(y, this.maxY);
        
        this.width = this.maxX - this.minX;
        this.height = this.maxY - this.minY;
        
        this.pixelCount ++;
        
        this.area = (this.maxX - this.minX) * (this.maxY - this.minY);
        this.centerX = (int) ((this.minX + this.maxX) / 2);
        this.centerY = (int) ((this.minY + this.maxY) / 2);
        score += gray;
    }
   

    public MatBlob(int x, int y) {
        this.minX = x;
        this.maxX = y;
        this.minY = x;
        this.maxY = y;
        this.width = 1;
        this.height = 1;
        this.pixelCount = 1;
        this.centerX = x;
        this.centerY = y;
        this.area = 1;
        score = 1;
    }
    
    public MatBlob() {
        this.minX = 0;
        this.maxX = 0;
        this.minY = 0;
        this.maxY = 0;
        this.width = 0;
        this.height = 0;
        this.pixelCount = 0;
        this.centerX = 0;
        this.centerY = 0;
        this.area = 0;
    }
    
    public void absorbBlob(MatBlob smaller){
        this.minX = Math.min(smaller.minX, this.minX);
        this.minY = Math.min(smaller.minY, this.minY);
        this.maxX = Math.max(smaller.maxX, this.maxX);
        this.maxY = Math.max(smaller.maxY, this.maxY);
        
        this.width = this.maxX - this.minX;
        this.height = this.maxY - this.minY;
        
        this.pixelCount += smaller.pixelCount;
        
        this.area = (this.maxX - this.minX) * (this.maxY - this.minY);
        
        this.centerX = (int) ((this.minX + this.maxX) / 2);
        this.centerY = (int) ((this.minY + this.maxY) / 2);
    }
    
    
    
    
}
