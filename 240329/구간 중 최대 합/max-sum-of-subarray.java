import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt(), max = 0, nowSum;

        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++)
            arr[i] = sc.nextInt();
        
        for(int i = 0 ; i <= n-k ; i++){
            nowSum = 0;
            for(int j = i ; j < i+k ; j++){
                nowSum += arr[j];
            }
            max = Math.max(max, nowSum);
        }

        System.out.print(max);
    }
}