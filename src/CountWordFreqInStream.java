import java.util.*;

public class CountWordFreqInStream {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("aca", "cat", "hell", "hello", "lock", "world");
        for (Map.Entry<String, Integer> entry : wordFreq(words, "acacathellockword").entrySet()) {
            System.out.println("Word : " + entry.getKey() + " | count : " + entry.getValue());
        }
    }

    private static Map<String, Integer> wordFreq(List<String> words, String stream) {
        TrieNode root = generateDictionary(words);
        Map<String, Integer> wordFreq = new HashMap<>();

        Queue<TrieNode> queue = new ArrayDeque<>();

        for (char c : stream.toCharArray()) {
            Queue<TrieNode> temp = new ArrayDeque<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TrieNode node = queue.remove();
                if (node.isTerminatingNode) {
                    int count = wordFreq.getOrDefault(node.word, 0) + 1;
                    wordFreq.put(node.word, count);
                }
                if (node.getChildByChar(c) != null) {
                    temp.add(node.getChildByChar(c));
                }
            }
            queue.addAll(temp);
            temp.clear();
        }

        return wordFreq;

    }

    private static TrieNode generateDictionary(List<String> words) {

        TrieNode root = new TrieNode(' ');
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.addChildIfNotExist(c);
            }
            node.isTerminatingNode = true;
            node.word = word;
        }

        return root;
    }

    static class TrieNode {
        char c;
        boolean isTerminatingNode;
        String word;
        List<TrieNode> children = new ArrayList<>();

        public TrieNode(char c) {
            this.c = c;
        }

        public TrieNode getChildByChar(char c) {
            for (TrieNode child : children) {
                if (child.c == c) {
                    return child;
                }
            }
            return null;
        }

        public TrieNode addChildIfNotExist(char c) {
            for (TrieNode child : children) {
                if (child.c == c) {
                    return child;
                }
            }
            TrieNode newChild = new TrieNode(c);
            children.add(newChild);
            return newChild;
        }
    }

}
