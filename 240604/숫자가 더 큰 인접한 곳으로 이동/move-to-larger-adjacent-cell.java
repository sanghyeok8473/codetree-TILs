import java.util.Scanner;
import java.util.*;

public class Main {
    public static int n, r, c, currX, currY, idx = 0;
    public static int[][] board, temp;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
                            // 상 하 좌 우
    public static int[] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        n = sc.nextInt(); r = sc.nextInt(); c = sc.nextInt();
        r--; c--; board = new int[n][n]; answer = new int[n*n];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                board[i][j] = sc.nextInt();
         // 입력 파트
        currX = r; currY = c;
        answer[idx] = board[r][c];
        while(inRange(currX, currY)){
            move(currX, currY);
        }
        printAns();
    }
    public static void move(int row, int col){
        boolean none = true;
        for(int i = 0 ; i < 4 ; i++){
            int nowX = row + dx[i], nowY = col + dy[i];
            if(inRange(nowX, nowY) && board[nowX][nowY] > board[row][col]){
                currX = nowX; currY = nowY; idx++;
                answer[idx] = board[currX][currY];
                none = false; break;
            }
        }
        if(none){
            printAns();
            System.exit(0);
        }
    }

    public static boolean inRange(int row, int col){
        return (row >= 0 && row < n && col >= 0 && col < n);
    }

    public static void printAns(){
        for(int i = 0 ; i <= idx ; i++)
            System.out.print(answer[i]+" ");
    }
}