import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, b, nowWork, maxGift = Integer.MIN_VALUE, cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); b = sc.nextInt();

        // x1이 더 큰데 x2가 더 작아버리거나 x1은 더 작은데 x2는 더 커버리면 겹침.

        int[] pi = new int[n], pi2 = new int[n];                                                                                                                                                       

        for(int i = 0 ; i < n ; i++)
            pi[i] = sc.nextInt();
            

        for(int i = 0 ; i < n ; i++){ // 반값으로 만들 가격.
            for(int j = 0 ; j < n ; j++)
                pi2[j] = pi[j];
            pi2[i] /= 2;

            Arrays.sort(pi2);           // 오름차순으로 정렬(많이 사려면 가격이 낮은 것 부터 사야하므로)

            for(int j = 0 ; j < n ; j++){
                b -= pi2[j];
                if(b>=0)
                    cnt++;
                else
                    break;
            }
        }
        System.out.print(cnt);


    }
}