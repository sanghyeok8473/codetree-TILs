import java.util.Scanner;
import java.util.*;

public class Main {
    public static int n, r, c;
    public static int[][] board, temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        n = sc.nextInt(); board = new int[n][n]; temp = new int[n][n];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                board[i][j] = sc.nextInt();
        r = sc.nextInt(); c = sc.nextInt();
        r--; c--; // 입력 파트

        explosion(r, c);
        gravity();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++)
                System.out.print(temp[i][j] + " ");
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

    public static void gravity(){
        for(int j = 0 ; j < n ; j++){
            int tempIdx = n-1;
            for(int i = n-1 ; i >= 0 ; i--){
                if(board[i][j] != 0){
                    temp[tempIdx][j] = board[i][j];
                    tempIdx--;
                }
            }
        }
    }

    public static boolean rangeValid(int row, int col){
        return (row >= 0 && row < n && col >= 0 && col < n);
    }
    
}