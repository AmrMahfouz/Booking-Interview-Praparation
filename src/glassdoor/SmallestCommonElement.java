package glassdoor;

import java.util.Arrays;

public class SmallestCommonElement {

    public static void main(String[] args) {
        System.out.println(smallestCommonElement(new int[]{6, 13, 10, 6, 4}, new int[]{3, 5, 7, 8, 9, 91}));
        System.out.println(smallestCommonElement(new int[]{6, 3, 10, 6, 4}, new int[]{3, 5, 7, 8, 9, 91}));

    }

    private static int smallestCommonElement(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0; // a pointer
        int j = 0; // b pointer
        while (i < a.length && j < a.length) {
            if (a[i] == b[j]) {
                return a[i];
            }
            if (a[i] > b[j]) {
                j++;
            } else {
                i++;
            }
        }
        return -1;
    }

}
