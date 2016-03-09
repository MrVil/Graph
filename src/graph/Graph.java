package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vil on 09/03/16.
 */
public class Graph implements IDirectedGraph {

    private List<Arc> arcs = new ArrayList<Arc>();
    private List<Node> nodes = new ArrayList<Node>();

    @Override
    public boolean hasArc(Node _n1, Node _n2) {

        for(Arc arc : this.arcs){
            if(arc.getSource().equals(_n1))
                if(arc.getDestination().equals(_n2))
                    return true;
        }

        return false;
    }

    @Override
    public void addArc(Arc _edge) {
        arcs.add(_edge);
    }

    @Override
    public List<Arc> getArc(Node _n) {
        List<Arc> tmp = new ArrayList<Arc>();

        for(Arc arc : this.arcs){
            if(arc.getSource().equals(_n))
                tmp.add(arc);
        }

        return tmp;
    }

    @Override
    public void addNode(Node _node) {
        nodes.add(_node);
    }

    @Override
    public List<Node> getAllNodes() {
        return nodes;
    }

    @Override
    public int getNbNodes() {
        return nodes.size();
    }

    @Override
    public List<Node> getAdjNodes(Node _n) {
        List<Node> adj = new ArrayList<Node>();

        for(Arc arc : this.arcs){
            if(arc.getSource().equals(_n))
                adj.add(arc.getDestination());
        }
        return adj;
    }

    @Override
    public String toString() {
    	String res = "";
    	res += this.label + "\n";
    	for(Node node : nodes) {
    		res += "| noeud=" + node + " : " + getArc(node);
    		res += "\n";
    	}
    	return res;
    }
}
