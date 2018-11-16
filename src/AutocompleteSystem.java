import java.util.*;

public class AutocompleteSystem {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("test", "word", "and", "word2", "word3", "amr");
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        for (String word : trie.wordsByPrefix("a")) {
            System.out.println(word);
        }
    }


    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode(' ');
        }

        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node = node.addChildNode(c);
            }
            node.isTerminal = true;
            node.word = word;
        }

        public List<String> wordsByPrefix(String prefix) {
            List<String> words = new ArrayList<>();
            Queue<TrieNode> queue = new ArrayDeque<>();
            queue.add(getLastNode(prefix));
            while (!queue.isEmpty()) {
                TrieNode node = queue.remove();
                if (node.isTerminal) {
                    words.add(node.word);
                }
                for (TrieNode child : node.children) {
                    queue.add(child);
                }
            }
            return words;
        }

        private TrieNode getLastNode(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node == null) {
                    return null;
                }
                node = node.getChildNode(c);
            }
            return node;
        }

    }

    static class TrieNode {
        boolean isTerminal;
        String word;
        char c;
        List<TrieNode> children = new ArrayList<>();

        public TrieNode(char c) {
            this.c = c;
        }

        public TrieNode addChildNode(char c) {
            TrieNode child = getChildNode(c);
            if (child != null) {
                return child;
            }
            child = new TrieNode(c);
            children.add(child);
            return child;
        }

        public TrieNode getChildNode(char c) {
            for (TrieNode child : children) {
                if (child.c == c) {
                    return child;
                }
            }
            return null;
        }

    }

}
