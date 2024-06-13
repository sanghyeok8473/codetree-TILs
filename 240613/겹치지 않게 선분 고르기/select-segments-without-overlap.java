import java.util.*;

public class Main {
    public static int n, maxCnt = 1;
    public static int[] x1;
    public static int[] x2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); x1 = new int[n]; x2 = new int[n];

        for(int i = 0 ; i < n ; i++){
            int nowX1 = sc.nextInt();
            int nowX2 = sc.nextInt();
            x1[i] = nowX1;
            x2[i] = nowX2;
        }

        for(int i = 0 ; i < n-1 ; i++){
            int nowCnt = 1, minX = x1[i], maxX = x2[i];
            for(int j = i+1 ; j < n ; j++){
                if(maxX < x1[j] || x2[j] < minX){       // 안 겹치면
                    nowCnt++;
                    minX = Math.min(minX, x1[j]);
                    maxX = Math.max(maxX, x2[j]);
                }
            }
            maxCnt = Math.max(maxCnt, nowCnt);
        }
        System.out.print(maxCnt);
    }
}