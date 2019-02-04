package graphs;

import java.util.List;

public class DirectedGraphList implements GraphList {

    private List<GraphNode> nodes;

    public DirectedGraphList(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public void addEdge(GraphNode from, GraphNode to) {
        from.addChild(to);
    }

    public List<GraphNode> getNodes() {
        return nodes;
    }
}
