/*
* Date: 2021-09-07.
* File Name: Codestrip.Java
* Author: Oskar Lövsveden
*/

package ol222hf_assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class Description:
 * Reads a javafile.
 * Prints lines of codes.
 * Counts lines of code, lines of comments and blank lines and prints the sum
 * for each.
 * 
 * @version 1 07 Sept 2021
 * @author Oskar Lövsveden
 */
public class Codestrip {
    // Replace this with the java file that should be read.
    private static final String FILE_NAME = "src/App.java";

    private static final String SINGLE_LINE_COMMENT = "//";
    private static final String MULTI_LINE_COMMENT_BEGIN = "/*";
    private static final String MULTI_LINE_COMMENT_END = "*/";

    private static boolean lineIsComment = false;
    private static int linesOfCode = 0;
    private static int linesOfComments = 0;
    private static int linesOfBlanks = 0;

    /**
     * The starting point of the program.
     * Reads a javafile line for line and processes each line.
     * Ends by printing the result.
     */
    public static void run() {
        try {
            File myObj = new File(FILE_NAME);
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                processLine(line);
            }

            myReader.close();

            System.out.println("\n" + "Number of actual lines of code: " + linesOfCode);
            System.out.println("Number of blank lines removed: " + linesOfBlanks);
            System.out.println("Number of comments removed: " + linesOfComments);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Processes a line in a javafile.
     * Lines of code, comments and blank lines adds 1 to their respective counters.
     * Print lines of code.
     * 
     * @param line A String representing a line in a javafile.
     */
    private static void processLine(String line) {
        if (line.contains(SINGLE_LINE_COMMENT)) {
            linesOfComments++;
        } else if (line.contains(MULTI_LINE_COMMENT_BEGIN)) {
            lineIsComment = true;
            linesOfComments++;
        } else if (line.contains(MULTI_LINE_COMMENT_END)) {
            lineIsComment = false;
        } else if (line.trim().length() == 0) {
            linesOfBlanks++;
        } else {
            if (!lineIsComment) {
                System.out.println(line);
                linesOfCode++;
            }
        }
    }
}
