import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, cnt = 0;
    public static int[] a = new int[100];
    public static int[] b = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++)
            a[i] = sc.nextInt();

        for(int i = 0 ; i < n ; i++)
            b[i] = sc.nextInt();

        for(int i = 0 ; i < n-1 ; i++){
            int nowDiff = 0;
            if(a[i] > b[i]){
                nowDiff = a[i]-b[i];
                a[i+1] += nowDiff;
            }
            cnt += nowDiff;
        }

        System.out.print(cnt);
        
        


        


    }
}