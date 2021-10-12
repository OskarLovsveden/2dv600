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

public class MyGraph<E> implements DirectedGraph<E>{
    private Map<E, MyNode<E>> itemToNode;
    private Set<Node<E>> heads;
    private Set<Node<E>> tails;
    
    public MyGraph() {
        itemToNode = new HashMap<E, MyNode<E>>();
        heads = new HashSet<Node<E>>();
        tails = new HashSet<Node<E>>();
    }

    @Override
    public Node<E> addNodeFor(E item) {
        if (item == null) throw new RuntimeException("Item is null.");
        
        if (itemToNode.containsKey(item)) {
            return getNodeFor(item);
        } else {
            MyNode<E> newNode = new MyNode<E>(item);
            itemToNode.put(item, newNode);
            heads.add(newNode);
            tails.add(newNode);
            return newNode;
        }
    }
    
    @Override
    public Node<E> getNodeFor(E item) {
        if (item == null) throw new RuntimeException("Item is null.");
        if (itemToNode.get(item) == null) throw new RuntimeException("Node does not exit for this item.");
        return itemToNode.get(item);
    }
    
    @Override
    public boolean addEdgeFor(E from, E to) {
        if (from==null || to==null) throw new RuntimeException("Received null as input");
        
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
        if (item == null) throw new RuntimeException("Item is null.");
        return (itemToNode.get(item) != null);
    }
    
    @Override
    public int nodeCount() {
        return itemToNode.size();
    }
    
    @Override
    public Iterator<Node<E>> iterator() {
        return new HashSet<Node<E>>(itemToNode.values()).iterator();
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
        Iterator<Node<E>> iterator = iterator();
        
        while (iterator.hasNext()) {
            Node<E> node = iterator.next();
            counter = counter + node.outDegree();
        }
        
        return counter;
    }
    
    @Override
    public void removeNodeFor(E item) {
        if (item == null) throw new RuntimeException("Item is null.");
        if (itemToNode.get(item) == null) throw new RuntimeException("Node does not exist for this item.");
        
        MyNode<E> node = (MyNode<E>) getNodeFor(item);
        Iterator<Node<E>> succs = node.succsOf();

        while (succs.hasNext()) {
            MyNode<E> succNode = (MyNode<E>) succs.next();
            succNode.removePred(node);
            
            if (succNode.isTail()) tails.add(succNode);
        }

        Iterator<Node<E>> preds = node.predsOf();

        while (preds.hasNext()) {
            MyNode<E> predNode = (MyNode<E>) preds.next();
            predNode.removeSucc(node);
            
            if (predNode.isHead()) heads.add(predNode);
        }
        
        itemToNode.remove(item);
        tails.remove(node);
        heads.remove(node);
    }
    
    @Override
    public boolean containsEdgeFor(E from, E to) {
        if (from==null || to==null) throw new RuntimeException("Received null as input");
        
        MyNode<E> source = (MyNode<E>) itemToNode.get(from);
        MyNode<E> target = (MyNode<E>) itemToNode.get(to);

        if (source != null || target != null)  {
            if (source.hasPred(target) || source.hasSucc(target)) {
                return true;
            }
        }
        
        return false;
    }
    
    @Override
    public boolean removeEdgeFor(E from, E to) {
        if (containsEdgeFor(from, to)) {

            MyNode<E> source = (MyNode<E>) itemToNode.get(from);
            MyNode<E> target = (MyNode<E>) itemToNode.get(to);
            
            if (source.hasPred(target)) {
                source.removePred(target);
                target.removeSucc(source);
                if (source.isHead()) heads.add(source);
                if (target.isTail()) tails.add(target);
                return true;
            }
            
            if (source.hasSucc(target)) {
                source.removeSucc(target);
                target.removePred(source);
                if (source.isTail()) tails.add(source);
                if (target.isHead()) heads.add(target);
                return true;
            }
        }

        return false;
    }
    
}
