/*
* Date: 2021-09-15.
* File Name: ArraysMain.Java
* Author: Oskar Lövsveden
*/

package ol222hf_assign1;

/**
 * Class Description: Main program to test/demo Arrays.java.
 * 
 * @version 1 15 Sept 2021
 * @author Oskar Lövsveden
 */
public class ArraysMain {
    public static void main(String[] args) {
        testAverage();
        testMax();
        testAddN();
        testReverse();
        testReplaceAll();
        testSort();
        testHasSubString();
        testAbsDiff();
    }

    private static void testAverage() {
        int[] arr = new int[] { 5, 4, 3, 2, 1 };
        int average = Arrays.average(arr);
        System.out.println("Average value of " + Arrays.toString(arr) + " is: " + average);
        System.out.println("\n");
    }

    private static void testMax() {
        int[] arr = new int[] { 5, 4, 3, 2, 1 };
        int max = Arrays.max(arr);
        System.out.println("Max value of " + Arrays.toString(arr) + " is: " + max);
        System.out.println("\n");
    }

    private static void testAddN() {
        int[] arr = new int[] { 5, 4, 3, 2, 1 };
        int n = 2;
        int[] addN = Arrays.addN(arr, n);
        System.out.println(
                "Adding " + n + " to each value in " + Arrays.toString(arr) + " results in: " + Arrays.toString(addN));
        System.out.println("\n");
    }

    private static void testReverse() {
        int[] arr = new int[] { 5, 4, 3, 2, 1 };
        int[] reverse = Arrays.reverse(arr);
        System.out.println("The reverse of " + Arrays.toString(arr) + " is: " + Arrays.toString(reverse));
        System.out.println("\n");
    }

    private static void testReplaceAll() {
        int[] arr = new int[] { 5, 4, 3, 2, 1 };
        int oldN = 2;
        int newN = 9;

        System.out.println(
                "Replacing all " + oldN + "'s with " + newN + "'s in " + Arrays.toString(arr) + " results in: ");
        Arrays.replaceAll(arr, oldN, newN);
        System.out.println(Arrays.toString(arr));
        System.out.println("\n");
    }

    private static void testSort() {
        int[] arr = new int[] { 5, 31, 4, -25, 7, 3, 2, 1, -5 };
        int[] sort = Arrays.sort(arr);
        System.out.println("Sorting " + Arrays.toString(arr) + " results in: " + Arrays.toString(sort));
        System.out.println("\n");
    }

    private static void testHasSubString() {
        int[] arr = new int[] { 1, 2, 3, 1, 2, 3, 4 };
        int[] sub1 = new int[] { 3, 1, 2 };
        int[] sub2 = new int[] { 1, 2, 3, 4, 5 };
        int[] sub3 = new int[] { 2, 3, 4 };
        int[] sub4 = new int[] { 3, 1, 3 };

        boolean hasSubString1 = Arrays.hasSubString(arr, sub1);
        boolean hasSubString2 = Arrays.hasSubString(arr, sub2);
        boolean hasSubString3 = Arrays.hasSubString(arr, sub3);
        boolean hasSubString4 = Arrays.hasSubString(arr, sub4);

        System.out.println(Arrays.toString(sub1) + " is a subString of " + Arrays.toString(arr) + ": " + hasSubString1);
        System.out.println(Arrays.toString(sub2) + " is a subString of " + Arrays.toString(arr) + ": " + hasSubString2);
        System.out.println(Arrays.toString(sub3) + " is a subString of " + Arrays.toString(arr) + ": " + hasSubString3);
        System.out.println(Arrays.toString(sub4) + " is a subString of " + Arrays.toString(arr) + ": " + hasSubString4);
        System.out.println("\n");
    }

    private static void testAbsDiff() {
        try {
            int[] arr1 = new int[] { 1, 2, 3, 4, 5 };
            int[] arr2 = new int[] { 1, 1, 1, 1, 1 };
            int[] arr3 = new int[] { -5, -4, 3, 2, 1 };
            int[] arr4 = new int[] { 1, 1, 1, 1, 1, 1 };

            int[] absDiff1 = Arrays.absDiff(arr1, arr2);
            System.out.println("The absDiff of " + Arrays.toString(arr1) + " and " + Arrays.toString(arr2) +
                    " is: " + Arrays.toString(absDiff1));

            int[] absDiff2 = Arrays.absDiff(arr1, arr3);
            System.out.println("The absDiff of " + Arrays.toString(arr1) + " and " + Arrays.toString(arr3) +
                    " is: " + Arrays.toString(absDiff2));

            System.out.println("The absDiff of " + Arrays.toString(arr1) + " and " + Arrays.toString(arr4) +
                    " should throw an error...");
            Arrays.absDiff(arr1, arr4);

        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
    }
}
