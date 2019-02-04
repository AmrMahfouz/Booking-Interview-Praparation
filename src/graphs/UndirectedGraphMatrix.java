package graphs;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphMatrix implements GraphMatrix {

    private int numOfVertices;

    private boolean[][] matrix;

    public UndirectedGraphMatrix(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        matrix = new boolean[numOfVertices][numOfVertices];
    }

    public int getNumOfVertices() {
        return numOfVertices;
    }

    public void addEdge(int n1, int n2) {
        matrix[n1 - 1][n2 - 1] = true;
        matrix[n2 - 1][n1 - 1] = true;
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
