package careercup;

import java.util.*;

public class SiblingsLink {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);
        Node n9 = new Node(9);
        Node n10 = new Node(10);
        Node root = n1;
        n1.children.add(n2);
        n1.children.add(n3);
        n1.children.add(n4);
        n2.children.add(n5);
        n2.children.add(n6);
        n3.children.add(n7);
        n4.children.add(n8);
        n4.children.add(n9);
        n4.children.add(n10);
        n7.children.add(new Node(11));
        n9.children.add(new Node(12));
        n9.children.add(new Node(13));
        linkSibling(root);
        root.printSiblings();
    }

    private static void linkSibling(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Node> levelNodes = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                // add children of the node
                for (Node child : node.children) {
                    queue.add(child);
                }
                levelNodes.add(node);
            }
            // link level nodes
            Node prevNode = null;
            for (Node node : levelNodes) {
                if (prevNode != null) {
                    prevNode.sibling = node;
                }
                prevNode = node;
            }
        }
    }

    private static class Node {

        public int value;

        public List<Node> children = new ArrayList<>();

        public Node sibling;

        public Node(int value) {
            this.value = value;
        }

        public void printSiblings() {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                for (Node child : node.children) {
                    queue.add(child);
                }
                int siblingValue = node.sibling == null ? -1 : node.sibling.value;
                System.out.println("Node " + node.value + " sibling is " + siblingValue);
            }
        }

    }

}
