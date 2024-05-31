import java.util.Scanner;

public class Main {
    public static int[][] board = new int[20][20];
    public static int totalMax = 0, n = 0;

    public static int[] dx = {-1, -1, 1, 1};
    public static int[] dy = {1, -1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // Iterate over all possible starting points
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < n - 1; j++) {
                totalMax = Math.max(totalMax, returnSum(i, j));
            }
        }
        System.out.print(totalMax);
    }

    public static int returnSum(int i, int j) {
        int idx = 0, sum = 0;
        int x = i, y = j;

        while (true) {
            sum += board[x][y];
            if (returnOut(x, y, 1)) {
                idx++;
                if (idx == 4) break; // Exit if we complete the rectangle
                x += dx[idx];
                y += dy[idx];
                break;
            }
            x += dx[idx];
            y += dy[idx];
        }

        while (true) {
            sum += board[x][y];
            if (returnOut(x, y, 2)) {
                idx++;
                if (idx == 4) break; // Exit if we complete the rectangle
                x += dx[idx];
                y += dy[idx];
                break;
            }
            x += dx[idx];
            y += dy[idx];
        }

        while (true) {
            sum += board[x][y];
            if (returnOut(x, y, 3)) {
                idx++;
                if (idx == 4) break; // Exit if we complete the rectangle
                x += dx[idx];
                y += dy[idx];
                break;
            }
            x += dx[idx];
            y += dy[idx];
        }

        while (true) {
            if (x == i && y == j) {
                break;
            }
            if (x < 0 || x >= n || y < 0 || y >= n) {
                return 0; // Invalid rectangle if out of bounds
            }
            sum += board[x][y];
            x += dx[idx];
            y += dy[idx];
        }

        return sum;
    }

    public static boolean returnOut(int x, int y, int k) {
        switch (k) {
            case 1:
                if (x < 0 || y >= n) return true;
                break;
            case 2:
                if (x < 0 || y < 0) return true;
                break;
            case 3:
                if (x >= n || y < 0) return true;
                break;
        }
        return false;
    }
}