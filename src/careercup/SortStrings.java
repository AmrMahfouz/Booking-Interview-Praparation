package careercup;

import java.util.*;

public class SortStrings {

    public static void main(String[] args) {
        sortStrings(Arrays.asList("luis", "hector", "selena", "emmanuel", "amish")).forEach(System.out::println);
        sortStrings(Arrays.asList("riga", "amsterdam", "moscow", "alexandria")).forEach(System.out::println);
    }

    private static List<String> sortStrings(List<String> strings) {
        Map<Character, List<String>> startCharMap = new HashMap<>();
        Set<Character> endChars = new HashSet<>();
        for (String s : strings) {
            char first = s.charAt(0);
            char last = s.charAt(s.length() - 1);
            List<String> list = startCharMap.getOrDefault(first, new ArrayList<>());
            list.add(s);
            startCharMap.put(first, list);
            endChars.add(last);
        }
        // get starting string its first character is not in the endChars list
        String startString = null;
        for (String s : strings) {
            char first = s.charAt(0);
            if (!endChars.contains(first)) {
                startString = s;
                break;
            }
        }

        List<String> result = new ArrayList<>();
        String prevString = startString;

        Set<String> remainingStrings = new HashSet<>(strings);

        while (!remainingStrings.isEmpty()) {
            if (prevString == null) {
                prevString = remainingStrings.iterator().next();
            }
            result.add(prevString);
            remainingStrings.remove(prevString);
            // get the next string
            char last = prevString.charAt(prevString.length() - 1);
            prevString = null;
            if (startCharMap.containsKey(last)) {
                for (String s : startCharMap.get(last)) {
                    if (stringLoop(s)) {
                        result.add(s);
                        remainingStrings.remove(s);
                    } else {
                        prevString = s;
                    }
                }
            }
        }

        if (prevString != null) {
            result.add(prevString);
        }

        return result;
    }

    private static boolean stringLoop(String s) {
        return (s.charAt(0) == s.charAt(s.length() - 1));
    }

}
