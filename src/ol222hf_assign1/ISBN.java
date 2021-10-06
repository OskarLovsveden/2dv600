/*
* Date: 2021-09-01.
* File Name: ISBN.Java
* Author: Oskar Lövsveden
*/

package ol222hf_assign1;
import java.util.Scanner;

/**
 * Class Description: Read and calculate an ISBN number using the first 9 digits.
 * 
 * @version 1 01 Sept 2021
 * @author Oskar Lövsveden
 */
public class ISBN {
    private static final int INPUT_LENGTH = 9;
    private static final int CHECKSUM = 10;
    private static final int MODULUS_CHECK = 11;

    /**
     * The starting point of the program.
     */
    public static void run() {
        int input = promptStartingDigits();
        int nineDigitSum = getNineDigitSum(input);
        String tenthDigit = getTenthDigit(nineDigitSum);

        System.out.println("The ISBN-10 number is: " + inputToString(input) + tenthDigit);
    }

    /**
     * Prompts the user for the first 9 digits of the ISBN.
     * 
     * @return An int representing the user input.
     */
    private static int promptStartingDigits() {
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");

        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        in.close();

        return input;
    }

    /**
     * Calculate the sum for the first 9 digits of an ISBN.
     * 
     * @param input An int representing the first 9 digits of an ISBN.
     * @return An int representing the sum of the first 9 digits of an ISBN.
     */
    private static int getNineDigitSum(int input) {
        String inputAsString = String.valueOf(input);
        int inputMaxIndex = inputAsString.length() - 1;

        int sum = 0;

        for (int i = 0; i <= inputMaxIndex; i++) {
            char currentChar = inputAsString.charAt(inputMaxIndex - i);
            int currentDigit = Character.getNumericValue(currentChar);
            sum += currentDigit * (INPUT_LENGTH - i);
        }

        return sum;
    }
    
    /**
     * Takes an int and formats it to a string with 9 characters.
     * If the int is < 9 digits long, it pads it with zeros on the left up to nine characters.
     * If the int is 9 digits long, it is left as is.
     * Do not use ints with 9 > digits.
     * 
     * @param input An int representing the starting digits of an ISBN.
     * @return A String containing the nine starting digits of an ISBN.
     */
    private static String inputToString(int input) {
        return String.format("%09d", input);
    }
    
    /**
     * Calculates the checksum of the first 9 digits of an ISBN.
     * 
     * @param sum A int representing the calculated sum of the first 9 digits of an ISBN.
     * @return A string. If checksum == 10 it returns "X", else it returns the checksum as a string.
     */
    private static String getTenthDigit(int sum) {
        int d10 = sum % MODULUS_CHECK;
        return d10 == CHECKSUM ? "X" : String.valueOf(d10);
    }
}
