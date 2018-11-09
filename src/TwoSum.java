import java.util.*;

public class TwoSum {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Set<Integer> diff = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int number = scanner.nextInt();
            if (diff.contains(number)) {
                System.out.println(1);
                break;
            }
            diff.add(n - number);
        }
    }

}
