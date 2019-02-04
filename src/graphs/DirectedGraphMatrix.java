package graphs;

import java.util.ArrayList;
import java.util.List;

public class DirectedGraphMatrix implements GraphMatrix {

    private int numOfVertices;

    private boolean[][] matrix;

    public DirectedGraphMatrix(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        matrix = new boolean[numOfVertices][numOfVertices];
    }

    public int getNumOfVertices() {
        return numOfVertices;
    }

    public void addEdge(int from, int to) {
        matrix[from - 1][to - 1] = true;
    }

    public List<Integer> getChildren(int node) {
        List<Integer> children = new ArrayList<>();
        for (int j = 0; j < numOfVertices; j++) {
            if (matrix[node - 1][j]) {
                children.add(j + 1);
            }
        }
        return children;
    }
}
