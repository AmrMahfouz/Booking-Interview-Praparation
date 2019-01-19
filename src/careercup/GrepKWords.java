package careercup;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GrepKWords {

    private static String[] grep(List<String> words, String matchWord, int k) {
        Queue<String> queue = new LinkedList<>();
        String[] result = new String[k];
        int index = 0;
        for (String word : words) {
            if (matchWord.equals(word)) {
                for (String prevWord : queue) {
                    result[index++] = prevWord;
                }
                break;
            }
            if (queue.size() == k) {
                queue.poll();
            }
            queue.add(word);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList(
                "aaa",
                "bbb",
                "ccc",
                "booking",
                "alpha",
                "beta",
                "gamma"
        );
        for (String word : grep(words, "booking", 3)) {
            System.out.println(word);
        }
        for (String word : grep(words, "beta", 2)) {
            System.out.println(word);
        }
    }

}
