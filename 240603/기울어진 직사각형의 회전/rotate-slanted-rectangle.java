import java.util.Scanner;
import java.util.*;

public class Main {
    public static int[][] board;
    public static int n, r, c, m1, m2, m3, m4, dir;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); board = new int[n][n];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = sc.nextInt();
            }
        }  
        r = sc.nextInt(); c = sc.nextInt(); m1 = sc.nextInt(); m2 = sc.nextInt();
        m3 = sc.nextInt(); m4 = sc.nextInt(); dir = sc.nextInt();   
        r--; c--; // 입력 파트

        if(dir == 0)
            rotate0(r, c, m1, m2, m3, m4);
        else
            rotate1(r, c, m1, m2, m3, m4);

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }  // 출력 파트
    }

    public static void rotate0(int r, int c, int m1, int m2, int m3, int m4){   // 반시계 방향으로 회전
        int temp1 = board[r-m1][c+m1]; // 1번 방향의 마지막 지점. 예시 기준 4.
        int temp2 = board[r-m1-m2][c+m1-m2]; // 2번 방향의 마지막 지점. 예시 기준 2.
        int temp3 = board[r-m1-m2+m3][c+m1-m2-m3]; // 3번 방향의 마지막 지점. 예시 기준 1.
        int temp4 = board[r-m1-m2+m3+m4][c+m1-m2-m3+m4]; // 4번 방향의 마지막 지점, 즉 원점. 예시 기준 2.
        
        int nowR = r-m1, nowC = c+m1;       // 1번 방향의 마지막 지점.
        for(int i = 0 ; i < m1 ; i++){
            board[nowR][nowC] = board[nowR+1][nowC-1];
            nowR++; nowC--;
        }
        board[r][c] = board[r-1][c-1];      // 1번 방향 완료.

        nowR = r-m1-m2; nowC = c+m1-m2;     // 2번 방향의 마지막 지점.
        for(int i = 0 ; i < m2-1 ; i++){
            board[nowR][nowC] = board[nowR+1][nowC+1];
            nowR++; nowC++;
        }
        board[r-m1-1][c+m1-1] = temp1;      // 2번 방향 완료.

        nowR = r-m1-m2+m3; nowC = c+m1-m2-m3; // 3번 방향의 마지막 지점.
        for(int i = 0 ; i < m3-1 ; i++){
            board[nowR][nowC] = board[nowR-1][nowC+1];
            nowR--; nowC++;
        }
        board[r-m1-m2+1][c+m1-m2-1] = temp2;     // 3번 방향 완료.

        nowR = r-1; nowC = c-1; // 4번 방향의 마지막 지점에서 4번방향의 반대 방향으로 한 칸 나아간 지점.
        for(int i = 0 ; i < m4-1 ; i++){
            board[nowR][nowC] = board[nowR-1][nowC-1];
            nowR--; nowC--;
        }
    }

    public static void rotate1(int r, int c, int m1, int m2, int m3, int m4){   // 시계 방향으로 회전
        int temp1 = board[r-m1][c+m1]; // 1번 방향의 마지막 지점. 예시 기준 4.
        int temp2 = board[r-m1-m2][c+m1-m2]; // 2번 방향의 마지막 지점. 예시 기준 2.
        int temp3 = board[r-m1-m2+m3][c+m1-m2-m3]; // 3번 방향의 마지막 지점. 예시 기준 1.
        int temp4 = board[r-m1-m2+m3+m4][c+m1-m2-m3+m4]; // 4번 방향의 마지막 지점, 즉 원점. 예시 기준 2.
        
        int nowR = r, nowC = c;       // 1번 방향의 마지막 지점.
        for(int i = 0 ; i < m1 ; i++){
            board[nowR][nowC] = board[nowR-1][nowC+1];
            nowR--; nowC++;
        }
        board[r-m1][c+m1] = board[r-m1-1][c+m1-1];      // 1번 방향 완료.

        nowR = r-m1-1; nowC = c+m1-1;           // 1번 방향의 마지막 지점에서 2번방향으로 한 칸 나아간 지점.
        for(int i = 0 ; i < m2-1 ; i++){
            board[nowR][nowC] = board[nowR-1][nowC-1];
            nowR--; nowC--;
        }
        board[r-m1-m2][c+m1-m2] = board[r-m1-m2+1][c+m1-m2-1];      // 2번 방향 완료.

        nowR = r-m1-m2+1; nowC = c+m1-m2-1;       // 2번 방향의 마지막 지점에서 3번방향으로 한 칸 나아간 지점.
        for(int i = 0 ; i < m3-1 ; i++){
            board[nowR][nowC] = board[nowR+1][nowC-1];
            nowR++; nowC--;
        }
        if(r-m1-m2+m3+1 == r)
            board[r-m1-m2+m3][c+m1-m2-m3] = temp4;     // 3번 방향 완료.
        else
            board[r-m1-m2+m3][c+m1-m2-m3] = board[r-m1-m2+m3+1][c+m1-m2-m3+1];     // 3번 방향 완료.

        nowR = r-m1-m2+m3+1; nowC = c+m1-m2-m3+1; // 3번 방향의 마지막 지점에서 4번방향으로 한 칸 나아간 지점.
        for(int i = 0 ; i < m4-1 ; i++){
            board[nowR][nowC] = board[nowR+1][nowC+1];
            nowR++; nowC++;
        }
    }
}