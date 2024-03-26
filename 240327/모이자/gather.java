import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        int minVal = Integer.MAX_VALUE;

        for(int i = 0 ; i < n ; i++)
            arr[i] = sc.nextInt();
        
        for(int i = 0 ; i < n ; i++){
            int sumDiff = 0;

            for(int j = 0 ; j < n ; j++){
                sumDiff += arr[j]*Math.abs(j-i);
            }
            
            if(sumDiff < minVal)
                minVal = sumDiff;
        }

        System.out.print(minVal);
            

    }
}