/*
 *
 */
package edu.hdsb.gwss.Ahmad.ICS4U.Unit_1;

import java.io.File;
import java.io.FileWriter;
import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Movie Review Assignment
 *
 * @author Ahmad Elmasri
 * @version 2017-18.S2
 */
public class MovieReview {

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
        word = word.replaceAll(" ", "");//Words such as "you'll" are written with a space (you 'll) so we might as well take out the apostrophe and the spaces
        word = word.replaceAll("'", "");
        word = word.toUpperCase();//cleans up the word and makes sure it is the same case as the movie reviews word
        word = word.trim();
        
        Scanner fileScanner = new Scanner(reviews);//Scans the entire file
        String holder;

        int wordCount = 0;//counts the number of words
        boolean wordFound = false;

        while (fileScanner.hasNextLine()) {//skips to the next line
            holder = fileScanner.nextLine();//the string will hold the line
            holder = holder.toUpperCase();//same case as input word and removes apostrophes and spaces so users don't have to worry about contractions
            holder = holder.replaceAll(" '", "");
            StringTokenizer str = new StringTokenizer(holder, ",. !?");//seperates the words into tokens

            while (str.hasMoreTokens() && wordFound == false) {
                if (str.nextToken().equals(word)) {
                    wordCount++;
                    wordFound = true;//if the word is already found in the line, then there's no need to keep searching (no duplicates)
                }
            }
            wordFound = false;//reinitializes to false

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
        if (wordCount(word, reviews) > 0) {//makes sure the word actually exists so that we don't waste time
            Scanner fileScanner = new Scanner(reviews);//Takes in the file as a string
            String holder;
            int totalScore = 0;//Accumulates the total score

            boolean wordFound = false;

            while (fileScanner.hasNextLine()) {
                holder = fileScanner.nextLine();
                holder = holder.toUpperCase();//makes it the same case as the word
                holder = holder.replaceAll(" '", "");//removes apostrophes and spaces to make sure users don't worry about contractions
                StringTokenizer str = new StringTokenizer(holder, ",. !?");

                while (str.hasMoreTokens() && !wordFound) {
                    if (str.nextToken().equals(word)) {
                        totalScore += Character.getNumericValue(holder.charAt(0));//gets the number which is at the start of every review
                        wordFound = true;//if the word already exists in the line we don't need to keep searching (no duplicates)
                    }
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
        word = word.replaceAll(" ", "");
        word = word.replaceAll("'", "");//removes apostrophes and spaces so users don't worry about contractions
        String wordScanned = word;
        int wordCount = wordCount(wordScanned, reviews);//Takes in the total word count
        double averageScore = (double) wordTotalScore(word, reviews);//set to double as we have to divide and keep decimal places

        if (wordCount != 0) {//makes sure the word actually exists
            averageScore = averageScore / wordCount;
            
            return averageScore;
        } else {
            return -1;//if the word doesn't exist
        }

    }

    /**
     * This method returns the average movie review score of the words in the
     * file, given th specified movie review file
     */
    public static double sentenceAverage(File wordList, File reviews) throws Exception {
        Scanner scanList = new Scanner(wordList);//Takes in the file as a string
        int wordCount = 0;
        double scoreCount = 0;//double since it will be divided by the wordcount
        String wordHolder;

        while (scanList.hasNextLine()) {
            wordHolder = scanList.nextLine();//removes apostrophes from contractions and cleans up the word to match the format of the inut
            wordHolder = wordHolder.toUpperCase();
            wordHolder = wordHolder.trim();
            wordHolder = wordHolder.replaceAll("'", " '");

            if (wordCount(wordHolder, reviews) != 0) {//makes sure the word exist. If it doesn't, it is ignored
                scoreCount += wordTotalScore(wordHolder, reviews);
                wordCount += wordCount(wordHolder,reviews);
                
            }

        }
        scoreCount = scoreCount / wordCount;
        return scoreCount;

    }
    
    /**
     * This method finds the highest rated word in a file and returns it
     */
    public static double highestRating(File wordList, File reviews) throws Exception {
        Scanner scanList = new Scanner(wordList);//Takes in the file as a string
        double highestScore = -1;//sets it so that even a score of zero will be taken
        double scoreHolder;
        String wordHolder;
        String highestWord = "";

        while (scanList.hasNextLine()) {
            wordHolder = scanList.nextLine();//cleans up the format of the line to get it to match the format of the word entered
            wordHolder = wordHolder.toUpperCase();
            wordHolder = wordHolder.trim();
            wordHolder = wordHolder.replaceAll("'", " '");

            if (wordAverage(wordHolder, reviews) != -1) {//makes sure the word exists
                scoreHolder = wordAverage(wordHolder, reviews);
                if (highestScore < scoreHolder) {//if the word has a higher score, this word now becomes the highest word
                    highestScore = scoreHolder;
                    highestWord = wordHolder;
                }

            }

        }
        if (highestScore > -1) {
            System.out.println("Highest score is " + highestScore + " and the word is " + highestWord);
            return highestScore;
        }else{//if the score remained as -1, that means that there were no words in the file
            System.out.println("File is empty");
            return -1;
        }

    }

     /**
     * This method finds the lowest rated word in a file and returns it
     */
    public static double lowestRating(File wordList, File reviews) throws Exception {
        Scanner scanList = new Scanner(wordList);//Takes in the file as a string
        double lowestScore = 4.1;//sets it so that even a score of four will be taken
        double scoreHolder;
        String wordHolder;
        String lowestWord = "";

        while (scanList.hasNextLine()) {
            wordHolder = scanList.nextLine();//cleans up the format of the line to get it to match the format of the word entered
            wordHolder = wordHolder.toUpperCase();
            wordHolder = wordHolder.trim();
            wordHolder = wordHolder.replaceAll("'", " '");

            if (wordAverage(wordHolder, reviews) != -1) {
                scoreHolder = wordAverage(wordHolder, reviews);//if the word has a lowest score, this word now becomes the lowest word
                if (lowestScore > scoreHolder) {
                    lowestScore = scoreHolder;
                    lowestWord = wordHolder;
                }

            }

        }
        if (lowestScore <4.1) {
            System.out.println("Lowest score is " + lowestScore + " and the word is " + lowestWord);
            return lowestScore;
        }else{
            System.out.println("File is empty");
            return -1;
        }
        
        

    }

    /**
     * This method sorts between the positive and negative words in a file
     * and then sends them to two files, one with positive words and negative
     * ones. If the word is neutral or doesn't exist, it is ignored
     */
    public static void fileWriter(File reviews, File wordList) throws Exception {
        String wordHolder;
        String sentimentHolder;
        double averageScore;

        Scanner scanList = new Scanner(wordList);

        File positiveFile = new File(".\\data\\movie.review\\Positive.txt");//creates the new files
        File negativeFile = new File(".\\data\\movie.review\\Negative.txt");

        FileWriter negOut = new FileWriter(negativeFile);//filewriter to write to the two files
        FileWriter posOut = new FileWriter(positiveFile);

        while (scanList.hasNextLine()) {
            wordHolder = scanList.nextLine();//makes the format of the line match the format of the word given
            wordHolder = wordHolder.toUpperCase();
            wordHolder = wordHolder.trim();
            wordHolder = wordHolder.replaceAll("'", " '");

            averageScore = wordAverage(wordHolder, reviews);
            sentimentHolder = sentimentDecider(averageScore);

            if (sentimentHolder.equals(" positive")) {//if the word is positive or negative, it is sorted accordingly
                posOut.write(wordHolder + "\n");
            } else if (sentimentHolder.equals(" negative")) {
                negOut.write(wordHolder + "\n");
            }//if the word is neither/doesn't exist, it is ignored altogether

        }

        posOut.close();//closes the filewriter so the changes to the file can be saved
        negOut.close();
    }
    
    /**
     * This method takes in the value of the average score of the word
     * and decides whether the word is positive, negative, or neither
     */
    public static String sentimentDecider(double senAverage) {
        String sentiment = " does not exist";
        if (senAverage != -1) {//if the value is -1, then it doesn't exist. Otherwise it is sorted accordingly
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
    
    /**
     * This method takes in the name of the file and finds out if it exists.
     * If the file exists, it will open it, otherwise it prompts the users
     * to try again
     */
    public static File fileOpener(String fileName) {
        boolean validFile = false;
        File negTest = null;
        negTest = new File(".\\data\\movie.review\\" + fileName);//tries to see if the file exists
        if (negTest.exists()) {
            System.out.println("File found.");
            validFile = true;
        } else {
            Scanner input = new Scanner(System.in);//asks the user to try again until it finds a file within the folder that exists
            while (!validFile) {
                System.out.println("File not found, please try again");
                fileName = input.nextLine();
                negTest = new File(".\\data\\movie.review\\" + fileName);
                if (negTest.exists()) {
                    System.out.println("File found.");
                    validFile = true;
                }

            }

        }
        return negTest;
    }
    
    /**
     * This method takes in the file and checks which task the user wants to do
     */
    public static boolean selectionMenu(File reviews) throws Exception {
        String word;
        double senAverage;
        String sentiment;
        String fileName;
        int selection;
        boolean endProgram = false;

        // MOVIE REVIEW FILE
        File negTest;

        Scanner input = new Scanner(System.in);
        try {
            selection = parseInt(input.nextLine());
            switch (selection) {
                case 1:
                    // ********************************************************************
                    // PART 1: Word Review
                    System.out.println("********************************");
                    System.out.println("PART 1: Word Review - ");
                    word = input.nextLine();

                    int wordCount = MovieReview.wordCount(word, reviews);
                    double wordAverage = MovieReview.wordAverage(word, reviews);

                    System.out.println("Word Count     : " + wordCount);
                    if (wordAverage != -1) {
                        System.out.println("Word Average   : " + wordAverage);
                    } else {
                        System.out.println("Word Average   : " + "Word does not exist");
                    }
                    assert (wordCount == 13);
                    assert (wordAverage == 2.8461538461538463);
                    break;
                case 2:
                    // ********************************************************************
                    // PART 2: Sentence Review
                    System.out.println("********************************");
                    System.out.println("PART 2: Sentence Review");
                    System.out.println("Enter the name of the file you want to check: ");
                    fileName = input.nextLine().toLowerCase();

                    negTest = MovieReview.fileOpener(fileName);
                    senAverage = sentenceAverage(negTest, reviews);

                    System.out.println("The average score of the words in " + negTest.getName()
                            + " is " + senAverage + ", which is" + (sentiment = sentimentDecider(senAverage)));
                    break;
                case 3:
                    // ********************************************************************
                    // PART 3: Highest/Lowest Score
                    System.out.println("********************************");
                    System.out.println("PART 3: Highest/Lowest Word");
                    System.out.println("Enter the name of the file you want to check: ");
                    fileName = input.nextLine().toLowerCase();

                    negTest = MovieReview.fileOpener(fileName);

                    highestRating(negTest, reviews);
                    lowestRating(negTest, reviews);
                    break;
                case 4:
                    // ********************************************************************
                    // PART 4: FileWriter
                    System.out.println("Enter the name of the file you want to check: ");
                    fileName = input.nextLine().toLowerCase();

                    negTest = MovieReview.fileOpener(fileName);
                    fileWriter(reviews, negTest);
                    break;
                case 5:
                    endProgram = true;
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Out of bounds, please try again");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Invalid input, please try again");
        }

        return endProgram;
    }
}
