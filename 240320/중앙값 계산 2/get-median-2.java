import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n;
    public static int[] a  = new int[101];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
    
        for(int i = 1 ; i <= n ; i++ ){
            a[i] = sc.nextInt();

            if(i%2 == 1){
                Arrays.sort(a, 1, i+1);
                System.out.print(a[(i+1)/2]+" ");
            }
        }
    }
}