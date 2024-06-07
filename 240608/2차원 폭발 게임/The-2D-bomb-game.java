import java.util.Scanner;
import java.util.*;

public class Main {
    public static int n, m, k, cnt = 0;
    public static int[][] board, temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt(); board = new int[n][n];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                board[i][j] = sc.nextInt();
        // 입력 파트

        if(m == 1){     // 1개 이상이면 전부 다 터지게 됨.
            System.out.print(0);
            System.exit(0);
        }

        for(int c = 0 ; c < k ; c++){
            boom();
            board = rotate();
            board = gravity();
        }
        boom();
        
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                if(board[i][j] != 0)
                    cnt++;
        System.out.println(cnt);
    }

    public static void boom(){
        // 연속 m개 이상인 숫자의 경우 모두 0으로 바꿔주는 부분
        boolean noMoreBoom = false;
        while(!noMoreBoom){
            noMoreBoom = true;
            for(int j = 0 ; j < n ; j++){ 
                for(int i = 0 ; i < n-1 ; i++){
                    if(board[i][j] == 0)
                        continue;
                    int endIdx = getEndIdxOfExplosion(i, j, board[i][j]);
                    if(endIdx - i  + 1 >= m){
                        fillZero(j, i, endIdx);
                        noMoreBoom = false;
                    }
                }
            }
            //중력에 의해 내려오는 부분
            board = gravity();
        }
    }

    public static int[][] rotate(){
        temp = new int[n][n];
        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = 0 ; j < n ; j++){
                temp[j][n-1-i] = board[i][j];
            }
        }
        return temp;
    }

    public static int[][] gravity(){
        int[][] temp = new int[n][n];
        for(int j = 0 ; j < n ; j++){
            int endIdx = n-1; 
            for( int i = n-1 ; i >= 0 ; i--){
                if(board[i][j] != 0){
                    temp[endIdx][j] = board[i][j];
                    endIdx--;
                }
            }
        }
        return temp;
    }

    public static int getEndIdxOfExplosion(int r, int c, int currNum) {
        int endIdx = r + 1;
        while(endIdx < n) {
            if(board[endIdx][c] == currNum)
                endIdx++;
            else{
                break;
            }
        }
    
        return endIdx - 1;
    }

    public static void fillZero(int row, int startIdx, int endIdx) {
        for(int i = startIdx; i <= endIdx; i++) {
            board[i][row] = 0;
        }
    }
}