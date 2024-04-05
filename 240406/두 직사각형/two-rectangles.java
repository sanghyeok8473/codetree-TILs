import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, k, minCost = 10000*100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] x = new int[3];
        int[] y = new int[3];
        int[] a = new int[3];
        int[] b = new int[3];
        
        for(int i = 1 ; i <= 2 ; i++)
            x[i] = sc.nextInt();
        for(int i = 1 ; i <= 2 ; i++)
            y[i] = sc.nextInt();
        for(int i = 1 ; i <= 2 ; i++)
            a[i] = sc.nextInt();
        for(int i = 1 ; i <= 2 ; i++)
            b[i] = sc.nextInt();
        
        if(x[2] < a[1] || a[2] < x[1] || y[2] < b[1] || b[2] < y[1])
            System.out.print("nonoverlapping");
        else
            System.out.print("overlapping");

    }
}