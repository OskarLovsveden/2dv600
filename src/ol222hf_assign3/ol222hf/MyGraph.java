package ol222hf_assign3.ol222hf;

import java.util.Iterator;
import java.util.List;

import ol222hf_assign3.graphs.DirectedGraph;
import ol222hf_assign3.graphs.Node;

public class MyGraph<E> implements DirectedGraph<E>{
    
    public MyGraph() {
        super();
    }

    @Override
    public Node<E> addNodeFor(E item) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Node<E> getNodeFor(E item) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean addEdgeFor(E from, E to) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean containsNodeFor(E item) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int nodeCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<Node<E>> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Iterator<Node<E>> heads() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int headCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<Node<E>> tails() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int tailCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<E> allItems() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int edgeCount() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void removeNodeFor(E item) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean containsEdgeFor(E from, E to) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeEdgeFor(E from, E to) {
        // TODO Auto-generated method stub
        return false;
    }
    
}
