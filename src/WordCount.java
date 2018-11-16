import java.util.*;

public class WordCount {

    public static void main(String[] args) {
        List<String> lines = Arrays.asList(
          "this is the new test",
          "Allowing this will be controlled",
          "this is new text",
          "text is good"
        );
        for (Count count : getTop5Words(lines)) {
            System.out.println("Word " + count.word + " | count " + count.count);
        }
    }

    private static Count[] getTop5Words(List<String> lines) {
        Map<String, Integer> wordCount = new HashMap<>();
        for (String line : lines) {
            line = line.toLowerCase().replace(".", "").replace(",", "").replace("?", "");
            String[] words = line.split(" ");
            for (String word : words) {
                int count = wordCount.getOrDefault(word, 0) + 1;
                wordCount.put(word, count);
            }
        }

        List<Count> counts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            counts.add(new Count(entry.getKey(), entry.getValue()));
        }

        Collections.sort(counts, new Comparator<Count>() {
            @Override
            public int compare(Count c1, Count c2) {
                return c2.count - c1.count;
            }
        });

        Count[] result = new Count[5];
        for (int i = 0; i < result.length; i++) {
            result[i] = counts.get(i);
        }

        return result;

    }

    static class Count {
        String word;
        int count;

        public Count(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

}
