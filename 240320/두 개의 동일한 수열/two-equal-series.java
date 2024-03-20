import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];
        

        for(int i = 0 ; i < n ; i++ )
            A[i] = sc.nextInt();

        for(int i = 0 ; i < n ; i++ )
            B[i] = sc.nextInt();

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i = 0 ; i < n ; i++ ){
            if(A[i]!=B[i]){
                System.out.print("No");
                break;
            }
            if(A[i]==B[i] && i==n-1)
                System.out.print("Yes");
        }

        

    }
}