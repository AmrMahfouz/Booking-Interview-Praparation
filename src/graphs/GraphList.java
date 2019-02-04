package graphs;

import java.util.List;

public interface GraphList {

    void addEdge(GraphNode n1, GraphNode n2);

    List<GraphNode> getNodes();

}
