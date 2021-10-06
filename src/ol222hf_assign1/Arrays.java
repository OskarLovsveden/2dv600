/*
* Date: 2021-09-15.
* File Name: Arrays.Java
* Author: Oskar Lövsveden
*/

package ol222hf_assign1;

/**
 * Class Description: Utility methods for arrays containing integers.
 * 
 * @version 1 15 Sept 2021
 * @author Oskar Lövsveden
 */
public class Arrays {

    /**
     * Finds the average value in an array of numbers.
     * 
     * @param arr An array of integers.
     * @return An int containing the average value.
     */
    public static int average(int[] arr) {
        int sum = 0;
        
        for (int i : arr) {
            sum += i;
        }

        return sum / arr.length;
    }

    /**
     * Finds the max value of an array of numbers.
     * 
     * @param arr An array of integers.
     * @return An int containing the max value.
     */
    public static int max(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            
            if (i > max) max = i;
        }

        return max;
    }

    /**
     * Adds the value n to all numbers in an array.
     * 
     * @param arr An array of integers.
     * @param n An int to add to each number.
     * @return An array of integers representing arr modified.
     */
    public static int[] addN(int[] arr, int n) {
        int[] result = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] + n;
        }
        
        return result;
    }
    
    /**
     * Reverses the order of an array of numbers.
     * 
     * @param arr An array of integers.
     * @return An array of integers representing arr reversed.
     */
    public static int[] reverse(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - (i + 1)];
        }

        return result;
    }

    /**
     * Replaces all occurences of a number with a new number in an array of numbers.
     * 
     * @param arr An array of integers.
     * @param oldN An integer representing the number to be replaced.
     * @param newN An integer representing the number to replace oldN with.
     */
    public static void replaceAll(int[] arr, int oldN, int newN) {
        for (int i = 0; i < arr.length; i++) {
            
            if (arr[i] == oldN) arr[i] = newN;
        }
    }

    /**
     * Sorts an array of numbers ascending.
     * 
     * @param arr An array of integers.
     * @return An array of integers representing arr sorted.
     */
    public static int[] sort(int[] arr) {
        int[] clone = arr.clone();

        for (int i = 0; i < clone.length; i++) {
            
            for (int j = i + 1; j < clone.length; j++) {
                int temp = 0;

                if (clone[i] > clone[j]) {
                    temp = clone[i];
                    clone[i] = clone[j];
                    clone[j] = temp;
                }
            }
        }

        return clone;
    }

    /**
     * Checks if an array of numbers is part of another array of numbers.
     * 
     * @param arr An array of integers.
     * @param sub An array of integers to check if it is a sub part of arr.
     * @return true if sub is part off arr, otherwise false.
     */
    public static boolean hasSubString(int[] arr, int[] sub) {
        boolean match = false;

        for (int i = 0; i < arr.length; i++) {

            if (arr.length - i < sub.length) return match;

            if(sub[0] == arr[i]) {

                for (int j = 0; j < sub.length; j++) {
                    
                    if (sub[j] != arr[i + j]) {
                        match = false;
                        break;
                    } else {
                        match = true;
                    }
                }
            }
        }
        
        return match;
    }

    /**
     * Calculates the absolute difference between two arrays of numbers.
     * 
     * @param arr1 An array of integers.
     * @param arr2 An array of integers.
     * @return An array of integers containing the absolute difference numbers for matching indexes.
     * @throws IllegalArgumentException if arr1 and arr2 is not of equal length.
     */
    public static int[] absDiff(int[] arr1, int[] arr2) throws IllegalArgumentException {

        if (arr1.length != arr2.length){
            String msg = "arr1 and arr2 must be of equal length." +
                " arr1 contains " + arr1.length + " items and" + 
                " arr2 contains " + arr2.length + " items.";
            throw new IllegalArgumentException(msg);
        }

        int[] result = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            int difference = arr1[i] - arr2[i];
            result[i] = difference < 0 ? -difference : difference;
        }
        
        return result;
    }

    /**
     * toString method that creates a String representation of an array.
     * 
     * @param arr An array of integers.
     * @return A String representing arr.
     */
    public static String toString(int[] arr) {
        if (arr == null || arr.length <= 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);

            if (i + 1 != arr.length) {
                sb.append(", ");
            }
        }
        
        sb.append(" ]");
        return sb.toString();
    }
}
