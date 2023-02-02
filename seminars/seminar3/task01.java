package seminars.seminar3;

public class task01 {
    public static void main(String[] args) {
        import java.util.LinkedList;

public class WaveAlgorithm {
    static int ROW = 10;
    static int COL = 10;

    static class Cell {
        int x, y;
        int dist;

        public Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    };

    static boolean isValid(int row, int col) {
        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL);
    }

    static int BFS(int mat[][], int srcX, int srcY,
                   int destX, int destY) {
        boolean[][] visited = new boolean[ROW][COL];

        LinkedList<Cell> q = new LinkedList<>();
        visited[srcX][srcY] = true;
        q.add(new Cell(srcX, srcY, 0));

        int[] rowNum = {-1, 0, 0, 1};
        int[] colNum = {0, -1, 1, 0};

        while (!q.isEmpty()) {
            Cell curr = q.poll();

            if (curr.x == destX && curr.y == destY) {
                return curr.dist;
            }

            for (int i = 0; i < 4; i++) {
                int row = curr.x + rowNum[i];
                int col = curr.y + colNum[i];

                if (isValid(row, col) && mat[row][col] == 1 &&
                        !visited[row][col]) {
                    visited[row][col] = true;
                    q.add(new Cell(row, col, curr.dist + 1));
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1},
                    {1, 0, 1, 0, 0, 0, 0, 0, 0, 1},
                    {1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
                    {1, 0, 0, 1, 1, 1, 0, 1, 0, 1},
                    {1, 0, 1, 1, 0, 0, 1, 1, 1, 1},
                    {1, 1, 0, 0, 1, 1, 0, 0, 0, 1},
                    {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
            };
            int destX = 9, destY = 9;
            int srcX = 0, srcY = 0;
            System.out.println("Minimum number of steps required is: " +
                    BFS(mat, srcX, srcY, destX, destY));
        }
    }
    
    }
}
