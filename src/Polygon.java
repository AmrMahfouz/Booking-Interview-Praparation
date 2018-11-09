import java.util.Arrays;
import java.util.List;

public class Polygon {

    public static void main(String[] args) {
        printPolygons(Arrays.asList(
                "36 30 36 30",
                "15 15 15 15",
                "46 96 90 100",
                "86 86 86 86",
                "100 200 100 200",
                "-100 200 -100 200"
        ));
    }

    public static void printPolygons(List<String> lines) {
        int numOfSquares = 0;
        int numOfRectangles = 0;
        int numOfOtherPolygons = 0;
        for (String line : lines) {
            String[] dimensions = line.split(" ");
            if (isValidDimensions(dimensions)) {
                if (isSquare(dimensions)) {
                    numOfSquares++;
                } else if (isRectangle(dimensions)) {
                    numOfRectangles++;
                } else {
                    numOfOtherPolygons++;
                }
            } else {
                numOfOtherPolygons++;
            }
        }
        System.out.println("Number of squares : " + numOfSquares);
        System.out.println("Number of rectangles : " + numOfRectangles);
        System.out.println("Number of other polygons : " + numOfOtherPolygons);
    }

    private static boolean isValidDimensions(String[] dimensions) {
        for (String dimension : dimensions) {
            if (dimension.startsWith("-") || dimension.startsWith("0")) {
                return false;
            }
        }
        return true;
    }

    private static boolean isRectangle(String[] dimensions) {
        return dimensions[0].equals(dimensions[2]) && dimensions[1].equals(dimensions[3]);
    }

    private static boolean isSquare(String[] dimensions) {
        return dimensions[0].equals(dimensions[1]) && dimensions[1].equals(dimensions[2]) && dimensions[2].equals(dimensions[3]);
    }

}
