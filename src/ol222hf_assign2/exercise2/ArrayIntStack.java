/**
 * ArrayIntStack.java
 * Date: 30 sept 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign2.exercise2;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

    /**
     * Add integer at top of stack.
     * 
     * @param n the integer to be added.
     */
    @Override
    public void push(int n) {
        
        if (size() == values.length) resize();
        values[size++] = n;
    }

    /**
     * Returns and removes integer at top of stack.
     * 
     * @return the top of the stack integer.
     * @throws IndexOutOfBoundsException
     */
    @Override
    public int pop() throws IndexOutOfBoundsException {
        
        if (isEmpty()) throw new IndexOutOfBoundsException();
        
        int value = values[size() - 1];
        values[size() - 1] = 0;
        size--;

        return value;
    }

    /**
     * Returns without removing integer at top of stack.
     * 
     * @return the top of the stack integer.
     * @throws IndexOutOfBoundsException
     */
    @Override
    public int peek() throws IndexOutOfBoundsException {
        
        if (isEmpty()) throw new IndexOutOfBoundsException();
        return values[size() - 1];
    }
}
