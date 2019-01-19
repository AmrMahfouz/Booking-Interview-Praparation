package careercup;

public class BlackWhiteMatrix {

    public static void main(String[] args) {
        char[][] matrix = new char[][] {
                {'E', 'E', 'E', 'E', 'B'},
                {'E', 'W', 'W', 'B', 'W'},
                {'W', 'B', 'B', 'B', 'W'},
                {'E', 'W', 'W', 'B', 'W'},
                {'E', 'E', 'E', 'E', 'B'}
        };
        for (int x = 0; x < matrix.length; x++) {
            for (int y = 0; y < matrix[x].length; y++) {
                System.out.print(isCaptured(matrix, x,y) + " ");
            }
            System.out.println();
        }
    }

    private static boolean isCaptured(char[][] matrix, int x, int y) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
            throw new RuntimeException("Invalid arguments");
        }
        return isCapturedHelper(matrix, x, y, matrix[x][y]);
    }

    private static boolean isCapturedHelper(char[][] matrix, int x, int y, char v) {
        if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length) {
            return true;
        }
        if (matrix[x][y] == 'E') {
            return false;
        }
        char type = matrix[x][y];
        if (type == 'B' && v == 'W' || type == 'W' && v == 'B' || type == 'V') {
            return true;
        }
        matrix[x][y] = 'V';
        boolean isCaptured = isCapturedHelper(matrix, x - 1, y, v)
                && isCapturedHelper(matrix, x + 1, y, v)
                && isCapturedHelper(matrix, x, y - 1, v)
                && isCapturedHelper(matrix, x, y + 1, v);
        matrix[x][y] = type;
        return isCaptured;
    }

}
