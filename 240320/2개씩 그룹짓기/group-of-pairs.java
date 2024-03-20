import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int max = 0, n = 0, nowSum = 0;
    public static int[] a = new int[2001];

    public static int sumMax(){
        for(int i = 1 ; i <= n ; i++ ){
            nowSum = a[i] + a[n+1-i];
            if(max < nowSum)
                max = nowSum;
        }
        return max;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        n*=2;
        

        for(int i = 1 ; i <= n ; i++ )
            a[i] = sc.nextInt();
            

        Arrays.sort(a, 1, n+1);

        System.out.print(sumMax());
    }
}