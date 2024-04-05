import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, max = 0, min = 100, minCost = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] hill = new int[n];

        for(int i = 0 ; i < n ; i++)
            hill[i] = sc.nextInt();
            
        Arrays.sort(hill);

        for(int i = 0 ; i < n ; i++){      // 범위의 최소값을 미리 지정
            int totalCost = 0, nowVal = hill[i];
            for(int j = 0 ; j < n ; j++){
                int nowCost = 0;
                    if(hill[j] > nowVal + 17)
                        nowCost = hill[j]-(hill[i]+17);
                    else if(hill[j] < nowVal)
                        nowCost = nowVal-hill[j];
                totalCost += (nowCost*nowCost);
            }
            minCost = Math.min(minCost, totalCost);
        }
        System.out.print(minCost);
    }
}