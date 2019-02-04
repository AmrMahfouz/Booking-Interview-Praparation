package graphs;

import java.util.List;

public interface GraphMatrix {

    int getNumOfVertices();

    void addEdge(int from, int to);

    List<Integer> getChildren(int node);

}
