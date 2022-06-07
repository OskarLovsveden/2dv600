/**
 * IdentifyWordsMain.java
 * Date: 06 oct 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class IdentifyWordsMain {
    /**
     * Reads a file line by line.
     * Processes each line to make sure it only contains valid characters.
     * Writes each line to a new file.
     * 
     * @param args
     */
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new File("HistoryOfProgramming.txt"));
            PrintStream writer = new PrintStream(new File("words.txt"));

            while (reader.hasNext()) {
                writer.println(processLine(reader.nextLine()));
            }

            reader.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred when trying to access a file.");
            e.printStackTrace();
        }
    }

    /**
     * Process a string (a line of text).
     * Removes digits, commas, brackets and all characters other than letters.
     * 
     * @param line the string to be processed.
     * @return the processed string.
     */
    private static String processLine(String line) {
        // replace all apostrophes with nothing.
        line = line.replaceAll("'", "");
        // replace all words containing a combination of alphanumerical characters and
        // digits...
        // ...as well as all non-alphanumerical characters with a whitespace.
        line = line.replaceAll("\\w*\\d\\w*|\\W", " ");
        // replace all whitespace with a single whitespace.
        line = line.replaceAll("[ ]+", " ");

        return line;
    }
}
