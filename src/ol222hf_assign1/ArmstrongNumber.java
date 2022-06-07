/*
* Date: 2021-09-02.
* File Name: ArmstrongNumber.Java
* Author: Oskar Lövsveden
*/

package ol222hf_assign1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

/**
 * Class Description: Read two integers and calculate all Armstrong Numbers
 * between them.
 * 
 * @version 1 02 Sept 2021
 * @author Oskar Lövsveden
 */
public class ArmstrongNumber {
    private static int startNumber;
    private static int endNumber;

    /**
     * The starting point of the application.
     * Repeats as long as user wants to do so.
     */
    public static void run() {
        Scanner in = new Scanner(System.in);

        do {
            promptStartAndEndNumbers(in);
            List<Integer> armstrongNumbers = getArmstrongNumbers();
            presentArmstrongNumbers(armstrongNumbers);

        } while (repeatProgram(in));

        in.close();
    }

    /**
     * Prompts the user for a starting and ending number to set the range.
     * 
     * @param in A Scanner
     */
    private static void promptStartAndEndNumbers(Scanner in) {
        System.out.print("Enter the starting number of the range: ");
        startNumber = in.nextInt();

        System.out.print("Enter the ending number of the range: ");
        endNumber = in.nextInt();
    }

    /**
     * Iterates each number between the starting and ending number.
     * Valid Armstrong Numbers are added to a list of integers.
     * 
     * @return A List<Integer> containing valid Armstrong Numbers.
     */
    private static List<Integer> getArmstrongNumbers() {
        List<Integer> armstrongNumbers = new ArrayList<Integer>();

        for (int i = startNumber; i <= endNumber; i++) {
            int temp = i;
            int digit;
            int sum = 0;

            while (temp > 0) {
                // iterate each digit in the number
                digit = temp % 10;
                temp = temp / 10;

                // add digit raised to the length of the number to the sum
                sum += Math.pow(digit, String.valueOf(i).length());
            }

            if (sum == i) {
                armstrongNumbers.add(i);
            }
        }

        return armstrongNumbers;
    }

    /**
     * Presents the Armstrong Numbers in the console.
     * 
     * @param armstrongNumbers A List<Integer> containing valid Armstrong Numbers.
     */
    private static void presentArmstrongNumbers(List<Integer> armstrongNumbers) {
        System.out.println("The Armstrong numbers between the given range are:");

        for (Integer n : armstrongNumbers) {
            System.out.println(n);
        }
    }

    /**
     * Prompts the user for confirmation on repeating the program.
     * 
     * @param in A Scanner
     * @return true if the user enters a Y or y, othwerwise false
     */
    private static boolean repeatProgram(Scanner in) {
        System.out.print("Do you want to repeat? (Y/N): ");
        String answer = in.next().trim();

        return answer.equalsIgnoreCase("Y");
    }
}
