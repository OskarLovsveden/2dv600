package ol222hf_assign3.ol222hf;

import java.util.Iterator;

import ol222hf_assign3.graphs.*;

public class MyNode<E> extends Node<E> {

    protected MyNode(E item) {
        super(item);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean hasSucc(Node<E> node) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int outDegree() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<Node<E>> succsOf() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasPred(Node<E> node) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int inDegree() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Iterator<Node<E>> predsOf() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void addSucc(Node<E> succ) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void removeSucc(Node<E> succ) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void addPred(Node<E> pred) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void removePred(Node<E> pred) {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void disconnect() {
        // TODO Auto-generated method stub
        
    }
    
}
