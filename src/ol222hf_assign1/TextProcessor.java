/*
* Date: 2021-09-03.
* File Name: TextProcessor.Java
* Author: Oskar Lövsveden
*/

package ol222hf_assign1;

import java.util.Scanner;

/**
 * Class Description: Reads a line of text from the keyboard and then prints the
 * text with the following rules:
 * 1. Replaces every alphabetical letter with the next one in the alphabet.
 * 2. Capitalizes every vowel.
 * 3. Non-alphabetical letters/characters are unchanged.
 * 
 * @version 1 03 Sept 2021
 * @author Oskar Lövsveden
 */
public class TextProcessor {
    private static final int ASCII_DECREASE = 25;
    private static final int SMALL_Z = 122;
    private static final int BIG_Z = 90;

    /** The starting point of the application */
    public static void run() {
        String text = promptText();
        String output = processText(text);

        System.out.println("After Processing: " + output);
    }

    /**
     * Prompts the user for a text.
     * 
     * @return A string representing the user input text.
     */
    private static String promptText() {
        System.out.print("Type a line of text: ");

        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        in.close();

        return text;
    }

    /**
     * Process the user input text.
     * Alphabetical letters are processed, anything else is left as is.
     * 
     * @param text A string representing the user input.
     * @return A String representing the processed text.
     */
    private static String processText(String text) {
        String output = "";

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            int charValue = (int) character;

            output += Character.isAlphabetic(character) ? processLetter(charValue) : character;
        }

        return output;
    }

    /**
     * Processes a letter with the following rules:
     * 
     * 1. Replaces letter with the next one in the alphabet.
     * 2. Capitalizes vowel.
     * 
     * @param charValue An int representing the character to process.
     * @return A char representing the processed letter.
     */
    private static char processLetter(int charValue) {
        // Turn a/A to z/Z, or turn the character to next in alphabet.
        char character = isZ(charValue) ? (char) (charValue - ASCII_DECREASE) : (char) (charValue + 1);

        if (isLowerCaseVowel(character)) {
            character = Character.toUpperCase(character);
        }

        return character;
    }

    /**
     * Checks if a letter is z or Z.
     * 
     * @param charValue An int representing the ASCII value of a char.
     * @return true if the letter is z or Z, otherwise return false.
     */
    private static boolean isZ(int charValue) {
        return charValue == SMALL_Z || charValue == BIG_Z;
    }

    /**
     * Checks if a letter is a lowercase vowel.
     * 
     * @param letter A char representing a letter.
     * @return true if the letter is a lowercase a, e, i, o or u. Otherwise return
     *         false.
     */
    private static boolean isLowerCaseVowel(char letter) {
        switch (letter) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}
