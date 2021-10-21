/**
 * MyTransitiveClosure.java
 * Date: 21 oct 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign3.ol222hf;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ol222hf_assign3.graphs.DirectedGraph;
import ol222hf_assign3.graphs.Node;
import ol222hf_assign3.graphs.TransitiveClosure;

public class MyTransitiveClosure<E> implements TransitiveClosure<E> {
    private MyDFS<E> myDFS = new MyDFS<E>();

    @Override
    public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
        Map<Node<E>, Collection<Node<E>>> transitiveClosure = new HashMap<Node<E>, Collection<Node<E>>>();

        for (Node<E> node : dg) {
            List<Node<E>> reachability = myDFS.dfs(dg, node);
            transitiveClosure.put(node, reachability);
        }

        return transitiveClosure;
    }
}
