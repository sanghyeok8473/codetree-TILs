import java.util.*;

public class Main {
    public static int n, m, r, c;
    public static int[][] board, temp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt(); r = sc.nextInt(); c = sc.nextInt(); r--; c--;
        board = new int[n][n]; temp = new int[n][n];

        int cnt = bomb(board, r, c);

        System.out.print(cnt);
    }

    public static int bomb(int[][] arr, int r, int c){
        board[r][c] = 1;  // 0초일 때
        temp = copy(board);
        for(int t = 1 ; t <= m ; t++){
            int itv = (int)Math.pow(2, t-1);
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(board[i][j] == 1 && rangeValid(i-itv, j))
                        temp[i-itv][j] = 1;
                    if(board[i][j] == 1 && rangeValid(i+itv, j))
                        temp[i+itv][j] = 1;
                    if(board[i][j] == 1 && rangeValid(i, j-itv))
                        temp[i][j-itv] = 1;
                    if(board[i][j] == 1 && rangeValid(i, j+itv))
                        temp[i][j+itv] = 1;
                }
            }
            board = copy(temp);
        }
        int count = 0;
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                count += board[i][j];
        return count;
    }

    public static boolean rangeValid(int r, int c){
        return (r >= 0 && r < n && c >= 0 && c < n);
    }

    public static int[][] copy(int[][] b){
        int[][] tmp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                tmp[i][j] = b[i][j];
            }
        }
        return tmp;
    }
}