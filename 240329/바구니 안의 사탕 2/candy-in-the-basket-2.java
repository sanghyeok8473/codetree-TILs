import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt(), cnt = 0, R = -1, sum = 0, nowSum = 0, max = 0;

        int[] candyNum = new int[n];
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            candyNum[i] = sc.nextInt();
            arr[i] = sc.nextInt();

            R = Math.max(R, arr[i]);
            sum += candyNum[i];
        }

        int[] candyPlaced = new int[R+1];
            

        for(int i = 0 ; i < n ; i++)
            candyPlaced[arr[i]] += candyNum[i]; //같은 위치에 여러개의 바구니가 놓일 수 있으므로 arr[i]의 값이 동일할 수 있음. 따라서 총합을 구함.
        
        if(k >= (R+1)/2){
            System.out.print(sum);
            System.exit(0);
        }
        else{
            for(int i = k ; i <= R-(k*2) ; i++){  // 구간의 시작점.
                nowSum = 0;
                for(int j = i-k ; j <= i+k ; j++)
                    nowSum += candyPlaced[j];
                max = Math.max(max, nowSum);
            }
            System.out.print(max);
        }

       
    }
}