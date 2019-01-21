package careercup;

import java.util.*;

public class StreamWordCount {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("aca", "cat", "hello", "world");
        wordCount("acacabcatghhellomvnsdb", words).forEach((s, i) -> System.out.println("Word " + s + " count " + i));
    }

    private static Map<String, Integer> wordCount(String stream, List<String> words) {
        Map<String, Integer> wordCounts = new HashMap<>();
        words.forEach(s -> wordCounts.put(s, 0));
        TrieNode root = buildTrie(words);
        Queue<TrieNode> queue = new ArrayDeque<>();
        for (char c : stream.toCharArray()) {
            Queue<TrieNode> tempQueue = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TrieNode node = queue.remove();
                if (node.isTerminal) {
                    wordCounts.put(node.word, wordCounts.get(node.word) + 1);
                }
                TrieNode child = node.getChild(c);
                if (child != null) {
                    tempQueue.add(child);
                }
            }
            queue.addAll(tempQueue);
            tempQueue.clear();
        }
        return wordCounts;
    }

    private static TrieNode buildTrie(List<String> words) {
        TrieNode root = new TrieNode(' ');
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                TrieNode child = node.getChild(c);
                if (child == null) {
                    child = new TrieNode(c);
                    node.children.add(child);
                }
                node = child;
            }
            node.isTerminal = true;
            node.word = word;
        }
        return root;
    }

    private static class TrieNode {

        char value;
        boolean isTerminal;
        List<TrieNode> children = new ArrayList<>();
        String word;

        TrieNode(char value) {
            this.value = value;
        }

        TrieNode getChild(char c) {
            for (TrieNode child : children) {
                if (child.value == c) {
                    return child;
                }
            }
            return null;
        }
    }

}
