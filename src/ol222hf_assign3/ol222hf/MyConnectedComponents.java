package ol222hf_assign3.ol222hf;

import java.util.ArrayList;
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
    private final MyDFS<E> MY_DFS = new MyDFS<E>();

    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        List<Collection<Node<E>>> cc = new ArrayList<Collection<Node<E>>>();
        List<Collection<Node<E>>> allDFS = new ArrayList<Collection<Node<E>>>();
        Set<Node<E>> visited = new HashSet<Node<E>>();
        
        for (Node<E> node : dg) {
            List<Node<E>> dfs = MY_DFS.dfs(dg, node);
            if (!visited.contains(node)) {
                visited.addAll(dfs);
                allDFS.add(dfs);
            }
        }

        while(allDFS.size() != 0) {
            Set<Node<E>> newCC = new HashSet<Node<E>>();
            Iterator<Collection<Node<E>>> dfsItr = allDFS.iterator();
            
            while (dfsItr.hasNext()) {
                Collection<Node<E>> next = dfsItr.next();

                if (newCC.isEmpty()) {
                    newCC.addAll(next);
                    dfsItr.remove();
                } else if (!Collections.disjoint(newCC, next)) {
                    newCC.addAll(next);
                    dfsItr.remove();
                }
            }

            cc.add(newCC);
        }

        return cc;
    }
}
