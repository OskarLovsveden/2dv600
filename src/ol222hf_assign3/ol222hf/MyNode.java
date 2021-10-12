package ol222hf_assign3.ol222hf;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ol222hf_assign3.graphs.*;

public class MyNode<E> extends Node<E> {
    private Set<Node<E>> preds;
    private Set<Node<E>> succs;

    protected MyNode(E item) {
        super(item);
        preds = new HashSet<Node<E>>();
        succs = new HashSet<Node<E>>();
    }

    @Override
    public boolean hasSucc(Node<E> node) {
        return succs.contains(node);
    }

    @Override
    public int outDegree() {
        return succs.size();
    }

    @Override
    public Iterator<Node<E>> succsOf() {
        return succs.iterator();
    }

    @Override
    public boolean hasPred(Node<E> node) {
        return preds.contains(node);
    }

    @Override
    public int inDegree() {
        return preds.size();
    }

    @Override
    public Iterator<Node<E>> predsOf() {
        return preds.iterator();
    }

    @Override
    protected void addSucc(Node<E> succ) {
        succs.add(succ);
    }

    @Override
    protected void removeSucc(Node<E> succ) {
        succs.remove(succ);
    }

    @Override
    protected void addPred(Node<E> pred) {
        preds.add(pred);
    }

    @Override
    protected void removePred(Node<E> pred) {
        preds.remove(pred);
    }

    @Override
    protected void disconnect() {
        succs = new HashSet<Node<E>>();
        preds = new HashSet<Node<E>>();
    }
}
