package glassdoor;

import graphs.DirectedGraphList;
import graphs.GraphList;
import graphs.GraphNode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DetectCyclesInDirectedGraph {

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
        System.out.println(hasCycle(directedGraph));
    }

    private static boolean hasCycle(GraphList graph) {
        Set<GraphNode> whiteSet = new HashSet<>();
        Set<GraphNode> graySet = new HashSet<>();
        Set<GraphNode> blackSet = new HashSet<>();

        whiteSet.addAll(graph.getNodes());

        while(!whiteSet.isEmpty()) {
            GraphNode node = whiteSet.iterator().next();
            if (dfs(node, whiteSet, graySet, blackSet)) {
                return true;
            };
        }

        return false;
    }

    private static boolean dfs(GraphNode node, Set<GraphNode> whiteSet, Set<GraphNode> graySet, Set<GraphNode> blackSet) {
        moveNode(node, whiteSet, graySet);
        for (GraphNode child : node.getChildren()) {
            if (blackSet.contains(child)) {
                continue;
            }
            if (graySet.contains(child)) {
                return true;
            }
            if (dfs(child, whiteSet, graySet, blackSet)) {
                return true;
            }
        }
        moveNode(node, graySet, blackSet);
        return false;
    }

    private static void moveNode(GraphNode node, Set<GraphNode> from, Set<GraphNode> to) {
        from.remove(node);
        to.add(node);
    }

}
