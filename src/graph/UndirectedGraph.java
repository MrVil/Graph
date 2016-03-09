package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vil on 09/03/16.
 */
public class UndirectedGraph implements IUndirectedGraph {

    /* Pattern adapter */

    private Graph graph = new Graph();
    private static int edgeCount = 0;

    @Override
    public void addEdge(Node _node1, Node _node2) {
        Arc edge_a = new Arc(_node1, _node2, new IntegerLabel(edgeCount));
        Arc edge_b = new Arc(_node2, _node1, new IntegerLabel(edgeCount+1));
        edgeCount = edgeCount + 2;
        graph.addArc(edge_a);
        graph.addArc(edge_b);
    }

    @Override
    public boolean hasEdge(Node _node1, Node _node2) {
        return graph.hasArc(_node1,_node2);
    }

    @Override
    public void addNode(Node _node) {
        graph.addNode(_node);
    }

    @Override
    public List<Node> getAllNodes() {
        return graph.getAllNodes();
    }

    @Override
    public int getNbNodes() {
        return graph.getNbNodes();
    }

    @Override
    public List<Node> getAdjNodes(Node _n) {
        return graph.getAdjNodes(_n);
    }

    public String toString(){
        return graph.toString();
    }
}
