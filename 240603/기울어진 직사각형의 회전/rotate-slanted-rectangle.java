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

        switch(dir){
            case 0:
                rotate0(r, c, m1, m2, m3, m4);
                break;
            case 1:
                rotate1(r, c, m1, m2, m3, m4);
                break;
        }

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
        for(int i = 0 ; i < m2 ; i++){
            board[nowR][nowC] = board[nowR+1][nowC+1];
            nowR++; nowC++;
        }
        board[r-m1-1][c+m1-1] = temp1;      // 2번 방향 완료.

        nowR = r-m1-m2+m3; nowC = c+m1-m2-m3; // 3번 방향의 마지막 지점.
        for(int i = 0 ; i < m3 ; i++){
            board[nowR][nowC] = board[nowR-1][nowC+1];
            nowR--; nowC++;
        }
        board[r-m1-m2+1][c+m1-m2-1] = temp2;     // 3번 방향 완료.

        nowR = r-1; nowC = c-1; // 4번 방향의 마지막 지점에서 4번방향의 반대 방향으로 한 칸 나아간 지점.
        for(int i = 0 ; i < m4-1 ; i++){
            board[nowR][nowC] = board[nowR-1][nowC-1];
            nowR--; nowC--;
        }
        board[r-m1-m2+m3+1][c+m1-m2-m3+1] = temp3;
    }

    public static void rotate1(int r, int c, int m1, int m2, int m3, int m4){   // 시계 방향으로 회전
        // 방향이 반대이므로, 그림의 방향을 그대로 썼던 rotate0과 달리 직접 방향 정의를 해줘야함.
        // 나의 정의 : 2 => 1 => 4 => 3의 순서로 가야함.
        int temp1 = board[r-m1][c+m1]; // 1번 방향의 마지막 지점. 예시 기준 4.
        int temp2 = board[r-m1-m2][c+m1-m2]; // 2번 방향의 마지막 지점. 예시 기준 2.
        int temp3 = board[r-m1-m2+m3][c+m1-m2-m3]; // 3번 방향의 마지막 지점. 예시 기준 1.
        int temp4 = board[r-m1-m2+m3+m4][c+m1-m2-m3+m4]; // 4번 방향의 마지막 지점, 즉 원점. 예시 기준 2.
        
        int nowR = r-m1, nowC = c+m1;       // 2의 마지막 점. 즉, 원래 1번 방향의 마지막 점.
        for(int i = 0 ; i < m2 ; i++){
            board[nowR][nowC] = board[nowR-1][nowC-1];
            nowR--; nowC--;
        }
        board[r-m1-m2][c+m1-m2] = board[r-m1-m2+1][c+m1-m2-1];      // 2 완료.

        nowR = r; nowC = c;           // 1의 마지막점. 즉, 원점.
        for(int i = 0 ; i < m1 ; i++){
            board[nowR][nowC] = board[nowR-1][nowC+1];
            nowR--; nowC++;
        }
        board[r-m1+1][c+m1-1] = temp1;      // 1 완료.

        nowR = r-m1-m2+m3; nowC = c+m1-m2-m3;      // 4의 마지막점. 즉, 원래 3번 방향의 마지막 점.
        for(int i = 0 ; i < m4 ; i++){
            board[nowR][nowC] = board[nowR+1][nowC+1];
            nowR++; nowC++;
        }
        board[r-1][c-1] = temp4;      // 4 완료.

        nowR = r-m1-m2+1; nowC = c+m1-m2-1;  // 3의 마지막점에서 반대로 한 칸 나아간 지점. 즉, 원래 2번 방향의 마지막 점에서 3번 방향으로 한 칸 나아간 점.
        for(int i = 0 ; i < m3-1 ; i++){
            board[nowR][nowC] = board[nowR+1][nowC-1];
            nowR++; nowC--;
        }
        board[r-m1-m2+1][c+m1-m2-1] = temp3; // 3완료.
    }
}