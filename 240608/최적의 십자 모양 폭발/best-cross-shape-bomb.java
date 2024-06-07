import java.util.Scanner;
import java.util.*;

public class Main {
    public static int n, max = 0;
    public static int[][] board, temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); board = new int[n][n];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                board[i][j] = sc.nextInt();
        // 입력 파트

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                temp = copy(board);
                temp = boom(temp, i, j);
                temp = gravity(temp);
                int nowComb = rowComb(temp) + colComb(temp);
                max = Math.max(nowComb, max);
            }
        }
        System.out.print(max);
        
    }
    public static int rowComb(int[][] brd){
        int comb = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n-1 ; j++){
                if(brd[i][j] == brd[i][j+1] && brd[i][j] != 0)
                    comb++;
            }
        }
        return comb;
    }

    public static int colComb(int[][] brd){
        int comb = 0;
        for(int j = 0 ; j < n ; j++){
            for(int i = 0 ; i < n-1 ; i++){
                if(brd[i][j] == brd[i+1][j] && brd[i][j] != 0)
                    comb++;
            }
        }
        return comb;
    }

    public static int[][] boom(int[][] brd, int r, int c){
        int cnt = brd[r][c];
        brd[r][c] = 0;
        for(int i = 1 ; i < cnt ; i++){
            if(rangeValid(r-i, c))
                brd[r-i][c] = 0;
            if(rangeValid(r+i, c))
                brd[r+i][c] = 0;
            if(rangeValid(r, c-i))
                brd[r][c-i] = 0;
            if(rangeValid(r, c+i))
                brd[r][c+i] = 0;
        }
        return brd;
    }

    public static int[][] gravity(int[][] brd){
        int[][] tmp = new int[n][n];
        for(int j = 0 ; j < n ; j++){
            int endIdx = n-1; 
            for( int i = n-1 ; i >= 0 ; i--){
                if(brd[i][j] != 0){
                    tmp[endIdx][j] = brd[i][j];
                    endIdx--;
                }
            }
        }
        return tmp;
    }

    public static int[][] copy(int[][] brd){
        int[][] temp = new int[n][n];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                temp[i][j] = brd[i][j];
        return temp;
    }

    public static boolean rangeValid(int r, int c){
        return(r >= 0 && r < n && c >= 0 && c < n);
    }

}