/**
 * MyBFS.java
 * Date: 21 oct 2021
 * Author: Oskar Lövsveden
 */

package ol222hf_assign3.ol222hf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ol222hf_assign3.graphs.BFS;
import ol222hf_assign3.graphs.DirectedGraph;
import ol222hf_assign3.graphs.Node;

public class MyBFS<E> implements BFS<E> {

    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
        List<Node<E>> visited = new ArrayList<Node<E>>();
        Queue<Node<E>> queue = new LinkedList<Node<E>>();

        visited.add(root);
        root.num = visited.size();
        queue.add(root);

        innerBFS(visited, queue);
        return visited;
    }

    @Override
    public List<Node<E>> bfs(DirectedGraph<E> graph) {
        List<Node<E>> visited = new ArrayList<Node<E>>();
        Queue<Node<E>> queue = new LinkedList<Node<E>>();

        Iterator<Node<E>> heads = graph.heads();
        while (heads.hasNext()) {
            Node<E> head = heads.next();
            visited.add(head);
            head.num = visited.size();
            queue.add(head);
        }

        innerBFS(visited, queue);
        return visited;
    }

    /**
     * Helper method to handle the BFS algorithm.
     * 
     * @param visited a list containing the visited nodes.
     * @param queue   the queue containing the order that we iteratively run bfs on
     *                nodes.
     */
    private void innerBFS(List<Node<E>> visited, Queue<Node<E>> queue) {
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            Iterator<Node<E>> succs = node.succsOf();
            while (succs.hasNext()) {
                Node<E> succ = succs.next();
                if (!visited.contains(succ)) {
                    visited.add(succ);
                    succ.num = visited.size();
                    queue.add(succ);
                }
            }
        }
    }
}
