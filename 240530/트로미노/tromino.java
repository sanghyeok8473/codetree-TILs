import java.util.Scanner;
import java.util.*;

public class Main {
    public static int[][] board = new int [200][200];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                board[i][j] = sc.nextInt();
            }
        }
        // 입력 파트
        int max = 0;

        for(int i = 0 ; i <= n-2 ; i++){
            for(int j = 0 ; j <= m-2 ; j++){
                max = Math.max(max, returnMax(i, j));
            }
        }

        for(int i = 0 ; i < n ; i++){                   // 1*3 모양
            for(int j = 0 ; j <= m-3 ; j++){
                max = Math.max(max, (board[i][j] + board[i][j+1] + board[i][j+2]));
            }
        }

        for(int j = 0 ; j < m ; j++){                   // 3*1 모양
            for(int i = 0 ; i <= n-3 ; i++){
                max = Math.max(max, (board[i][j] + board[i+1][j] + board[i+2][j]));
            }
        }

        System.out.print(max);
    }

    public static int returnMax (int x, int y){ // 첫 번째 블록에서의 최대값 반환
        int maxSum = (board[x][y] + board[x+1][y] + board[x][y+1] + board[x+1][y+1]);
        int answer = 0;
        for(int i = x ; i < x+2 ; i++){
            for(int j = y ; j < y+2 ; j++){
                int nowSum = maxSum - board[i][j];
                answer = Math.max(answer, nowSum);
            }
        }
        return answer;
    }
}

// 첫 번째 블록을 자유롭게 회전하거나 뒤집을 수 있다 -> 어차피 최대 결과를 출력하기 때문에, 2*2영역에서 최소값을 빼버리면 됨.
// 두 번째 블록을 자유롭게 회전하거나 뒤집을 수 있다 -> 어차피 1*3 아니면 3*1임.