import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, maxX = 21, maxY= 21, minX = 1, minY = 1, nowSum = 0, maxSum = 0;

    public static int countsX(int[][] seg){ // seg의 0이 아닌 서로다른 x좌표의 개수를 반환
        int  xCnt = 1; int[] segX = new int[n];
        for(int i = 0 ; i < n ; i++){
            segX[i] = seg[i][0];
        }
        Arrays.sort(segX);
        for(int i = 0 ; i < n-1 ; i++){
            if(segX[i+1] != segX[i] && segX[i+1] != 0 && segX[i] != 0)
                xCnt++;
        }
        return xCnt;
    }

    public static int countsY(int[][] seg){ // seg의 서로다른 y좌표의 개수를 반환
        int  yCnt = 1; int[] segY = new int[n];
        for(int i = 0 ; i < n ; i++){
            segY[i] = seg[i][1];
        }
        Arrays.sort(segY);
        for(int i = 0 ; i < n-1 ; i++){
            if(segY[i+1] != segY[i] && segY[i+1] != 0 && segY[i] != 0)
                yCnt++;
        }
        return yCnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[][] seg = new int[n][2];

        if(n<=3){                   // 점이 3개 이하일땐 반드시 축에 평행한 선분 3개로 지날 수 있음.
            System.out.print(1);
            System.exit(0);
        }

        for(int i = 0 ; i < n ; i++){
            seg[i][0] = sc.nextInt();
            seg[i][1] = sc.nextInt();

            seg[i][0]++;
            seg[i][1]++;

            maxX = Math.max(seg[i][0], maxX);
            minX = Math.min(seg[i][0], minX);
            maxY = Math.max(seg[i][1], maxY);
            minY = Math.min(seg[i][1], minY);
        }
        int xCnt = countsX(seg), yCnt = countsY(seg);

        if(xCnt <=3 || yCnt <= 3){
            System.out.print(1);
            System.exit(0);
        }
        // 이제 성립하려면 2개 1개 또는 1개 2개일때만 가능.
        for(int i = minX ; i <= maxX ; i++ ){   //y축에 평행하는 선분이 1개일 때
            int idx = 0; int[][] newSeg = new int[n][2];
            for(int j = 0 ; j < n ; j++){
                if(seg[j][0] != i){
                    newSeg[idx][1] = seg[j][1];
                    idx++;
                }
            }
            if(countsY(newSeg) == 2){
                System.out.print(1);
                System.exit(0);
            }
        }
        for(int i = minY ; i <= maxY ; i++ ){   // x축에 평행하는 선분이 한개일 때
            int idx = 0; int[][] newSeg = new int[n][2];
            for(int j = 0 ; j < n ; j++){ 
                if(seg[j][1] != i){
                    newSeg[idx][0] = seg[j][0];
                    idx++;
                }
            }
            if(countsX(newSeg) == 2){
                System.out.print(1);
                System.exit(0);
            }
        }


        System.out.print(0);    // 여기까지 왔다는건 한 축에만 평행한 선분 3개도 안되고
                                // 축에 평행한 선분이 각각 2개 1개 또는 1개 2개일 때도 안된다는 의미임. 따라서 하나의 축에 평행한선이
                                // 0개, 1개, 2개, 3개일 때를 모두 확인 해 봐도 안된다는 의미.

    }
}