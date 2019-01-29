package careercup;

import java.util.*;

public class ArraysIntersection {

    public static void main(String[] args) {
        intersection(new int[]{0, 1, 1, 2, 2, 5}, new int[]{0, 1, 2, 2, 2, 6}).forEach(System.out::println);
        intersection(new int[]{0, 1, 1}, new int[]{0, 1, 2, 3, 4, 5, 6}).forEach(System.out::println);
    }

    private static List<Integer> intersection(int[] A, int[] B) {
        Map<Integer, Integer> elementCounts = new HashMap<>();
        for (int n : A) {
            elementCounts.put(n, elementCounts.getOrDefault(n, 0) + 1);
        }
        List<Integer> intersection = new ArrayList<>();
        for (int n : B) {
            if (elementCounts.containsKey(n)) {
                int count = elementCounts.get(n);
                if (count > 0) {
                    intersection.add(n);
                }
                elementCounts.put(n, count - 1);
            }
        }
        return intersection;
    }

}
