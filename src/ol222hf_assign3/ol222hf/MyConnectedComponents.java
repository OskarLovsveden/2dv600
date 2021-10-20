package ol222hf_assign3.ol222hf;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ol222hf_assign3.graphs.ConnectedComponents;
import ol222hf_assign3.graphs.DirectedGraph;
import ol222hf_assign3.graphs.Node;

public class MyConnectedComponents<E> implements ConnectedComponents<E> {
    private final MyDFS<E> MY_DFS = new MyDFS<E>();

    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {

        Collection<Collection<Node<E>>> connectedComponents = new HashSet<Collection<Node<E>>>();
        Collection<Collection<Node<E>>> removeList = new HashSet<Collection<Node<E>>>();
        Set<Node<E>> visited = new HashSet<Node<E>>();

        for (Node<E> node : dg) {
            
            if (!visited.contains(node)) {
                List<Node<E>> dfsList = MY_DFS.dfs(dg, node);
                visited.addAll(dfsList);
                Set<Node<E>> newCC = new HashSet<Node<E>>(dfsList);

                for (Collection<Node<E>> collection : connectedComponents) {
                    if (!Collections.disjoint(collection, newCC)) {
                        newCC.addAll(collection);
                        removeList.add(collection);                       
                    }
                }

                connectedComponents.add(newCC);  
            }
        }

        for (Collection<Node<E>> toBeRemoved : removeList) {
            connectedComponents.remove(toBeRemoved);
        }

        return connectedComponents;
    }
}
