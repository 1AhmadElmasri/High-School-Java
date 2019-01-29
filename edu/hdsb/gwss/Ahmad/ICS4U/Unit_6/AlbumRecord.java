/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_6;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author ahmad
 */
public class AlbumRecord {

    public static void main(String args[]) throws Exception {
        
        

        System.out.println("Creating 4 Album Records");

        Album a1 = new Album("cybersex", "blackbear", 2000000, 14, 4, 4.56, 'H', true);
        Album a2 = new Album("melophobia", "cagetheelephant", 1534134, 10, 3, 4.72, 'R', true);
        Album a3 = new Album("Ma Fleur", "cinematicorchestra", 1000000, 11, 4, 5, 'O', true);
        Album a4 = new Album("damn", "KendrickLamar", 4000000, 14, 4, 4.67, 'H', true);
        Album a5 = new Album("Yes", "AhmadMasri", 12, 12, 4, 4.67, 'A', true);

        Database list = new Database();
        list.openFile("album_info.dat");
        
        list.clear();
        
//        list.writeRecord(a1);
//        list.writeRecord(a2);
//        list.writeRecord(a3);
//        list.writeRecord(a4);
//        list.writeRecord(a5);
        
        
        list.closeFile();
        
        
    }

    

}
