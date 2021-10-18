package ol222hf_assign3.ol222hf;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ol222hf_assign3.graphs.DirectedGraph;
import ol222hf_assign3.graphs.Node;
import ol222hf_assign3.graphs.TransitiveClosure;

public class MyTransitiveClosure<E> implements TransitiveClosure<E>{
    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        MyDFS<E> dfs = new MyDFS<E>();
        Map<Node<E>, Collection<Node<E>>> transitiveClosure = new HashMap<Node<E>, Collection<Node<E>>>();

        for (Node<E> node : dg) {
            transitiveClosure.put(node, dfs.dfs(dg, node));
        }

        return transitiveClosure;
    }
}
