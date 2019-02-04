package glassdoor;

import graphs.DirectedGraphList;
import graphs.GraphList;
import graphs.GraphNode;
import graphs.UndirectedGraphList;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectCyclesUndirectedGraph {

    public static void main(String[] args) {
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        GraphNode n5 = new GraphNode(5);
        GraphNode n6 = new GraphNode(6);
        GraphNode n7 = new GraphNode(7);
        List<GraphNode> nodes = Arrays.asList(n1, n2, n3, n4, n5, n6, n7);
        GraphList undirectedGraph = new UndirectedGraphList(nodes);
        undirectedGraph.addEdge(n1, n2);
        undirectedGraph.addEdge(n2, n3);
        undirectedGraph.addEdge(n3, n1);
        undirectedGraph.addEdge(n4, n5);
        undirectedGraph.addEdge(n5, n6);
        undirectedGraph.addEdge(n6, n7);
        undirectedGraph.addEdge(n7, n4);
        System.out.println(hasCycle(undirectedGraph));
    }

    private static boolean hasCycle(GraphList graph) {
        Set<GraphNode> visited = new HashSet<>();
        for (GraphNode node : graph.getNodes()) {
            if (!visited.contains(node)) {
                if (dfs(node, visited, null)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(GraphNode node, Set<GraphNode> visited, GraphNode parent) {
        visited.add(node);
        for (GraphNode child : node.getChildren()) {
            if (parent != null && parent.equals(child)) {
                continue;
            }
            if (visited.contains(child)) {
                return true;
            }
            if (dfs(child, visited, node)) {
                return true;
            }
        }
        return false;
    }



}
