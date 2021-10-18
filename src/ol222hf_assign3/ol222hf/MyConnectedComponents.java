package ol222hf_assign3.ol222hf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ol222hf_assign3.graphs.ConnectedComponents;
import ol222hf_assign3.graphs.DirectedGraph;
import ol222hf_assign3.graphs.Node;

public class MyConnectedComponents<E> implements ConnectedComponents<E> {

    @Override
    public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
        List<Collection<Node<E>>> connectedComponents = new ArrayList<Collection<Node<E>>>();

        for (Node<E> node : dg) {
            Set<Node<E>> cc = new HashSet<Node<E>>();
            cc.add(node);
            connectedComponents.add(cc);
        }

        for (int i = 0; i < connectedComponents.size(); i++) {
            if (i+1 == connectedComponents.size()) break;

            Collection<Node<E>> first = connectedComponents.get(i);
            Collection<Node<E>> second = connectedComponents.get(i+1);

            for (Node<E> node : first) {
                
                Iterator<Node<E>> succs = node.succsOf();
                while (succs.hasNext()) {

                    Node<E> succ = succs.next();
                    
                    if(second.contains(succ)) {
                        Set<Node<E>> newCC = new HashSet<Node<E>>();
                        newCC.addAll(first);
                        newCC.addAll(second);
                        connectedComponents.remove(first);
                        connectedComponents.remove(second);
                        connectedComponents.add(newCC);
                    }
                }
            }
        }

        return connectedComponents;
    }
}
