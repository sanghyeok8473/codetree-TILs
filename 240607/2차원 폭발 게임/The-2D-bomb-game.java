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

        while(!noMoreBoom(board)){
            board = boom();
            board = rotate();
            board = gravity();
        }
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                if(board[i][j] != 0)
                    cnt++;
        System.out.println(cnt);
    }

    public static int[][] boom(){
        // 연속 m개 이상인 숫자의 경우 모두 0으로 바꿔주는 부분
        for(int j = 0 ; j < n ; j++){ 
            for(int i = 0 ; i < n-1 ; i++){
                int nowCnt = 1, endIdx = n-1;
                if(board[i][j] == board[i+1][j]){
                    for(int k = i+1 ; k < n ; k++){
                        if(board[k][j] != board[i][j]){
                            endIdx = k-1;
                            break;
                        }  
                        nowCnt++;
                    }
                    if(nowCnt >= m){
                        for(int k = i ; k <= endIdx ; k++){
                            board[k][j] = 0;
                        }
                    }
                }
            }
        }
        

        //중력에 의해 내려오는 부분
        temp = gravity();
        return temp;
    }
    
    public static boolean noMoreBoom(int[][] b){
        for(int j = 0 ; j < n ; j++){
            int[] count = new int[101];
            for(int i = 0 ; i < n ; i++){
                if(b[i][j] != 0)
                    count[b[i][j]]++;
            }
            Arrays.sort(count);
            if(count[100] >= m )
                return false;
            if(count[100] < m && j == n-1)
                return true;
        }
        return false;
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
}