package graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

    private int value;

    private List<GraphNode> children;

    public GraphNode(int value) {
        this.value = value;
        children = new ArrayList<>();
    }

    public void addChild(GraphNode node) {
        children.add(node);
    }

    public List<GraphNode> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "value=" + value +
                '}';
    }
}
