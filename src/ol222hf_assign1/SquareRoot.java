/*
* Date: 2021-09-02.
* File Name: SquareRoot.Java
* Author: Oskar Lövsveden
*/

package ol222hf_assign1;

import java.util.Scanner;

/**
 * Class Description: Computes the square root of a positive number.
 * 
 * @version 1 02 Sept 2021
 * @author Oskar Lövsveden
 */
public class SquareRoot {

    /** The starting point of the application */
    public static void run() {
        int number = promptNumber();
        double finalGuess = doGuess(number);

        System.out.println("The estimated square root of " + number + " is: " + String.format("%.2f", finalGuess));
    }

    /**
     * Prompts the user for a positive number to calculate the squareroot of.
     * 
     * @return An int representing the user input.
     */
    private static int promptNumber() {
        Scanner in = new Scanner(System.in);

        System.out.println("This program estimate square roots.");
        System.out.print("Enter an integer to estimate the square root of: ");
        int number = in.nextInt();
        in.close();

        return number;
    }

    /**
     * Make a guess until the guess is within 1% of the previous guess.
     * 
     * @param number An int representing the number to make guesses on.
     * @return A double containing the final guess.
     */
    private static double doGuess(int number) {
        // Initial guess
        double guess = number / 2d;
        double prevGuess;

        do {
            prevGuess = guess;
            guess = babylonianAlgorithm(number, guess);
            System.out.println("Current guess: " + guess);

        } while (percentageInvalid(prevGuess, guess));

        return guess;
    }

    /**
     * The babylonian algorithm computes the initial number and the current guess to
     * make a new guess.
     * 
     * @param number An int representing the inital number.
     * @param guess  A double representing the most recent guess.
     * @return A double representing the new guess.
     */
    private static double babylonianAlgorithm(int number, double guess) {
        double r = number / guess;
        return (guess + r) / 2d;
    }

    /**
     * Calculates the percentage difference between the previous and current guess.
     * 
     * @param prevGuess A double representing the previous guess.
     * @param guess     A double representing the current guess.
     * @return A double representing the percentage difference between guesses.
     */
    private static double percentageDifference(double prevGuess, double guess) {
        double decrease = prevGuess - guess;
        double percentage = (decrease / prevGuess) * 100;

        return percentage;
    }

    /**
     * Checks if the percentage difference is invalid.
     * 
     * @param prevGuess A double representing the previous guess.
     * @param guess     A double representing the current guess.
     * @return true if difference is less than -1 or higher than 1, otherwise false.
     */
    private static boolean percentageInvalid(double prevGuess, double guess) {
        double diff = percentageDifference(prevGuess, guess);
        return (diff < -1 || diff > 1);
    }
}
