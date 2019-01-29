package careercup;

import java.util.*;

public class FindSquareRoots {

    public static void main(String[] args) {
        findSquareRoots(new int[]{3, 1, 4, 5, 19, 6}, new int[]{14, 9, 22, 36, 8, 0, 64, 25}).forEach(System.out::println);
    }

    private static List<Integer> findSquareRoots(int[] nums, int[] squares) {
        Set<Integer> squareSet = new HashSet<>();
        for (int square : squares) {
            squareSet.add(square);
        }
        List<Integer> foundSquares = new ArrayList<>();
        for (int num : nums) {
            if (squareSet.contains(num * num)) {
                foundSquares.add(num * num);
            }
        }
        return foundSquares;
    }

}
