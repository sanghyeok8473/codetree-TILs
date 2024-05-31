import java.util.Scanner;
import java.util.*;

public class Main {
    public static int[][] board = new int [20][20];
    public static int totalMax = 0, n = 0, m = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = sc.nextInt();
            }
        }
        // 입력 파트
        
        for(int i = 0 ; i < n ; i++){           //i,j는 중심점.
            for(int j = 0 ; j < n ; j++){
                totalMax = Math.max(totalMax, returnMax(i, j));
            }
        }

        System.out.print(totalMax);
    }

    // 중심점을 전달 받으면, 그 중심점에서 k = n/2+1까지 살펴보며 손해가 없으면서 가장 많은 금 개수를 가지는 경우의 값을 리턴
    // 마름모 모양의 정의: 중심점이 x,y일 때, board[i][j]에서 (i+j)-(x+y) <= k 를 만족하는 i,j

    public static int returnMax (int x, int y){ 
        int nowMax = 0;
        for(int k = 0 ; k <= n ; k++){
            int cost = (k * k) + ((k + 1) * (k + 1));   // 현재 범위에서 채굴 비용
            int nowCnt = 0;                             // 현재 범위에서의 금의 개수
            for(int i = x-k ; i <= x+k ; i++){
                for(int j = y-k ; j <= y+k ; j++){
                    if((i < 0 || i >= n) || (j < 0 || j >= n)) // 범위를 벗어난 경우에는 금이 절대 없으므로 볼 필요도 없음, index범위 밖 오류 방지.
                        continue;
                    if(Math.abs((i-x))+Math.abs((j-y)) <= k){
                        if(board[i][j] == 1)
                            nowCnt++;
                    }
                }
            }
            if(nowCnt*m >= cost){
                if(nowCnt ==  3)
                    System.out.println(x+" "+y+" "+k);
                nowMax = Math.max(nowMax, nowCnt);
            }
                
        }
        return nowMax;
    }
}

// 1. k는 최대 n/2+1 라는 결론.(n=4이면 k=3인 모양은 전체를 초과, n=5이면 k=3까지 가능?)