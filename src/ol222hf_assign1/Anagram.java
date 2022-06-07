/*
* Date: 2021-09-07.
* File Name: Anagram.Java
* Author: Oskar Lövsveden
*/

package ol222hf_assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class Description: Reads a word from the keyboard.
 * Then prints all anagrams of that word contained in a wordlist file.
 * 
 * @version 1 07 Sept 2021
 * @author Oskar Lövsveden
 */
public class Anagram {
    // Replace this with the wordlist file that should be read.
    private static final String FILE_NAME = "wordlist";

    /** The starting point of the program */
    public static void run() {
        try {
            String input = promptInput();
            searchForAnagrams(input);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred when reading the file.");
            e.printStackTrace();
        }
    }

    /**
     * Prompts the user for a word to look for in the list of words.
     * 
     * @return A String representing the user input.
     */
    private static String promptInput() {
        System.out.print("Find anagram for word: ");
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();

        return input;
    }

    /**
     * Searches for anagrams of a word in a wordlist file.
     * 
     * @param input A String representing the word to use as reference for potential
     *              anagrams.
     * @throws FileNotFoundException if a file does not exist.
     */
    private static void searchForAnagrams(String input) throws FileNotFoundException {
        try {
            File wordlist = new File(FILE_NAME);
            Scanner reader = new Scanner(wordlist);

            System.out.println("Anagrams found:");

            while (reader.hasNextLine()) {
                String word = reader.nextLine();

                if (isAnagram(word, input)) {
                    System.out.println(word);
                }
            }

            reader.close();
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    /**
     * Checks if two words are anagrams of each other.
     * 
     * @param firstWord  A String containing a word.
     * @param secondWord A String containing a word.
     * @return true if the two parameters are anagrams, otherwise false.
     */
    private static boolean isAnagram(String firstWord, String secondWord) {
        if (!(firstWord.length() == secondWord.length())) {
            return false;
        }

        char[] firstWordCharArray = firstWord.toCharArray();
        char[] secondWordCharArray = secondWord.toCharArray();

        Arrays.sort(firstWordCharArray);
        Arrays.sort(secondWordCharArray);

        return Arrays.equals(firstWordCharArray, secondWordCharArray);
    }
}
