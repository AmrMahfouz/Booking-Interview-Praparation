package glassdoor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeltaEncoding {

    public static void main(String[] args) {
        deltaEncoding(Arrays.asList(25626, 25757, 24367, 24267, 16, 100, 2, 7277)).forEach(System.out::println);
    }

    private static List<Integer> deltaEncoding(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        int prev = nums.get(0);
        result.add(prev);
        for (int i = 1; i < nums.size(); i++) {
            int current = nums.get(i);
            int diff = current - prev;
            if (diff < -127 || diff > 127) {
                result.add(-128);
            }
            result.add(diff);
            prev = current;
        }
        return result;
    }

}
