import java.util.Scanner;
import java.util.*;

public class Main {
    public static int[][] board;
    public static int totalMax = -1, n, t;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        t = sc.nextInt();
        board = new int[3][n];
        
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = sc.nextInt();
            }
        }  

        for(int sec = 0 ; sec < t ; sec++){
            int temp1 = board[0][n-1];
            int temp2 = board[1][n-1];
            int temp3 = board[2][n-1];

            for(int i = 0 ; i < 3 ; i++){
                for(int j = n-1; j >= 1 ; j--)
                    board[i][j] = board[i][j-1];
            }

                
            board[1][0] = temp1;
            board[2][0] = temp2;
            board[0][0] = temp3;
        }

        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }  
    }
}