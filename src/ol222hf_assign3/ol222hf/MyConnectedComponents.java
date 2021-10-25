/**
 * MyConnectedComponents.java
 * Date: 21 oct 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign3.ol222hf;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ol222hf_assign3.graphs.ConnectedComponents;
import ol222hf_assign3.graphs.DirectedGraph;
import ol222hf_assign3.graphs.Node;

public class MyConnectedComponents<E> implements ConnectedComponents<E> {
    private MyDFS<E> myDFS = new MyDFS<E>();

    /**
     * Computes the connected components for a directed graph.
     * 
     * @param dg a directed graph.
     */
    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {

        Collection<Collection<Node<E>>> connectedComponents = new HashSet<Collection<Node<E>>>();
        Set<Node<E>> visited = new HashSet<Node<E>>();

        for (Node<E> node : dg) {

            if (!visited.contains(node)) {

                List<Node<E>> dfsList = myDFS.dfs(dg, node);
                visited.addAll(dfsList);
                Set<Node<E>> newCC = new HashSet<Node<E>>(dfsList);

                Iterator<Collection<Node<E>>> collections = connectedComponents.iterator();
                while (collections.hasNext()) {

                    Collection<Node<E>> collection = collections.next();

                    if (!Collections.disjoint(collection, newCC)) {
                        newCC.addAll(collection);
                        collections.remove();
                    }
                }

                connectedComponents.add(newCC);
            }
        }

        return connectedComponents;
    }
}
