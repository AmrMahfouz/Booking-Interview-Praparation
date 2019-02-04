package glassdoor;

public class MazeExitProblem {

    public static void main(String[] args) {
        int[][] maze = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 0, 5}
        };
        System.out.println(exitMaze(maze, new Point(0, 0)));
    }

    private static boolean exitMaze(int[][] maze, Point start) {
        boolean[][] visited = new boolean[maze.length][maze.length];
        return exitMazeHelper(maze, start, visited);
    }

    private static boolean exitMazeHelper(int[][] maze, Point p, boolean[][] visited) {
        // validate point
        if (p.x < 0 || p.x >= maze.length || p.y < 0 || p.y >= maze.length || visited[p.x][p.y]) {
            return false;
        }
        visited[p.x][p.y] = true;
        if (!canMove(p, maze)) {
            return false;
        }
        if (isEnd(p, maze)) {
            return true;
        }
        return exitMazeHelper(maze, p.getRight(), visited) ||
                exitMazeHelper(maze, p.getLeft(), visited) ||
                exitMazeHelper(maze, p.getUp(), visited) ||
                exitMazeHelper(maze, p.getDown(), visited);
    }

    private static boolean canMove(Point p, int[][] maze) {
        // blocked cells will be marked with 1 or any other value except 5
        return maze[p.x][p.y] == 0 || isEnd(p, maze);
    }

    private static boolean isEnd(Point p, int[][] maze) {
        // end cell marked with 5
        return maze[p.x][p.y] == 5;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point getRight() {
            return new Point(x + 1, y);
        }

        public Point getLeft() {
            return new Point(x - 1, y);
        }

        public Point getUp() {
            return new Point(x, y + 1);
        }

        public Point getDown() {
            return new Point(x, y - 1);
        }
    }

}
