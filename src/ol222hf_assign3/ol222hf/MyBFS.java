package ol222hf_assign3.ol222hf;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import ol222hf_assign3.graphs.BFS;
import ol222hf_assign3.graphs.DirectedGraph;
import ol222hf_assign3.graphs.Node;

public class MyBFS<E> implements BFS<E>{

    private void innerBFS(List<Node<E>> visited, Set<Node<E>> parentSet) {
        Set<Node<E>> childSet = new HashSet<Node<E>>();
        for (Node<E> node : parentSet) {
            
            Iterator<Node<E>> succs = node.succsOf();
            while(succs.hasNext()) {

                Node<E> succ = succs.next();

                if (!visited.contains(succ)) {
                    visited.add(succ);
                    succ.num = visited.size();
                    childSet.add(succ);
                }
            }
        }
        
        if (!childSet.isEmpty()) {
            innerBFS(visited, childSet);
        }
    }

    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
        List<Node<E>> visited = new ArrayList<Node<E>>();
        Set<Node<E>> parentSet = new HashSet<Node<E>>();
        
        visited.add(root);
        root.num = visited.size();
        
        parentSet.add(root);
        
        innerBFS(visited, parentSet);
        return visited;
    }
    
    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        List<Node<E>> visited = new ArrayList<Node<E>>();
        Set<Node<E>> parentSet = new HashSet<Node<E>>();

        Iterator<Node<E>> heads = graph.heads();
        while (heads.hasNext()) {
            Node<E> head = heads.next();
            visited.add(head);
            head.num = visited.size();
            parentSet.add(head);
        }

        innerBFS(visited, parentSet);
        return visited;
    }
}
