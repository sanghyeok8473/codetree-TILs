import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a_pos = new int[1000001];
        int[] b_pos = new int[1000001];

        int v, t;

        int a_nowIdx = 1, b_nowIdx = 1;

        for(int i = 0 ; i < n ; i++){
            v = sc.nextInt();
            t = sc.nextInt();

            for(int j = a_nowIdx ; j < a_nowIdx + t ;j++){
                a_pos[j] = a_pos[j - 1] + v;
            }

            a_nowIdx += t;
            
        }

        for(int i = 0 ; i < m ; i++){
            v = sc.nextInt();
            t = sc.nextInt();

            for(int j = b_nowIdx ; j < b_nowIdx + t ;j++){
                b_pos[j] = b_pos[j - 1] + v;
            }

            b_nowIdx += t;
            
        }

        int cnt = 0;

        for(int i = 1; i < a_nowIdx ; i++){
            if((a_pos[i] > b_pos[i] && a_pos[i-1] <= b_pos[i-1]) || (a_pos[i] < b_pos[i] && a_pos[i-1] >= b_pos[i-1]))
                cnt++;
        }

        System.out.println(cnt-1); // 0일때 제외


        
        /*for(int i = 0 ; i < 15 ; i++)
            System.out.print(a_pos[i]+" ");

        System.out.println();

        for(int i = 0 ; i < 15 ; i++)
            System.out.print(b_pos[i]+" ");*/
            
    }
}