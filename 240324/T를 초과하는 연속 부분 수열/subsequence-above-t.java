import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++)
            arr[i] = sc.nextInt();

        int max = 0;
        int nowCnt = 0;

        for(int i = 0 ; i < n ; i++){
            if(i >= 1 && arr[i] > t && arr[i-1] > t){
                nowCnt++;
            }
            else
                nowCnt = 0;
            
            max = Math.max(max, nowCnt+1);
        }

        System.out.print(max);
            
    }
}