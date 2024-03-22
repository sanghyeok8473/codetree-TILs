import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k, a, b, max;

        n = sc.nextInt();
        k = sc.nextInt();

        int[] block = new int[n+1];

        for(int i = 0 ; i < k ; i++ ){
            a = sc.nextInt();
            b = sc.nextInt();

            for(int j = a ; j <= b; j++)
                block[j]++;
        }

        max = -1;
        for(int i = 1 ; i <= n ; i++ ){
            if(max < block[i])
                max = block[i];
        }
        System.out.print(max);

        
    }
}