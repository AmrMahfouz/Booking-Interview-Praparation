package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GraphMatrixTraversal {

    public static void main(String[] args) {
        GraphMatrix directedGraph = new DirectedGraphMatrix(7);
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(3, 1);
        directedGraph.addEdge(4, 5);
        directedGraph.addEdge(5, 6);
        directedGraph.addEdge(6, 7);
        directedGraph.addEdge(7, 4);
        System.out.println("DFS for directed matrix graph");
        dfs(directedGraph);
        System.out.println("BFS for directed matrix graph");
        bfs(directedGraph);

        GraphMatrix undirectedGraph = new UndirectedGraphMatrix(7);
        undirectedGraph.addEdge(1, 2);
        undirectedGraph.addEdge(2, 3);
        undirectedGraph.addEdge(3, 1);
        undirectedGraph.addEdge(4, 5);
        undirectedGraph.addEdge(5, 6);
        undirectedGraph.addEdge(6, 7);
        undirectedGraph.addEdge(7, 4);
        System.out.println("DFS for undirected matrix graph");
        dfs(undirectedGraph);
        System.out.println("BFS for undirected matrix graph");
        bfs(undirectedGraph);
    }

    public static void dfs(GraphMatrix graph) {
        Set<Integer> visited = new HashSet<>();
        for (int v = 1; v <= graph.getNumOfVertices(); v++) {
            dfsHelper(graph, v, visited);
        }
    }

    private static void dfsHelper(GraphMatrix graph, int v, Set<Integer> visited) {
        if (!visited.contains(v)) {
            visited.add(v);
            System.out.println("Visiting node " + v);
        }
        for (int child : graph.getChildren(v)) {
            if (!visited.contains(child)) {
                dfsHelper(graph, child, visited);
            }
        }
    }

    public static void bfs(GraphMatrix graph) {
        Set<Integer> visited = new HashSet<>();
        for (int v = 1; v <= graph.getNumOfVertices(); v++) {
            bfsHelper(graph, v, visited);
        }
    }

    private static void bfsHelper(GraphMatrix graph, int v, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                System.out.println("Visiting node " + node);
            }
            for (int child : graph.getChildren(node)) {
                if (!visited.contains(child)) {
                    queue.add(child);
                }
            }
        }
    }

}
