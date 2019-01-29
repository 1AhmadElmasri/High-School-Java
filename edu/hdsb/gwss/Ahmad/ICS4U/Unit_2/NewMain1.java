/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_2;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author 1elmasriahm
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Scanner input = new Scanner(System.in); // to take in sentence
        String sentenceHolder;
        String[] wordsHolder;
        StringTokenizer wordSorter;
        int wordCount = 0;

        sentenceHolder = input.nextLine();
        wordSorter = new StringTokenizer(sentenceHolder, " ");

        wordCount = wordSorter.countTokens();
        wordsHolder = new String[wordCount];

        for (int i = 0; i < wordCount; i++) {
            wordsHolder[i] = wordSorter.nextToken();
        }
        for (int i = 0; i < wordsHolder.length; i++) {
            System.out.println(wordsHolder[i]);
        }
    }

}
