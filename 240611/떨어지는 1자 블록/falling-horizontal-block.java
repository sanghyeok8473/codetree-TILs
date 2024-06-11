import java.util.Scanner;
import java.util.*;

public class Main {
    public static int n, m, k, first, end;
    public static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt(); k--;
        first = k;  end = m + k - 1; // first는 블럭의 시작점, end는 블럭의 끝점
        board = new int[n][n];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                board[i][j] = sc.nextInt();
        // 입력 파트

        
        move();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void move(){
        boolean none = true; // 1이 하나도 없음을 의미함.
        for(int i = 0 ; i < n ; i++){
            none = true;
            for(int j = first ; j <= end ; j++){
                if(board[i][j] == 1)
                    none = false;
            }
            if(none == false){
                for(int j = first ; j <= end ; j++){
                    board[i-1][j] = 1;
                }
                break;
            }
            else if(i == n-1){  // 내려가다가 끝까지 블록을 놓는 조건이 되면, 그 자리에 그냥 두면 됨.
                for(int j = first ; j <= end ; j++){
                    board[i][j] = 1;
                }
                break;
            }
        }
    }
}