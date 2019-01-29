/*
 *
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_1;


import java.io.File;

/**
 * Movie Review Assignment
 *
 * @author Wm.Muir
 * @version 2017-18.S2
 */
public class MovieReviewTester {
    public static void main(String[] args) throws Exception {
        
        System.out.println("What would you like to do?");
        System.out.println("1: Get the average score of a word"
                + "\n2: Get the average score of words in a file"
                + "\n3: Find the highest/lowest scoring words in a file"
                + "\n4: Sort the words from a file into positive.txt and negative.txt"
                + "\n5: Exit the program");//output the options of the program

        File reviews = new File(".\\data\\movie.review\\MovieReviews.txt");//Initialize the moview review file and opens
        
        boolean endProgram = false;
        
        while(!endProgram){//waits until the boolean is set to true
            System.out.println("Enter a number 1-5");
            endProgram = MovieReview.selectionMenu(reviews);//calls upon the selection menu method
        }
    }


}
