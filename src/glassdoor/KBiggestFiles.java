package glassdoor;

import java.util.*;

public class KBiggestFiles {

    public static void main(String[] args) {
        Node root = new Node();
        Node file1 = new Node(100);
        Node file2 = new Node(200);
        Node file3 = new Node(300);
        Node file4 = new Node(400);
        Node file5 = new Node(500);
        Node file6 = new Node(600);
        Node file7 = new Node(700);
        Node directory1 = new Node();
        Node directory2 = new Node();
        Node directory3 = new Node();

        root.children.add(file1);
        root.children.add(directory1);
        root.children.add(file2);
        root.children.add(directory2);
        directory1.children.add(file3);
        directory1.children.add(file4);
        directory2.children.add(file5);
        directory2.children.add(directory3);
        directory3.children.add(file6);
        directory3.children.add(file7);

        getBiggestKFiles(root, 3).forEach(System.out::println);
    }

    // assuming the file representation is a tree with the following structure the files is a leaf nodes and the parent nodes are directories so the node class will be as following
    private static class Node {
        int size;
        List<Node> children = new ArrayList<>();

        public Node() {
        }

        public Node(int size) {
            this.size = size;
        }
    }

    // so to get the k biggest files we will traverse the tree and maintain a priority queue of size k
    private static List<Integer> getBiggestKFiles(Node root, int k) {
        // to keep the maximum k elements we will use a min priority queue which implies a min heap by default
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // we will traverse the tree using BFS
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.size != 0 && node.children.isEmpty()) { // it is a file not a directory
                minHeap.add(node.size);
                if (minHeap.size() > k) {
                    minHeap.poll();
                }
            } else {
                for (Node child : node.children) {
                    queue.add(child);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }



}
