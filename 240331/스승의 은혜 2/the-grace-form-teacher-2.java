import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, b, nowCal, nowCnt = 0, maxCnt = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); b = sc.nextInt();

        // x1이 더 큰데 x2가 더 작아버리거나 x1은 더 작은데 x2는 더 커버리면 겹침.

        int[] pi = new int[n], pi2 = new int[n];                                                                                                                                                       

        for(int i = 0 ; i < n ; i++)
            pi[i] = sc.nextInt();
            

        for(int i = 0 ; i < n ; i++){ // 반값으로 만들 물건의 가격.
            for(int j = 0 ; j < n ; j++)
                pi2[j] = pi[j];            // 반값으로 만들어 개수를 세본 이후 원래대로 돌려야되기 때문에 똑같은 배열을 하나 만듬.
            
            pi2[i] /= 2;

            Arrays.sort(pi2);           // 오름차순으로 정렬(많이 사려면 가격이 낮은 것 부터 사야하므로)
            nowCal = b; nowCnt = 0;

            for(int j = 0 ; j < n ; j++){
                nowCal -= pi2[j];

                if(b>=0)
                    nowCnt++;
                else
                    break;
            }
            maxCnt = Math.max(maxCnt, nowCnt);
        }
        System.out.print(maxCnt);


    }
}