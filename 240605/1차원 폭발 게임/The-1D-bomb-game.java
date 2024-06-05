import java.util.Scanner;
import java.util.*;

public class Main {
    public static int n, m, cnt;
    public static int[] board, temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt(); board = new int[n];
        for(int i = 0 ; i < n ; i++)
            board[i] = sc.nextInt();
        cnt = n;// 입력 파트

        if(m == 1){     // 1개 이상이면 전부 다 터지게 됨.
            System.out.print(0);
            System.exit(0);
        }

        while(!noMoreBoom(board)){
           board = boom();
        }

        System.out.println(cnt);
        for(int i = 0 ; i < cnt ; i++){
            System.out.println(board[i]);
        }
    }

    public static int[] boom(){
        int idx = cnt;
        for(int i = 0 ; i < idx-1 ; i++){
            int nowCnt = 1, endIdx = 0;
            if(board[i] == board[i+1]){
                endIdx = i+1;               // 최소 endIdx를 설정
                for(int j = i ; j < idx-1 ; j++){
                    if(board[j] != board[j+1]){
                        endIdx = j;
                        break;
                    }
                    nowCnt++;
                }
            }
            if(nowCnt >= m){
                for(int k = i ; k <= endIdx ; k++){
                    board[k] = 0;
                }
                cnt -= nowCnt;
                i = endIdx;
            }
        }
        temp = new int[cnt];
        int imsi = 0;
        for(int i = 0 ; i < idx ; i++){
            if(board[i] != 0){
                temp[imsi] = board[i];
                imsi++;
            }
        }
        return temp;
    }
    
    public static boolean noMoreBoom(int[] b){
        int idx = cnt;
        for(int i = 0 ; i < idx-1 ; i++){
            int nowCnt = 1, endIdx = 0;
            if(board[i] == board[i+1]){
                for(int j = i ; j < idx-1 ; j++){
                    if(board[j] != board[j+1]){
                        break;
                    }
                    nowCnt++;
                }
            }
            if(nowCnt >= m)
                return false;
        }
        return true;
    }
}