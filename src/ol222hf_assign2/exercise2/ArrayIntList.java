/**
 * ArrayIntList.java
 * Date: 30 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise2;

import java.util.Iterator;

public class ArrayIntList extends AbstractIntCollection implements IntList {

    /**
     * Add integer n to the end of the list.
     * 
     * @param n an int containing the value to be added.
     */
    @Override
    public void add(int n) {

        if (size() == values.length)
            resize();
        values[size++] = n;
    }

    /**
     * Inserts integer n at position index. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right.
     * 
     * @param n     the int to be added.
     * @param index an int representing the index at which to add at.
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException {

        if (!checkIndex(index, size()))
            throw new IndexOutOfBoundsException();
        if (size() == values.length)
            resize();

        int temp = 0;
        Iterator<Integer> iterator = iterator();
        int i = 0;

        while (iterator.hasNext()) {
            int current = iterator.next();

            if (i == index) {
                values[i] = n;
                size++;
            } else if (i > index) {
                values[i] = temp;
            }

            temp = current;
            i++;
        }

        // Alternative solution with temporary array.
        /*
         * int[] tempArr = new int[values.length];
         * Iterator<Integer> iterator = iterator();
         * int i = 0;
         * 
         * while (iterator.hasNext()) {
         * if (i == index) {
         * tempArr[i++] = n;
         * size++;
         * } else {
         * tempArr[i++] = iterator.next();
         * }
         * }
         * 
         * values = tempArr;
         */
    }

    /**
     * Remove integer at position index.
     * 
     * @param index an int, the index to remove at.
     * @throws IndexOutOfBoundsException
     */
    @Override
    public void remove(int index) throws IndexOutOfBoundsException {

        if (!checkIndex(index, size()))
            throw new IndexOutOfBoundsException();

        int[] tempArr = new int[values.length];
        Iterator<Integer> iterator = iterator();
        int i = 0;
        int j = 0;

        while (iterator.hasNext()) {
            if (i++ == index) {
                iterator.next();
            } else {
                tempArr[j++] = iterator.next();
            }
        }

        values = tempArr;
        size--;
    }

    /**
     * Get integer at position index.
     * 
     * @param index an int, the position to get at.
     * @return the integer at the given index.
     * @throws IndexOutOfBoundsException
     */
    @Override
    public int get(int index) throws IndexOutOfBoundsException {

        if (!checkIndex(index, size()))
            throw new IndexOutOfBoundsException();

        Iterator<Integer> iterator = iterator();
        int i = 0;

        while (iterator.hasNext()) {
            if (i++ == index) {
                break;
            } else {
                iterator.next();
            }
        }

        return iterator.next();

        // Alternative Solution
        // return values[index];
    }

    /**
     * Find position of integer n, otherwise return -1.
     * 
     * @param n an integer to find the index of.
     * @return the index of the given integer.
     */
    @Override
    public int indexOf(int n) {

        Iterator<Integer> iterator = iterator();
        int i = 0;

        while (iterator.hasNext()) {
            if (iterator.next() == n)
                return i;
            i++;
        }

        return -1;
    }
}
