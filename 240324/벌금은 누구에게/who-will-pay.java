import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] count = new int[n+1];

        int q;

        for(int i = 0 ; i < m ; i++){
            q = sc.nextInt();

            count[q]++;

            if(count[q] == k){
                System.out.print(q);
                    break;
            }
            if(q==m-1){
                System.out.print(-1);
            }
        }
            
    }
}