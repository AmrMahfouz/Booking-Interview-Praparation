package glassdoor;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("amr", "rma", "mar", "mido", "diom", "nour", "roun", "mom");
        groupAnagrams(words).forEach((anagram, anagramWords) -> {
            System.out.println("Anagram = " + anagram);
            anagramWords.forEach(s -> {
                System.out.print(s + " ");
                System.out.println();
            });
        });
    }

    private static Map<String, List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> groupAnagrams = new HashMap<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String anagram = new String(chars);
            List<String> anagrams = groupAnagrams.getOrDefault(anagram, new ArrayList<>());
            anagrams.add(word);
            groupAnagrams.put(anagram, anagrams);
        }
        return groupAnagrams;
    }

}
