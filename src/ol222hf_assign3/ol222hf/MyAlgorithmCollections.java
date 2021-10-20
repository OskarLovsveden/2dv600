package ol222hf_assign3.ol222hf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyAlgorithmCollections<E> {
    private Set<E> visited = new HashSet<E>();
    private List<E> result = new ArrayList<E>();

    public int visitedSize() {
        return visited.size();
    }

    public int resultSize() {
        return result.size();
    }

    public void add(E element) {
        result.add(element);
    }

    public void visit(E element) {
        visited.add(element);
    }

    public boolean contains(E element) {
        return visited.contains(element);
    }

    public List<E> getResult() {
        return result;
    }
}
