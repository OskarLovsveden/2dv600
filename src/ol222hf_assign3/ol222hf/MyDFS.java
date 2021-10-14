package ol222hf_assign3.ol222hf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ol222hf_assign3.graphs.DFS;
import ol222hf_assign3.graphs.DirectedGraph;
import ol222hf_assign3.graphs.Node;

public class MyDFS<E> implements DFS<E> {

    private void innerDFS (List<Node<E>> visited, Node<E> node) {
        // mark n as visited
        visited.add(node);
        node.num = visited.size();

        // for each s ∈ succOf(n) do
        Iterator<Node<E>> succs = node.succsOf();
        while (succs.hasNext()) {
            Node<E> succ = succs.next();

            // if s not visited then
            if (!visited.contains(succ)) {
                // dfs(s)
                innerDFS(visited, succ);
            }
        }
        
    }
    
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        List<Node<E>> visited = new ArrayList<Node<E>>();
        
        if (graph.containsNodeFor(root.item())) {
            innerDFS(visited, root);
        }
        
        return visited;
    }
    
    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        List<Node<E>> visited = new ArrayList<Node<E>>();
        
        // for each h ∈ heads(n) do
        Iterator<Node<E>> heads = graph.heads();
        while (heads.hasNext()) {
            Node<E> head = heads.next();
            
            // if s not visited then
            if (!visited.contains(head)) {
                // dfs(s)
                innerDFS(visited, head);
            }
        }

        return visited;
    }

    private void innerPostOrder() {
        // make nice
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
