/**
 * GenericQueueTest.java
 * Date: 06 oct 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise4;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

/**
 * Tests for the GenericQueue class.
 * The testmethods' names explains what is tested.
 * Roughly follows this pattern: MethodName_OptionalTestDetails_ExpectedResult
 */
public class GenericQueueTest {

    // size()
    @Test
    public void Size_ShouldReturnTen() {
        GenericQueue<Integer> SUT = new GenericQueue<Integer>();
        final int itemsToBeAdded = 10;

        for (int i = 0; i < itemsToBeAdded; i++) {
            SUT.enqueue(i);
        }

        assertEquals(itemsToBeAdded, SUT.size());
    }

    @Test
    public void Size_ShouldReturnZero() {
        GenericQueue<Integer> SUT = new GenericQueue<Integer>();
        final int expected = 0;
        assertEquals(expected, SUT.size());
    }

    // isEmpty()
    @Test
    public void IsEmpty_ShouldReturnTrue() {
        GenericQueue<Integer> SUT = new GenericQueue<Integer>();
        assertTrue(SUT.isEmpty());
    }

    @Test
    public void IsEmpty_ShouldReturnFalse() {
        GenericQueue<Integer> SUT = new GenericQueue<Integer>();
        SUT.enqueue(1);
        assertFalse(SUT.isEmpty());
    }

    // enqueue()
    @Test
    public void Enqueue_SetsHead() {
        GenericQueue<Integer> SUT = new GenericQueue<Integer>();
        final Integer input = 1;
        SUT.enqueue(input);
        assertEquals(input, SUT.first());
    }

    @Test
    public void Enqueue_SetsTail() {
        GenericQueue<Integer> SUT = new GenericQueue<Integer>();
        final int input = 1;
        SUT.enqueue(input);
        assertEquals((Integer) input, SUT.last());
    }

    @Test
    public void Enqueue_OneMillionIntegers() {
        GenericQueue<Integer> SUT = new GenericQueue<Integer>();

        final int startInteger = 0;
        final int itemsToBeAdded = 1000000;
        for (int i = startInteger; i < itemsToBeAdded; i++) {
            SUT.enqueue(i);
        }

        assertEquals(itemsToBeAdded, SUT.size());
        assertEquals((Integer) startInteger, SUT.first());
        assertEquals((Integer) (itemsToBeAdded - 1), SUT.last());
    }

    // dequeue()
    @Test
    public void Dequeue_OneMillionIntegers() {
        GenericQueue<Integer> SUT = new GenericQueue<Integer>();

        final int startInteger = 0;
        final int itemsToBeAdded = 1000000;

        for (int i = startInteger; i < itemsToBeAdded; i++) {
            SUT.enqueue(i);
        }

        for (int i = startInteger; i < itemsToBeAdded; i++) {
            SUT.dequeue();
        }

        assertEquals(0, SUT.size());
    }

    @Test
    public void Dequeue_ShouldThrowNoSuchElementException() {
        GenericQueue<Integer> SUT = new GenericQueue<Integer>();

        assertThrows(NoSuchElementException.class, () -> {
            SUT.dequeue();
        });
    }

    // first()
    @Test
    public void First_ShouldThrowNoSuchElementException() {
        GenericQueue<Integer> SUT = new GenericQueue<Integer>();

        assertThrows(NoSuchElementException.class, () -> {
            SUT.first();
        });
    }

    // last()
    @Test
    public void Last_ShouldThrowNoSuchElementException() {
        GenericQueue<Integer> SUT = new GenericQueue<Integer>();

        assertThrows(NoSuchElementException.class, () -> {
            SUT.last();
        });
    }
}
