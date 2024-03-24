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
        int nowCnt = 1;
        boolean none = false;

        for(int i = 0 ; i < n ; i++){
            if(i >= 1 && arr[i] > t && arr[i-1] > t){
                none = true;
                nowCnt++;
            }
            else
                nowCnt = 1;
            
            max = Math.max(max, nowCnt);
        }
        if(none == false)
            max = 0;

        System.out.print(max);
            
    }
}