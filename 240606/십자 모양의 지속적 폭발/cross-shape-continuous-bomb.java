import java.util.Scanner;
import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] board, temp;
    public static int[] c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        n = sc.nextInt(); m = sc.nextInt(); board = new int[n][n]; c = new int[m];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                board[i][j] = sc.nextInt();

        for(int i = 0 ; i < m ; i++){
            c[i] = sc.nextInt();
            c[i]--;
        }
        // 입력 파트

        for(int j = 0 ; j < m ; j++){
            int nowCol = c[j];
            for(int i = 0 ; i < n ; i++){
                if(board[i][nowCol] != 0){
                    explosion(i, c[j]);
                    break;
                }
            }
            board = gravity();
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
    public static void explosion(int row, int col){
        int cnt = board[row][col];
        board[row][col] = 0;
        for(int i = 1 ; i < cnt ; i++){
            if(rangeValid(row-i, col))
                board[row-i][col] = 0;
            if(rangeValid(row+i, col))
                board[row+i][col] = 0;
            if(rangeValid(row, col-i))
                board[row][col-i] = 0;
            if(rangeValid(row, col+i))
                board[row][col+i] = 0;
        }
    }

    public static int[][] gravity(){
        temp = new int[n][n];
        for(int j = 0 ; j < n ; j++){
            int tempIdx = n-1;
            for(int i = n-1 ; i >= 0 ; i--){
                if(board[i][j] != 0){
                    temp[tempIdx][j] = board[i][j];
                    tempIdx--;
                }
            }
        }
        return temp;
    }

    public static boolean rangeValid(int row, int col){
        return (row >= 0 && row < n && col >= 0 && col < n);
    }
    
}