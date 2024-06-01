import java.util.Scanner;
import java.util.*;

public class Main {
    public static int[][] board;
    public static int totalMax = Integer.MIN_VALUE, n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                board[i][j] = sc.nextInt();
            }
        }    // 입력 파트

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                for(int k = 0 ; k < n ; k++){
                    for(int q = 0 ; q < m ; q++){
                        if(k <= i && q <= j)            // i,j는 시작점1, k,q는 시작점2
                            continue;
                        totalMax = Math.max(totalMax, returnMaxSum(i, j, k, q));
                    }
                }
            }
        }
       

        System.out.print(totalMax);

    }

    public static int returnMaxSum(int x1, int y1, int x2, int y2){
        int max = Integer.MIN_VALUE;

        for(int k1 = x1 ; k1 < n ; k1++){
            for(int q1 = y1 ; q1 < m ; q1++){
                for(int k2 = x2 ; k2 < n ; k2++){
                    for(int q2 = y2 ; q2 < m ; q2++){
                        if(!twoInOne(x1, y1, k1, q1, x2, y2, k2, q2)){ // 두 번째 직사각형의 시작점이 첫 번째 직사각형안에 없으면
                            max = Math.max(max, recSum(x1, y1, k1, q1, x2, y2, k2, q2));
                        }
                    }
                }
            }
        }
        return max;
    }

    public static boolean twoInOne(int x1, int y1, int k1, int q1, int x2, int y2, int k2, int q2){ // 두 번째 직사각형이 첫 번재 직사각형과 겹치면 안됨.
        if((x2 <= k1 && y2 <= q1) || (x2 <= k1 && q2 <= q1) || (k2 <= k1 && y2 <= q1) || (k2 <= k1 && q2 <= q1))
            return true;
        return false; 
    }
    // 직사각형 두개가 겹친다 : 한 직사각형의 네 꼭짓점중 하나라도 직사각형에 들어간다.

    public static int recSum(int x1, int y1, int k1, int q1, int x2, int y2, int k2, int q2){    // 사각형 두개의 총 합 반환
        int sum = 0;

        for(int i = x1 ; i <= k1 ; i++){
            for(int j = y1 ; j <= q1 ; j++){
                sum += board[i][j];
            }
        }

        for(int i = x2 ; i <= k2 ; i++){
            for(int j = y2 ; j <= q2 ; j++){
                sum += board[i][j];
            }
        }

        return sum;
    }

}
// 1. 시작점은 for문 4개 중첩해서 절대 겹치지 않게 만든다.
// 2. 두 시작점의 좌표 x1,y1 x2,y2를 받으면, 겹치지 않게 두 개의 직사각형을 만드는 함수를 하나 만든다.
// 3. 직사각형 = 점하나를 잡으면 격자내에서 반드시 직사각형이 나옴. 이제 두 번째 직사각형이 겹치지만 않으면 됨.
// 4. 직사각형의 크기의 범위 : 아무리 커도 n*m-1 또는 n-1*m이다. 그래야 두 번째 직사각형이 한줄짜리라도 나올 수 있기 때문.
// 4-1. 즉, for문의 범위는 각각 잡으므로 n, m 으로 잡고, n*m일때만 continue해주면된다.
// 5. 직사각형의 최소는 1*1이다.