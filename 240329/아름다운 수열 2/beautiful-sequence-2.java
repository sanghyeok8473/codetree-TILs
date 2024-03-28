import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt(), nowSum, cnt = 0, idx;

        int[] a = new int[n];
        int[] b = new int[m];
        int[] partA = new int[m];

        for(int i = 0 ; i < n ; i++)
            a[i] = sc.nextInt();

        for(int i = 0 ; i < m ; i++)
            b[i] = sc.nextInt();

        Arrays.sort(b);

        if(n < m){  // n이 m보다 작으면 아름다운 수열이 존재할 수 없음.
            System.out.print(0);
            System.exit(0);
        }

        for(int i = 0 ; i <= n-m ; i++){ // 첫 위치
            idx = 0;
            for(int j = i ; j < i+m ; j++){ // //첫 위치부터 마지막 위치까지를 A의 부분수열이라는 새 배열에 집어넣음.
                partA[idx] = a[j];
                idx++;
            }
            Arrays.sort(partA);

            for(int k = 0 ; k < m ; k++){
                if(partA[k] != b[k])
                    break;
                if(k==m-1)
                    cnt++;
            }
                

        }

        System.out.print(cnt);
    }
}