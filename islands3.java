import java.util.*;
import java.io.*;

public class islands3 {
    static int r, c;
    static boolean[][] visited;
    static char[][] grid;
    static int[][] direction = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstline = br.readLine().split(" ");
        r = Integer.parseInt(firstline[0]);
        c = Integer.parseInt(firstline[1]);

        grid = new char[r][c];

        for (int i = 0; i < r; i++) {
            String rows = br.readLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = rows.charAt(j);
            }
        }

        visited = new boolean[r][c];
        int count = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 'L' && !visited[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static void bfs(int i, int j) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(new Vertex(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Vertex next = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nextR = next.r + direction[k][0];
                int nextC = next.c + direction[k][1];
                if (nextR > -1 &&
                        nextC > -1 &&
                        nextR < r &&
                        nextC < c &&
                        grid[nextR][nextC] != 'W' &&
                        !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    queue.add(new Vertex(nextR, nextC));
                }
            }
        }
    }

    static boolean hasLandNeighbor(int i, int j) {
        for (int[] dir : direction) {
            int ni = i + dir[0], nj = j + dir[1];
            if (ni >= 0 && ni < r && nj >= 0 && nj < c && grid[ni][nj] == 'L') {
                return true;
            }
        }
        return false;
    }
}

class Vertex {
    int r;
    int c;

    Vertex(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
