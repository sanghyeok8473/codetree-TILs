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
        currX = r; currY = c;       // 값의 비교에 따라 변화될 좌표를 설정.
        answer[idx] = board[r][c];  // 이동 경로를 담아줄 1차원 배열
         // 이동이 멈추는 조건은 더 이상 나아갈 곳이 없을 때. 그 여부는, move함수에서 판단할 것임.
            move(currX, currY);
        
    }
    public static void move(int row, int col){
        while(true){
        boolean none = true;
        for(int i = 0 ; i < 4 ; i++){
            int nowX = row + dx[i], nowY = col + dy[i];
            if(inRange(nowX, nowY) && board[nowX][nowY] > board[row][col]){
                currX = nowX; currY = nowY; idx++;
                answer[idx] = board[currX][currY];
                none = false; break;
            }
        }
        if(none){           // none이 여전이 true면, 4방향 모두 값이 currX,currY 이하라는 의미임. 그러면 지금까지의 이동경로 출력 후 종료.
            printAns();
            break;
        }
        }
    }

    public static boolean inRange(int row, int col){            // 받은 좌표 값이 범위 내의 좌표인지 판단
        return (row >= 0 && row < n && col >= 0 && col < n);
    }

    public static void printAns(){              // 어떠한 이유로든 종료가 되면, 정답을 출력. idx와 answer배열 모두 전역변수이므로 문제없음.
        for(int i = 0 ; i <= idx ; i++)
            System.out.print(answer[i]+" ");
    }
}