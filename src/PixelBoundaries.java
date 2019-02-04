public class PixelBoundaries {

    public static void main(String[] args) {
        int[][] screen = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 5, 1, 1, 1, 1},
                {1, 1, 1, 1, 5, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 5, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 5, 5, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
        surroundColor(3, 4, screen);
        for (int i = 0; i < screen.length; i++) {
            for (int j = 0; j < screen[0].length; j++) {
                System.out.print(screen[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void surroundColor(int x, int y, int[][] screen) {
        int selectedColor = screen[x][y];
        boolean[][] visited = new boolean[screen.length][screen.length];
        surroundColorHelper(x, y, screen, selectedColor, visited);
    }

    private static void surroundColorHelper(int x, int y, int[][] screen, int selectedColor, boolean[][] visited) {
        // check x and y
        if (x < 0 || x >= screen.length || y < 0 || y >= screen[0].length || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        // check all directions and if you found another color we will change the pixel to -1
        if (screen[x][y] != selectedColor) {
            screen[x][y] = -1;
            return;
        }
        surroundColorHelper(x + 1, y, screen, selectedColor, visited);
        surroundColorHelper(x - 1, y, screen, selectedColor, visited);
        surroundColorHelper(x, y + 1, screen, selectedColor, visited);
        surroundColorHelper(x, y - 1, screen, selectedColor, visited);
        surroundColorHelper(x + 1, y, screen, selectedColor, visited);
        surroundColorHelper(x + 1, y + 1, screen, selectedColor, visited);
        surroundColorHelper(x + 1, y - 1, screen, selectedColor, visited);
        surroundColorHelper(x - 1, y + 1, screen, selectedColor, visited);
        surroundColorHelper(x - 1, y - 1, screen, selectedColor, visited);
    }

}
