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
        board = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = sc.nextInt();
            }
        }
        // 입력 파트
        
        for(int i = 2 ; i < n ; i++){           //i,j는 시작점.
            for(int j = 1 ; j < n-1 ; j++){
                totalMax = Math.max(totalMax, returnMax(i, j));
            }
        }
        System.out.print(totalMax);
    }

    public static int returnMax (int x, int y){     // 시작점이 x,y인 좌표를 받으면 최대의 기울어진 직사각형을 만들어서 그 변의 합을 반환
        int max = 0;

        for(int len13 = 1 ; len13 < n-1 ; len13++){
            if(outRange(x-len13, y+len13))
                continue;
            for(int len24 = 1 ; len24 < n-1 ; len24++){
                if(outRange(x-len13-len24, y+len13-len24))
                    continue;
                max = Math.max(max, returnSum(x, y, len13, len24));
            }    
        }

        

       return max;
    }
    // 굳이 격자의 끝까지 가는 것 만이 최대 값이 나오는게 아님. 즉, 변의 길이는 격자의 끝이 닿을 때까지 가는 것이 아닌, 모든 경우의 수를 계산해야함.
    // 직사각형 모양이므로, 1,3번과 2,4번의 길이는 같음. 즉 길이 변수는 총 2개면 충분.
    // 길이의 최대값은 n-1. 만약 길이가 n이면 정사각형의 대각선 길이와 같으므로 절대 직사각형이 나올 수 없음

    public static int returnSum(int x1, int y1, int len1, int len2){      // 시작점과 두 변의 길이가 주어지면 합을 구하는 함수.
        int sum = 0, idx = 0;
        int x = x1, y = y1;

        for(int i = 0 ; i < len1 ; i++){
            if(outRange(x,y))
                return 0;
            sum += board[x][y];
            x += dx[idx]; y += dy[idx];
        }
        idx++;

        for(int i = 0 ; i < len2 ; i++){
            if(outRange(x,y))
                return 0;
            sum += board[x][y];
            x += dx[idx]; y += dy[idx];
        }
        idx++;

        for(int i = 0 ; i < len1 ; i++){
            if(outRange(x,y))
                return 0;
            sum += board[x][y];
            x += dx[idx]; y += dy[idx];
        }
        idx++;

        for(int i = 0 ; i < len1 ; i++){
            if(outRange(x,y))
                return 0;
            if(x==x1 && y==y1)
                break;
            sum += board[x][y];
            x += dx[idx]; y += dy[idx];
        }
        
        return sum;
    }

    public static boolean outRange(int x, int y){
        return (x < 0 || x >= n || y < 0 || y >= n);
    }
    
}