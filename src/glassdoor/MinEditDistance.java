package glassdoor;

public class MinEditDistance {

    public static void main(String[] args) {
        System.out.println(minNumOfOperations("sunday", "saturday"));
        System.out.println(minNumOfOperations("acdgf", "abdfg"));
    }

    private static int minNumOfOperations(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = getMInOf3(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                }
            }
        }

        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            if (i == 0) {
                System.out.println("inserting " + s2.charAt(j - 1));
                j--;
            } else if (j == 0) {
                System.out.println("removing " + s1.charAt(i - 1));
                i--;
            } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                i--;
                j--;
            } else {
                switch (getMinOperation(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j])) {
                    case 1:
                        System.out.println("replace " + s1.charAt(i - 1) + " with " + s2.charAt(j - 1));
                        i--;
                        j--;
                        break;
                    case 2:
                        System.out.println("inserting " + s2.charAt(j - 1));
                        j--;
                        break;
                    case 3:
                        System.out.println("removing " + s1.charAt(i - 1));
                        i--;
                        break;
                }
            }
        }

        return dp[m][n];

    }

    private static int getMInOf3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    private static int getMinOperation(int replace, int insert, int remove) {
        // return 1 for replace
        // return 2 for insert
        // return 3 for remove
        if (replace <= insert && replace <= remove) {
            return 1;
        }
        if (insert <= replace && insert <= remove) {
            return 2;
        }
        if (remove <= insert && remove <= replace) {
            return 3;
        }
        return -1;
    }

}
