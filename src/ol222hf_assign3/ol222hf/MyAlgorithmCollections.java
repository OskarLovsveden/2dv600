/**
 * MyAlgorithmCollections.java
 * Date: 21 oct 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign3.ol222hf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Helper for algorithms that manages a set of visited elements and a list of
 * elements in the result.
 */
public class MyAlgorithmCollections<E> {
    private Set<E> visited = new HashSet<E>();
    private List<E> result = new ArrayList<E>();

    /**
     * Returns the amount of elements that have been visited.
     * 
     * @return an int containing the amount of visited elements.
     */
    public int visitedSize() {
        return visited.size();
    }

    /**
     * Returns the amount of elements that have been added to the result.
     * 
     * @return an int containing the amount of elements in the result.
     */
    public int resultSize() {
        return result.size();
    }

    /**
     * Adds the spcified element to the result list.
     * 
     * @param element element to be added.
     */
    public void add(E element) {
        result.add(element);
    }

    /**
     * "Visits" a specified element by adding it to a set of visited elements.
     * 
     * @param element element to be added.
     */
    public void visit(E element) {
        visited.add(element);
    }

    /**
     * Checks whether a specified element has been visited.
     * 
     * @param element the elemnt to be checked.
     * @return true if an element has been visited, otherwise false.
     */
    public boolean contains(E element) {
        return visited.contains(element);
    }

    /**
     * Returns the result list.
     * 
     * @return A list of elements.
     */
    public List<E> getResult() {
        return result;
    }
}
