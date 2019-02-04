package graphs;

import java.util.List;

public class UndirectedGraphList implements GraphList {

    private List<GraphNode> nodes;

    public UndirectedGraphList(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public void addEdge(GraphNode n1, GraphNode n2) {
        n1.addChild(n2);
        n2.addChild(n1);
    }

    public List<GraphNode> getNodes() {
        return nodes;
    }
}
