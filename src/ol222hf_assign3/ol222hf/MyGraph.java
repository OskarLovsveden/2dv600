/**
 * MyGraph.java
 * Date: 21 oct 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign3.ol222hf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ol222hf_assign3.graphs.DirectedGraph;
import ol222hf_assign3.graphs.Node;

public class MyGraph<E> implements DirectedGraph<E> {
    private Map<E, Node<E>> itemToNode;
    private Set<Node<E>> heads;
    private Set<Node<E>> tails;

    /** Default constructor. */
    public MyGraph() {
        itemToNode = new HashMap<E, Node<E>>();
        heads = new HashSet<Node<E>>();
        tails = new HashSet<Node<E>>();
    }

    @Override
    public Node<E> addNodeFor(E item) {
        if (item == null)
            throw new RuntimeException("Item is null.");

        if (itemToNode.containsKey(item)) {
            return getNodeFor(item);
        } else {
            Node<E> newNode = new MyNode<E>(item);
            itemToNode.put(item, newNode);
            heads.add(newNode);
            tails.add(newNode);
            return newNode;
        }
    }

    @Override
    public Node<E> getNodeFor(E item) {
        if (item == null)
            throw new RuntimeException("Item is null.");
        Node<E> node = itemToNode.get(item);
        if (node == null)
            throw new RuntimeException("Node does not exit for this item.");
        return node;
    }

    @Override
    public boolean addEdgeFor(E from, E to) {
        if (from == null || to == null)
            throw new RuntimeException("Received null as input");

        MyNode<E> source = (MyNode<E>) addNodeFor(from);
        MyNode<E> target = (MyNode<E>) addNodeFor(to);

        if (source.hasSucc(target)) {
            return false;
        } else {
            source.addSucc(target);
            target.addPred(source);
            tails.remove(source);
            heads.remove(target);
            return true;
        }
    }

    @Override
    public boolean containsNodeFor(E item) {
        if (item == null)
            throw new RuntimeException("Item is null.");
        return (itemToNode.get(item) != null);
    }

    @Override
    public int nodeCount() {
        return itemToNode.size();
    }

    @Override
    public Iterator<Node<E>> iterator() {
        return itemToNode.values().iterator();
    }

    @Override
    public Iterator<Node<E>> heads() {
        return heads.iterator();
    }

    @Override
    public int headCount() {
        return heads.size();
    }

    @Override
    public Iterator<Node<E>> tails() {
        return tails.iterator();
    }

    @Override
    public int tailCount() {
        return tails.size();
    }

    @Override
    public List<E> allItems() {
        return new ArrayList<E>(itemToNode.keySet());
    }

    @Override
    public int edgeCount() {
        int counter = 0;

        for (Node<E> node : this) {
            counter = counter + node.outDegree();
        }

        return counter;
    }

    @Override
    public void removeNodeFor(E item) {
        if (item == null)
            throw new RuntimeException("Item is null.");
        if (itemToNode.get(item) == null)
            throw new RuntimeException("Node does not exist for this item.");

        Node<E> node = getNodeFor(item);

        Iterator<Node<E>> succs = node.succsOf();
        while (succs.hasNext()) {
            MyNode<E> succNode = (MyNode<E>) succs.next();
            succNode.removePred(node);

            if (succNode.isHead())
                heads.add(succNode);
        }

        Iterator<Node<E>> preds = node.predsOf();
        while (preds.hasNext()) {
            MyNode<E> predNode = (MyNode<E>) preds.next();
            predNode.removeSucc(node);

            if (predNode.isTail())
                tails.add(predNode);
        }

        itemToNode.remove(item);
        tails.remove(node);
        heads.remove(node);
    }

    @Override
    public boolean containsEdgeFor(E from, E to) {
        if (from == null || to == null)
            throw new RuntimeException("Received null as input");

        Node<E> source = itemToNode.get(from);
        Node<E> target = itemToNode.get(to);

        if (source == null || target == null)
            return false;

        return source.hasSucc(target);
    }

    @Override
    public boolean removeEdgeFor(E from, E to) {
        if (!containsEdgeFor(from, to))
            return false;

        MyNode<E> source = (MyNode<E>) itemToNode.get(from);
        MyNode<E> target = (MyNode<E>) itemToNode.get(to);

        if (source == null || target == null)
            return false;

        source.removeSucc(target);
        target.removePred(source);
        if (source.isTail())
            tails.add(source);
        if (target.isHead())
            heads.add(target);

        return true;
    }
}
