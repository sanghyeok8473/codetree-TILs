import java.util.Scanner;
import java.util.*;

public class Main {
    public static int[][] board;
    public static int totalMax = -1, n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        boolean allMinus = true;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                board[i][j] = sc.nextInt();
            }
        }    // 입력 파트

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                for(int k = i ; k < n ; k++){
                    for(int q = j ; q < m ; q++){
                        if(plusRec(i, j, k, q)){
                            totalMax = Math.max(totalMax, sizeRec(i, j, k, q));
                        }
                    }
                }
            }
        }
       

        System.out.print(totalMax);
    }

    public static boolean plusRec(int x1, int y1, int x2, int y2){ // x1, y1은 왼쪽 위 시작점, x2,y2는 오른쪽 아래 끝점
        for(int i = x1 ; i <= x2 ; i++){
            for(int j = y1 ; j <= y2 ; j++){
                if(board[i][j] <= 0)
                    return false;
            }
        }
        return true;
    }

    public static int sizeRec(int x1, int y1, int x2, int y2){ // x1, y1은 왼쪽 위 시작점, x2,y2는 오른쪽 아래 끝점
        return (x2-x1+1)*(y2-y1+1);
    }

}