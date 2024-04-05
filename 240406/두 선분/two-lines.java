import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, k, minCost = 10000*100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] x = new int[5];
        
        for(int i = 1 ; i <= 4 ; i++)
            x[i] = sc.nextInt();
        
        if((x[1] >= x[3] && x[1] <= x[4]) || (x[2] >= x[3] && x[2] <= x[4]) || (x[3] >= x[1] && x[3] <= x[2]) || (x[4] >= x[1] && x[4] <= x[2]))
            System.out.print("intersecting");
        else
            System.out.print("nonintersecting");

    }
}