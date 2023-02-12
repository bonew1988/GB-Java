package HW.HW4;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Алгоритм волновоой трассировки (волновой алгоритм, алгоритм Ли) — алгоритм
 * поиска пути,
 * алгоритм поиска кратчайшего пути на планарном графе.
 * Принадлежит к алгоритмам, основанным на методах поиска в ширину.
 */
class Node {
    int x, y, dist;

    Node(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

class Main {

    private static final int[] row = { -1, 0, 0, 1 };
    private static final int[] col = { 0, -1, 1, 0 };

    public static void main(String[] args) {
        int[][] mat = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 0, 0, 0, 0, 1, 1, 1, 0 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        };

        var cat = new Point2D(1, 1);
        var exit = new Point2D(6, 6);
        mat[cat.x][cat.y] = -1;
        System.out.println(new MapPrinter().mapColor(mat));
        int min_dist = findShortestPathLength(mat, cat.x, cat.y, exit.x, exit.y);

        if (min_dist != -1) {
            System.out.println("Кратчайший путь от источника к месту назначения " +
                    "имеет длину " + min_dist);
        } else {
            System.out.println("Пункт назначения не может быть достигнут из источника");
        }
    }

    private static boolean isValid(int[][] mat, boolean[][] visited, int row, int col) {
        return (row >= 0) && (row < mat.length) && (col >= 0) && (col < mat[0].length)
                && mat[row][col] == 1 && !visited[row][col];
    }

    private static int findShortestPathLength(int[][] mat, int i, int j, int x, int y) {
        if (mat == null || mat.length == 0 || mat[i][j] == 0 || mat[x][y] == 0) {
            return -1;
        }

        int M = mat.length;
        int N = mat[0].length;

        boolean[][] visited = new boolean[M][N];

        Queue<Node> q = new ArrayDeque<>();

        visited[i][j] = true;
        q.add(new Node(i, j, 0));

        int min_dist = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node node = q.poll();

            i = node.x;
            j = node.y;
            int dist = node.dist;

            if (i == x && j == y) {
                min_dist = dist;
                break;
            }

            for (int k = 0; k < 4; k++) {
                if (isValid(mat, visited, i + row[k], j + col[k])) {
                    visited[i + row[k]][j + col[k]] = true;
                    q.add(new Node(i + row[k], j + col[k], dist + 1));
                }
            }
        }

        if (min_dist != Integer.MAX_VALUE) {
            return min_dist;
        }
        return -1;
    }
}

class MapPrinter {

    public String rawData(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                sb.append(String.format("%5d", map[row][col]));
            }
            sb.append("\n");
        }
        for (int i = 0; i < 3; i++) {
            sb.append("\n");
        }

        return sb.toString();
    }

    public String mapColor(int[][] map) {
        StringBuilder sb = new StringBuilder();

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                switch (map[row][col]) {
                    case 0:
                        sb.append("🔶");
                        break;
                    case -1:
                        sb.append("🐈");
                        break;
                    case -2:
                        sb.append("E ");
                        break;
                    default:
                        sb.append("  ");
                        break;
                }
            }
            sb.append("\n");
        }
        for (int i = 0; i < 3; i++) {
            sb.append("\n");
        }
        return sb.toString();
    }
}

class Point2D {
    int x, y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return String.format("x: %d  y: %d", x, y);
    }

    @Override
    public boolean equals(Object obj) {
        Point2D t = (Point2D) obj;
        return this.x == t.x && this.y == t.y;
    }
}