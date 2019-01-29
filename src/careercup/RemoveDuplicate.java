package careercup;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicate {

    public static void main(String[] args) {
        removeDuplicates(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 23}).forEach(System.out::println);
    }

    private static List<Integer> removeDuplicates(int[] array) {
        Set<Integer> uniqueElements = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int n : array) {
            if (!uniqueElements.contains(n)) {
                result.add(n);
            }
            uniqueElements.add(n);
        }
        return result;
    }

}
