/*
 * GenericQueue.java
 * Date: 01 oct 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise4;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** GenericQueue that implements Queue. */
public class GenericQueue<E> implements Queue<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    
    /** Node class that represents a node in the queue. */
    private static class Node<E> {
        /** The item stored in the Node. */
        E item;
        /** The Node that is queued up after this Node. */
        Node<E> next;

        /**
         * Node constructor. Takes an argument containing the item to be stored.
         * @param item The item to be stored.
         */
        Node (E item){
            this.item = item;
            next = null;
        }
    }

    /** {@inheritDoc} */
    @Override
    public int size() {
        return size;
    }
    
    /** {@inheritDoc} */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** {@inheritDoc} */
    @Override
    public void enqueue(E element) {
        Node<E> newNode = new Node<E>(element);
        
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        
        tail = newNode;
        size++;
    }
    
    /** {@inheritDoc} */
    @Override
    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException("Can not dequeue on an empty queue.");

        if (head.equals(tail)) {
            tail = null;
        }
        
        E element = head.item;
        head = head.next;
        size--;
        return element;
    }
    
    /** {@inheritDoc} */
    @Override
    public E first() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException("The queue is empty.");

        return head.item;
    }
    
    /** {@inheritDoc} */
    @Override
    public E last() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException("The queue is empty.");

        return tail.item;
    }
    
    /** {@inheritDoc} */
    @Override
    public Iterator<E> iterator() {
        return new GenericIterator();
    }
    
    /** GenericIterator implements Iterator. */
    private class GenericIterator implements Iterator<E> {
        /** The current Node in the iterator. */
        Node<E> current;
        
        /** GenericIterator constructor. Sets head as current. */
        GenericIterator() {
            current = head;
        }
        
		public E next() throws NoSuchElementException {
            if (hasNext()) {
                E next = current.item;
                current = current.next;
                return next;
            } else {
                throw new NoSuchElementException();
            }
        }
		
		public boolean hasNext() {
            return current != null;
        }
	}
}
