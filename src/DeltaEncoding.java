import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeltaEncoding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numsAsString = input.split(" ");
        List<Integer> result = new ArrayList<>();
        result.add(Integer.parseInt(numsAsString[0]));
        int prev = result.get(0);
        for (int i = 1; i < numsAsString.length; i++) {
            int num = Integer.parseInt(numsAsString[i]);
            int diff = num - prev;
            if (diff > 127 || diff < -127) {
                result.add(-128);
            }
            result.add(diff);
            prev = num;
        }
        for (int num :result) {
            System.out.print(num + " ");
        }
        scanner.close();
    }

}
