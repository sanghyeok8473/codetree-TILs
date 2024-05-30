import java.util.Scanner;
import java.util.*;

public class Main {
    public static int[][] board = new int [20][20];
    public static int maxSum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = sc.nextInt();
            }
        }
        // 입력 파트

        for(int i = 0 ; i <= n-3 ; i++){
            for(int j = 0 ; j <= n-3 ; j++){
                int nowSum = returnSum(i,j);
                if(maxSum < nowSum)
                    maxSum = nowSum;
            }
        }
        System.out.print(maxSum);
    }

    public static int returnSum(int x, int y){
        int sum = 0;
        for(int i = x ; i <= x+2 ; i++){
            for(int j = y ; j <= y+2 ; j++){
                sum += board[i][j];
            }
        }
        return sum;
    }
}