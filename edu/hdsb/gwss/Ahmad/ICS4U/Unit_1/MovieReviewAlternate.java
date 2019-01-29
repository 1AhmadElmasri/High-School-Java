/*
 *
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Movie Review Assignment
 *
 * @author Wm.Muir
 * @version 2017-18.S2
 */
public class MovieReviewAlternate {

    public static void main(String[] args) throws Exception {

    }

    /**
     * This method will count the number of reviews that contain the key word.
     *
     * @param word the key word the review must contain.
     * @param reviews the file that contains the movie reviews.
     * @return the number of reviews that contain the key work at least once.
     */
    public static int wordCount(String word, File reviews) throws Exception {
        word = word.toUpperCase();
        word = word.trim();
        Scanner fileScanner = new Scanner(reviews);
        String holder;

        int wordCount = 0;
        boolean wordFound = false;

        while (fileScanner.hasNextLine()) {
            holder = fileScanner.nextLine();
            holder = holder.toUpperCase();
            holder = holder.replaceAll(" '", "'");

            if (holder.contains(word)) {
                wordCount++;
                wordFound = true;
            }
            wordFound = false;

        }
        return wordCount;

    }

    /**
     * This method will accumulate the the movie review scores that contain the
     * key word.
     *
     * @param word the key word the review must contain.
     * @param reviews the file that contains the movie reviews.
     * @return the sum of the scores for reviews that contain the key work at
     * least once.
     */
    public static int wordTotalScore(String word, File reviews) throws Exception {
        if (wordCount(word, reviews) > 0) {
            Scanner fileScanner = new Scanner(reviews);
            String holder;
            int totalScore = 0;

            boolean wordFound = false;

            while (fileScanner.hasNextLine()) {
                holder = fileScanner.nextLine();
                holder = holder.toUpperCase();
                holder = holder.replaceAll(" '", "'");
                StringTokenizer str = new StringTokenizer(holder, ",. !?");

                while (str.hasMoreTokens() && wordFound == false) {
                    if (holder.contains(word)) {
                        totalScore += Character.getNumericValue(holder.charAt(0));
                        wordFound = true;
                    }
                    wordFound = false;
                        
                }
                wordFound = false;

            }
            return totalScore;
        }
        return - 1;
    }

    /**
     * Average score of reviews containing that word, given the specified file.
     *
     * @param word the key word the review must contain.
     * @param reviews reviews the file that contains the movie reviews.
     * @return the average score for the key word. Word Total Score / Word Count
     */
    public static double wordAverage(String word, File reviews) throws Exception {
        word = word.toUpperCase();
        word = word.trim();
        word = word.replaceAll(" '", "'");
        String wordScanned = word;
        int wordCount = wordCount(wordScanned, reviews);
        double averageScore = (double) wordTotalScore(word, reviews);

        if (wordCount != 0) {
            averageScore = averageScore / wordCount;
            return averageScore;
        } else {
            return -1;
        }

    }

    /**
     * This method returns the average movie review score of the words in the
     * file, given th specified movie review file.
     */
    public static double sentenceAverage(File wordList, File reviews) throws Exception {
        Scanner scanList = new Scanner(wordList);
        int wordCount = 0;
        double scoreCount = 0;
        String wordHolder;

        while (scanList.hasNextLine()) {
            wordHolder = scanList.nextLine();
            wordHolder = wordHolder.toUpperCase();
            wordHolder = wordHolder.trim();

            if (wordAverage(wordHolder, reviews) != -1) {
                scoreCount += wordAverage(wordHolder, reviews);
                wordCount++;
            }

        }
        scoreCount = scoreCount / wordCount;
        return scoreCount;

    }

    public static double highestRating(File wordList, File reviews) throws Exception {
        Scanner scanList = new Scanner(wordList);
        double highestScore = 0;
        double scoreHolder;
        String wordHolder;
        String highestWord = "";

        while (scanList.hasNextLine()) {
            wordHolder = scanList.nextLine();
            wordHolder = wordHolder.toUpperCase();

            if (wordAverage(wordHolder, reviews) != -1) {
                scoreHolder = wordAverage(wordHolder, reviews);
                if (highestScore < scoreHolder) {
                    highestScore = scoreHolder;
                    highestWord = wordHolder;
                }

            }

        }
        System.out.println("Highest score is " + highestScore + " and the word is " + highestWord);
        return highestScore;

    }

    public static double lowestRating(File wordList, File reviews) throws Exception {
        Scanner scanList = new Scanner(wordList);
        int wordCount = 0;
        double lowestScore = 4.1;
        double scoreHolder;
        String wordHolder;
        String lowestWord = "";

        while (scanList.hasNextLine()) {
            wordHolder = scanList.nextLine();
            wordHolder = wordHolder.toUpperCase();

            if (wordAverage(wordHolder, reviews) != -1) {
                scoreHolder = wordAverage(wordHolder, reviews);
                if (lowestScore > scoreHolder) {
                    lowestScore = scoreHolder;
                    lowestWord = wordHolder;
                }

            }

        }
        System.out.println("Lowest score is " + lowestScore + " and the word is " + lowestWord);
        return lowestScore;

    }

    public static void fileWriter(File reviews, File wordList) throws Exception {
        String wordHolder;
        String sentimentHolder;
        double averageScore;

        Scanner scanList = new Scanner(wordList);

        File positiveFile = new File(".\\data\\movie.review\\Positive.txt");
        File negativeFile = new File(".\\data\\movie.review\\Negative.txt");

        FileWriter negOut = new FileWriter(negativeFile);
        FileWriter posOut = new FileWriter(positiveFile);

        while (scanList.hasNextLine()) {
            wordHolder = scanList.nextLine();
            averageScore = wordAverage(wordHolder, reviews);
            sentimentHolder = sentimentDecider(averageScore);

            if (sentimentHolder.equals(" positive")) {
                posOut.write(wordHolder + "\n");
            } else if (sentimentHolder.equals(" negative")) {
                negOut.write(wordHolder + "\n");
            }

        }

        posOut.close();
        negOut.close();
    }

    public static String sentimentDecider(double senAverage) {
        String sentiment = " does not exist";
        if (senAverage != -1) {
            if (senAverage <= 1.99) {
                sentiment = " negative";
            } else if (senAverage >= 2.01) {
                sentiment = " positive";
            } else {
                sentiment = " neutral";
            }

        }
        return sentiment;
    }

    public static File fileOpener(String fileName) {
        boolean validFile = false;
        File negTest = null;
        while (!validFile) {
            try {
                negTest = new File(".\\data\\movie.review\\" + fileName);
                System.out.println("File found.");
                validFile = true;
            } catch (Exception e) {
                System.out.println("File not found, please try again");
            }

        }

        return negTest;
    }

}
