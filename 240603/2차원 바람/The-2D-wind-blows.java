import java.util.Scanner;
import java.util.*;

public class Main {
    public static int[][] board;
    public static int[] r1, c1, r2, c2;
    public static int totalMax = -1, n, m, q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt(); q = sc.nextInt(); board = new int[n][m];
        r1 = new int[q]; c1 = new int[q]; r2 = new int[q]; c2 = new int[q]; 
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                board[i][j] = sc.nextInt();
            }
        }  

        for(int i = 0 ; i < q ; i++){
            r1[i] = sc.nextInt(); c1[i] = sc.nextInt();
            r2[i] = sc.nextInt(); c2[i] = sc.nextInt();
            r1[i]--; c1[i]--; r2[i]--; c2[i]--; 
        }   // 입력 파트

        for(int i = 0 ; i < q ; i++){
            wind(r1[i], c1[i], r2[i], c2[i]);
            changeAvg(r1[i], c1[i], r2[i], c2[i]);
        }   

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }  // 출력 파트
    }

    public static void wind(int r1, int c1, int r2, int c2){
        int temp1 = board[r1+1][c1]; int temp2 = board[r1][c2]; 
        int temp3 = board[r2][c2]; int temp4 = board[r2][c1];

        for(int j = c2 ; j > c1 ; j--){
            board[r1][j] = board[r1][j-1];
        }
        board[r1][c1] = board[r1+1][c1];
        
        for(int i = r2 ; i > r1+1 ; i--){
            board[i][c2] = board[i-1][c2];
        }
        board[r1+1][c2] = temp2;

        for(int j = c1 ; j < c2-1 ; j++){
            board[r2][j] = board[r2][j+1];
        }
        board[r2][c2-1] = temp3;
        
        for(int i = r1+1 ; i <= r2-1 ; i++){
            board[i][c1] = board[i+1][c1];
        }
        board[r2-1][c1] = temp4;
    }

    public static void changeAvg(int r1, int c1, int r2, int c2){
        int[][] avg = new int[n][m];

        for(int i = r1 ; i <= r2 ; i++){
            for(int j = c1 ; j <= c2 ; j++){
                int cnt = cntValid(i, j);
                avg[i][j] = returnSum(i, j)/cnt;
            }
        }

        for(int i = r1 ; i <= r2 ; i++){
            for(int j = c1 ; j <= c2 ; j++){
                 board[i][j] = avg[i][j];
            }
        }
    }

    public static int cntValid(int x, int y){
        int nowCnt = 1;
        if((x-1 >= 0 && x-1 < n) && (y >= 0 && y < m))
            nowCnt++;
        if((x+1 >= 0 && x+1 < n) && (y >= 0 && y < m))
            nowCnt++;
        if((x >= 0 && x < n) && (y+1 >= 0 && y+1 < m))
            nowCnt++;
        if((x >= 0 && x < n) && (y-1 >= 0 && y-1 < m))
            nowCnt++; 

        return nowCnt;
    }

    public static int returnSum(int x, int y){
        int nowSum = board[x][y];
        if((x-1 >= 0 && x-1 < n) && (y >= 0 && y < m))
            nowSum += board[x-1][y];
        if((x+1 >= 0 && x+1 < n) && (y >= 0 && y < m))
            nowSum += board[x+1][y];
        if((x >= 0 && x < n) && (y+1 >= 0 && y+1 < m))
            nowSum += board[x][y+1];
        if((x >= 0 && x < n) && (y-1 >= 0 && y-1 < m))
            nowSum += board[x][y-1];

        return nowSum;
    }

}