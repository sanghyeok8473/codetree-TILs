import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), h = sc.nextInt(), t = sc.nextInt(), nowSum, min = Integer.MAX_VALUE;

        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++)
            arr[i] = sc.nextInt();

        //조건 : 최소 T번 이상 H높이로 나오게 하는데 드는 최소한의 비용

        for(int i = 0 ; i <= n-t ; i++){         // 구간의 시작점.
            nowSum = 0;
            for(int j = i ; j < i+t ; j++)      // 시작점부터 T만큼의 구간
                nowSum += Math.abs(h-arr[j]);   // 크기가 T인 구간에서 각 값을 h로 만드는데 소모되는 비용의 총합

            min = Math.min(min, nowSum);
        }
        

        System.out.print(min);

         

        
    }
}