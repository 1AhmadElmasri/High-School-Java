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
public class Blob {
    public double radius;
    public double colorDistance;
    public byte[] rgbValues;
    public int[][] pixelLocations;
    public int pixelCount;
    public int x , y , width , height;
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

    public static ArrayList<Blob> blobs = new ArrayList<Blob>();
    
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
    
    public Blob(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.pixelCount = 1;
    }
    
    public Blob(int pixelCount, int x, int y, int width, int height) {
        this.pixelCount = pixelCount;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    public Blob(int x, int y) {
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
        score = 150;
    }
    
    public Blob() {
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
    
    public void absorbBlob(Blob smaller){
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
    
    
    
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getColorDistance() {
        return colorDistance;
    }

    public void setColorDistance(double colorDistance) {
        this.colorDistance = colorDistance;
    }

    public byte[] getRgbValues() {
        return rgbValues;
    }

    public void setRgbValues(byte[] rgbValues) {
        this.rgbValues = rgbValues;
    }

    public int getPixelCount() {
        return pixelCount;
    }

    public void setPixelCount(int pixelCount) {
        this.pixelCount = pixelCount;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    
    
    
}
