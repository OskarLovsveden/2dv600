/*
 * Queue.java
 * Date: 01 oct 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise4;

import java.util.NoSuchElementException;

/** Interface for Queue that implements Iterable. */
public interface Queue<E> extends Iterable<E> {
    /**
     * Returns the current queue size.
     * 
     * @return an int representing the current queue size.
     */
    int size();

    /**
     * Checks whether the queue is empty or not.
     * 
     * @return true if the queue is empty, otherwise false.
     */
    boolean isEmpty();
    
    /**
     * Add element at the of queue.
     * 
     * @param element the element to be added.
     */
    void enqueue(E element);

    /**
     * Return and remove first element.
     * 
     * @return the first element.
     */
    E dequeue() throws NoSuchElementException;
    
    /**
     * Return the first element.
     * 
     * @return the first element.
     */
    E first() throws NoSuchElementException;
    
    /**
     * Return the last element.
     * 
     * @return the first element.
     */
    E last() throws NoSuchElementException;
}
