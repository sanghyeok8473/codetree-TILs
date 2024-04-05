import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, max = 0, min = 100, minCost = Integer.MAX_VALUE, totalCost, nowVal;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[] hill = new int[n];

        for(int i = 0 ; i < n ; i++){
            hill[i] = sc.nextInt();
            max = Math.max(max, hill[i]);
            min = Math.min(min, hill[i]);
        }
            

        for(int nowVal = min ; nowVal <= max ; nowVal++){      // 범위의 최소값을 미리 지정
            totalCost = 0;
            for(int j = 0 ; j < n ; j++){
                int nowCost = 0;
                if(hill[j] >= nowVal && hill[j] <= nowVal + 17)
                    continue;
                else if(hill[j] > nowVal + 17)
                    nowCost = hill[j]-(nowVal+17);
                else if(hill[j] < nowVal)
                    nowCost = nowVal-hill[j];
                totalCost += (nowCost*nowCost);
            }
            minCost = Math.min(minCost, totalCost);
        }
        System.out.print(minCost);
    }
}