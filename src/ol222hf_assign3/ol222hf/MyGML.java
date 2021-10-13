package ol222hf_assign3.ol222hf;

import java.util.Iterator;

import ol222hf_assign3.graphs.DirectedGraph;
import ol222hf_assign3.graphs.GML;
import ol222hf_assign3.graphs.Node;

public class MyGML<E> extends GML<E>{

    public MyGML(DirectedGraph<E> dg) {
        super(dg);
    }

    @Override
    public String toGML() {
        StringBuilder sbGraph = new StringBuilder();
        StringBuilder sbNodes = new StringBuilder();
        StringBuilder sbEdges = new StringBuilder();

        sbGraph.append("graph [\n");
	    sbGraph.append("\tdirected 1\n");
	    sbGraph.append("\tlabel \"Directed Graph\"\n");
        
        // iterate nodes
        Iterator<Node<E>> nodes = graph.iterator();
        while (nodes.hasNext()) {
            Node<E> node = nodes.next();
            sbNodes.append("\tnode [\n");
            sbNodes.append("\t\tid "+node+"\n");
            sbNodes.append("\t\tlabel \""+node+"\"\n");
            sbNodes.append("\t]\n");

            // iterate edges
            Iterator<Node<E>> edges = node.succsOf();
            while (edges.hasNext()) {
                Node<E> edge = edges.next();
                sbEdges.append("\tedge [\n");
                sbEdges.append("\t\tsource "+node+"\n");
                sbEdges.append("\t\ttarget "+edge+"\n");
                sbEdges.append("\t]\n");
            }
        }

        sbGraph.append(sbNodes);
        sbGraph.append(sbEdges);
        sbGraph.append("]");
        return sbGraph.toString();
    }
}
