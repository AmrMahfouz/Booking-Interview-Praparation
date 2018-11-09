import java.util.*;

public class Anagram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if ("".equals(line)) {
                scanner.close();
                break;
            }
            words.add(line);
        }

        Collections.sort(words);

        Map<String, List<String>> map = new LinkedHashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new LinkedList<>());
            }
            map.get(sortedWord).add(word);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (List<String> group : map.values()) {
            for (String word : group) {
                stringBuilder.append(word);
                stringBuilder.append(",");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            System.out.println(stringBuilder.toString());
            stringBuilder = new StringBuilder();
        }
    }

}
