package graphs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {
        GraphMatrix graph = new DirectedGraphMatrix(7);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        topSort(graph);
    }

    private static void topSort(GraphMatrix graph) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int node = 1; node <= graph.getNumOfVertices(); node++) {
            if (!visited.contains(node)) {
                topSortHelper(graph, node, visited, stack);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void topSortHelper(GraphMatrix graph, int node, Set<Integer> visited, Stack<Integer> stack) {
        visited.add(node);
        for (int child : graph.getChildren(node)) {
            if (!visited.contains(child)) {
                topSortHelper(graph, child, visited, stack);
            }
        }
        stack.push(node);
    }

}
