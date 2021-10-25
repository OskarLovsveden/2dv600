/**
 * MyDFS.java
 * Date: 21 oct 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign3.ol222hf;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import ol222hf_assign3.graphs.DFS;
import ol222hf_assign3.graphs.DirectedGraph;
import ol222hf_assign3.graphs.Node;

public class MyDFS<E> implements DFS<E> {

    /**
     * Helper method to handle the DFS algorithm.
     * 
     * @param visited stores result list and visited set.
     * @param node    the node of which to run DFS on.
     */
    private void innerDFS(MyAlgorithmCollections<Node<E>> visited, Node<E> node) {
        visited.visit(node);
        visited.add(node);
        node.num = visited.visitedSize();

        Iterator<Node<E>> succs = node.succsOf();
        while (succs.hasNext()) {
            Node<E> succ = succs.next();

            if (!visited.contains(succ)) {
                innerDFS(visited, succ);
            }
        }
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
        MyAlgorithmCollections<Node<E>> visited = new MyAlgorithmCollections<Node<E>>();

        innerDFS(visited, root);
        return visited.getResult();
    }

    @Override
    public List<Node<E>> dfs(DirectedGraph<E> graph) {
        MyAlgorithmCollections<Node<E>> visited = new MyAlgorithmCollections<Node<E>>();

        Iterator<Node<E>> heads = graph.heads();
        while (heads.hasNext()) {
            Node<E> head = heads.next();

            if (!visited.contains(head)) {
                innerDFS(visited, head);
            }
        }

        return visited.getResult();
    }

    /**
     * Helper method for the PostOrder algorithm.
     * 
     * @param visited stores result list and visited set.
     * @param node    the node of which to run postorder on.
     */
    private void innerPostOrder(MyAlgorithmCollections<Node<E>> visited, Node<E> node) {
        visited.visit(node);

        Iterator<Node<E>> succs = node.succsOf();
        while (succs.hasNext()) {
            Node<E> succ = succs.next();

            if (!visited.contains(succ)) {
                innerPostOrder(visited, succ);
            }
        }

        visited.add(node);
        node.num = visited.resultSize();
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
        MyAlgorithmCollections<Node<E>> visited = new MyAlgorithmCollections<Node<E>>();
        innerPostOrder(visited, root);
        return visited.getResult();
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g) {
        MyAlgorithmCollections<Node<E>> visited = new MyAlgorithmCollections<Node<E>>();

        Iterator<Node<E>> heads = g.heads();
        while (heads.hasNext()) {
            Node<E> head = heads.next();

            if (!visited.contains(head)) {
                innerPostOrder(visited, head);
            }
        }

        return visited.getResult();
    }

    @Override
    public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
        List<Node<E>> poList = postOrder(g);
        if (attach_dfs_number)
            dfs(g);
        return poList;
    }

    @Override
    public boolean isCyclic(DirectedGraph<E> graph) {
        postOrder(graph);

        for (Node<E> node : graph) {

            Iterator<Node<E>> succs = node.succsOf();
            while (succs.hasNext()) {
                Node<E> succ = succs.next();
                if (node.num <= succ.num) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public List<Node<E>> topSort(DirectedGraph<E> graph) {
        List<Node<E>> poList = postOrder(graph);
        Collections.reverse(poList);
        return poList;
    }
}
