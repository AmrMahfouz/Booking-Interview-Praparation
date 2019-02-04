package graphs;

import java.util.*;

public class GraphListTraversal {

    public static void main(String[] args) {
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);
        GraphNode n6 = new GraphNode(6);
        GraphNode n7 = new GraphNode(7);
        List<GraphNode> nodes = Arrays.asList(n1, n2, n3, n4, n5, n6, n7);
        GraphList directedGraph = new DirectedGraphList(nodes);
        directedGraph.addEdge(n1, n2);
        directedGraph.addEdge(n2, n3);
        directedGraph.addEdge(n3, n1);
        directedGraph.addEdge(n4, n5);
        directedGraph.addEdge(n5, n6);
        directedGraph.addEdge(n6, n7);
        directedGraph.addEdge(n7, n4);
        System.out.println("DFS for directed list graph");
        dfs(directedGraph);
        System.out.println("BFS for directed list graph");
        bfs(directedGraph);

        GraphList undirectedGraph = new UndirectedGraphList(nodes);
        undirectedGraph.addEdge(n1, n2);
        undirectedGraph.addEdge(n2, n3);
        undirectedGraph.addEdge(n3, n1);
        undirectedGraph.addEdge(n4, n5);
        undirectedGraph.addEdge(n5, n6);
        undirectedGraph.addEdge(n6, n7);
        undirectedGraph.addEdge(n7, n4);
        System.out.println("DFS for undirected matrix graph");
        dfs(undirectedGraph);
        System.out.println("BFS for undirected matrix graph");
        bfs(undirectedGraph);
    }

    public static void dfs(GraphList graph) {
        Set<GraphNode> visited = new HashSet<>();
        for (GraphNode node : graph.getNodes()) {
            dfsHelper(node, visited);
        }
    }

    private static void dfsHelper(GraphNode node, Set<GraphNode> visited) {
        if (!visited.contains(node)) {
            visited.add(node);
            System.out.println("Visiting node " + node);
        }
        for (GraphNode child : node.getChildren()) {
            if (!visited.contains(child)) {
                dfsHelper(child, visited);
            }
        }
    }

    public static void bfs(GraphList graph) {
        Set<GraphNode> visited = new HashSet<>();
        for (GraphNode node : graph.getNodes()) {
            bfsHelper(node, visited);
        }
    }

    private static void bfsHelper(GraphNode v, Set<GraphNode> visited) {
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(v);
        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            if (!visited.contains(node)) {
                visited.add(node);
                System.out.println("Visiting node " + node);
            }
            for (GraphNode child : node.getChildren()) {
                if (!visited.contains(child)) {
                    queue.add(child);
                }
            }
        }
    }

}
