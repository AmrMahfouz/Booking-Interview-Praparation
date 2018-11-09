import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortFile {

    public static void main(String[] args) {
        List<String> lines = Arrays.asList(
                "Jervie,12,M",
                "Jaimy,11,F",
                "Tony,23,M",
                "Janey,11,F"
        );
        sortFile(lines);
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public static void sortFile(List<String> lines) {
        Collections.sort(lines, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String var1 = o1.split(",")[1];
                String var2 = o2.split(",")[1];
                return var1.compareTo(var2);
            }
        });
    }

}
