import java.util.Scanner;
import java.util.*;

public class Main {
    public static int n, m, r, c, nowUp = 1, nowFront = 2, nowRight = 3;
    public static int[][] board;
    public static char[] roll;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        n = sc.nextInt(); m = sc.nextInt(); r = sc.nextInt(); c = sc.nextInt(); r--; c--;
        board = new int[n][n]; roll = new char[m];
        for(int i = 0 ; i < m ; i++)
            roll[i] = sc.next().charAt(0);
        // 입력 파트
        board[r][c] = 6;

        for(int i = 0 ; i < m ; i++){
            move(roll[i]);
        }

        int sum = 0;
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                sum += board[i][j];
        System.out.println(sum);
        
    }
    public static void move(char dir){
        switch(dir){
            case 'L':
                if(inRange(r, c-1)){
                    board[r][c-1] = 7 - nowRight;
                    int temp = 7 - nowUp;
                    nowUp = nowRight;
                    nowRight = temp;
                    c--;
                }
                break;
            case 'R':
                if(inRange(r, c+1)){
                    board[r][c+1] = nowRight;
                    int temp = 7 - nowRight;
                    nowRight = nowUp;
                    nowUp = temp;
                    c++;
                }
                break;
            case 'U':
                if(inRange(r-1, c)){
                    board[r-1][c] = 7 - nowFront;
                    int temp = 7 - nowUp;
                    nowUp = nowFront;
                    nowFront = temp;
                    r--;
                }
                break;
            case 'D':
                if(inRange(r+1, c)){
                    board[r+1][c] = nowFront;
                    int temp = nowUp;
                    nowUp = 7 - nowFront;
                    nowFront = temp;
                    r++;
                }
                break;
        }
    }

    public static boolean inRange(int row, int col){            // 받은 좌표 값이 범위 내의 좌표인지 판단
        return (row >= 0 && row < n && col >= 0 && col < n);
    }
}