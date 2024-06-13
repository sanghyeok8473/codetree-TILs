import java.util.*;

public class Main {
    public static int n, maxCnt = 0;
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
            int nowCnt = 1;
            for(int j = i+1 ; j < n ; j++){
                if(x2[i] < x1[j] || x2[j] < x1[i])      // 첫 번째 선분의 끝이 두 번째 선분의 시작보다 뒤에 있거나, 첫 번째 선분의 시작이 두 번째 선분의 끝보다 앞에 있으면 됨.
                    nowCnt++;
            }
            maxCnt = Math.max(maxCnt, nowCnt);
        }
        System.out.print(maxCnt);
    }
}