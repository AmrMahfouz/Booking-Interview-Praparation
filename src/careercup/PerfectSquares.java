package careercup;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {

    public static void main(String[] args) {
//        System.out.println(numOfPerfectSquares(5));
//        System.out.println(numOfPerfectSquares(7));
        System.out.println(numOfPerfectSquares(12));
        System.out.println(numOfPerfectSquares(20));
        System.out.println(numOfPerfectSquares(99));
    }

    private static int numOfPerfectSquares(int n) {
        List<Integer> perfectSquares = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int square = i * i;
            if (square < n) {
                perfectSquares.add(square);
            } else if (square > n) {
                break;
            } else {
                return 1;
            }
        }
        int minNumOfPerfectSquares = 0;
        for (int i = perfectSquares.size() - 1; i >= 0; i--) {
            int numOfPerfectSquares = 0;
            int index = i;
            int num = n;
            while (num != 0) {
                if (num >= perfectSquares.get(index)) {
                    numOfPerfectSquares++;
                    num -= perfectSquares.get(index);
                } else {
                    index--;
                }
            }
            if (minNumOfPerfectSquares == 0) {
                minNumOfPerfectSquares = numOfPerfectSquares;
            } else {
                minNumOfPerfectSquares = Math.min(numOfPerfectSquares, minNumOfPerfectSquares);
            }
        }
        return minNumOfPerfectSquares;
    }

}
