package glassdoor;

public class Leetcode289GameOfLife {

    public static void main(String[] args) {
        int[][] board = new int[][] {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(board);
    }

    public static void gameOfLife(int[][] board) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                gameOfLifeHelper(board, new Point(x, y));
            }
        }
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[x].length; y++) {
                if (board[x][y] == 2) {
                    board[x][y] = 1;
                } else if (board[x][y] == -1) {
                    board[x][y] = 0;
                }
            }
        }
    }

    private static void gameOfLifeHelper(int[][] board, Point p) {
        if (!isValidPoint(p, board)) {
            return;
        }
        if (willLive(p, board)) {
            if (board[p.x][p.y] != 1) {
                board[p.x][p.y] = 2;
            }
        } else {
            if (board[p.x][p.y] != 0) {
                board[p.x][p.y] = -1;
            }
        }
    }

    private static boolean willLive(Point p, int[][] board) {
        int liveNeighbours = liveNeighbors(board, p);
        if ((board[p.x][p.y] == 1 || board[p.x][p.y] == -1) && liveNeighbours < 2) {
            return false;
        }
        if ((board[p.x][p.y] == 1 || board[p.x][p.y] == -1) && (liveNeighbours == 2 || liveNeighbours == 3)) {
            return true;
        }
        if ((board[p.x][p.y] == 1 || board[p.x][p.y] == -1) && liveNeighbours > 3) {
            return false;
        }
        if ((board[p.x][p.y] == 0 || board[p.x][p.y] == 2) && liveNeighbours == 3) {
            return true;
        }
        return false;
    }

    private static boolean isValidPoint(Point p, int[][] board) {
        return !(p.x < 0 || p.x >= board.length || p.y < 0 || p.y >= board[0].length);
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

        public Point getRightUp() {
            return new Point(x + 1, y + 1);
        }

        public Point getRightDown() {
            return new Point(x + 1, y - 1);
        }

        public Point getLeftUp() {
            return new Point(x - 1, y + 1);
        }

        public Point getLeftDown() {
            return new Point(x - 1, y - 1);
        }

    }

    private static int liveNeighbors(int[][] board, Point p) {
        int count = 0;
        Point down = p.getDown();
        if (isValidPoint(down, board) && (board[down.x][down.y] == 1 || board[down.x][down.y] == -1)) {
            count++;
        }
        Point up = p.getUp();
        if (isValidPoint(up, board) && (board[up.x][up.y] == 1 || board[up.x][up.y] == -1)) {
            count++;
        }
        Point left = p.getLeft();
        if (isValidPoint(left, board) && (board[left.x][left.y] == 1 || board[left.x][left.y] == -1)) {
            count++;
        }
        Point right = p.getRight();
        if (isValidPoint(right, board) && (board[right.x][right.y] == 1 || board[right.x][right.y] == -1)) {
            count++;
        }
        Point rightUp = p.getRightUp();
        if (isValidPoint(rightUp, board) && (board[rightUp.x][rightUp.y] == 1 || board[rightUp.x][rightUp.y] == -1)) {
            count++;
        }
        Point rightDown = p.getRightDown();
        if (isValidPoint(rightDown, board) && (board[rightDown.x][rightDown.y] == 1 || board[rightDown.x][rightDown.y] == -1)) {
            count++;
        }
        Point leftUp = p.getLeftUp();
        if (isValidPoint(leftUp, board) && (board[leftUp.x][leftUp.y] == 1 || board[leftUp.x][leftUp.y] == -1)) {
            count++;
        }
        Point leftDown = p.getLeftDown();
        if (isValidPoint(leftDown, board) && (board[leftDown.x][leftDown.y] == 1 || board[leftDown.x][leftDown.y] == -1)) {
            count++;
        }
        return count;
    }

}
