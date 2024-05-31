import java.util.Scanner;
import java.util.*;

public class Main {
    public static int[][] board = new int [20][20];
    public static int totalMax = 0, n = 0;

    public static int[] dx = {-1, -1, +1, +1};
    public static int[] dy = {+1, -1, -1, +1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = sc.nextInt();
            }
        }
        // 입력 파트
        
        for(int i = 2 ; i < n ; i++){           //i,j는 시작점.
            for(int j = 1 ; j < n-1 ; j++){
                totalMax = Math.max(totalMax, returnSum(i, j));
            }
        }
        System.out.print(totalMax);
    }

    public static int returnSum (int i, int j){     // 시작점이 x,y인 좌표를 받으면 최대의 기울어진 직사각형을 만들어서 그 변의 합을 반환
        int idx = 0, sum = 0;
        int x = i, y = j;

        while(true){
            sum += board[x][y];
            if(returnOut(x, y, 1)){
                idx++; 
                x += dx[idx]; y += dy[idx];
                break;
            }
            x += dx[idx]; y += dy[idx];
        }

        while(true){
            sum += board[x][y];
            if(returnOut(x, y, 2)){
                idx++; 
                x += dx[idx]; y += dy[idx];
                break;
            }
            x += dx[idx]; y += dy[idx];
        }

        while(true){
            sum += board[x][y];
            if(returnOut(x, y, 3)){
                idx++; 
                x += dx[idx]; y += dy[idx];
                break;
            }
            x += dx[idx]; y += dy[idx];
        }

        while(true){
            if(x == i && y == j)
                break;
            if (x < 0 || x >= n || y < 0 || y >= n) { // 배열 범위를 벗어나지 않도록 체크
                return 0; // 유효하지 않은 경우 0을 반환
            }
            sum += board[x][y];
            x += dx[idx]; y += dy[idx];
        }

       return sum;
    }

    public static boolean returnOut(int x, int y, int k){
        switch(k){
            case 1:
                if(x == 1 || y == n-1)
                    return true;
                break;
            case 2:
                if(x == 0 || y == 0)
                    return true;
                break;
            case 3:
                if(x == n-1 || y == 0)
                    return true;
                break;
        }

        return false;
    }
}