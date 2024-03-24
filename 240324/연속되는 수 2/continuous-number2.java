import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++)
            arr[i] = sc.nextInt();

        int max = 0;
        int nowCnt = 0;

        for(int i = 0 ; i < n ; i++){
            if(i==0 || arr[i] == arr[i-1]){
                if(i==0)
                    nowCnt = 1;
                else
                    nowCnt++;
            }
            else if(arr[i] != arr[i-1] ){
                if(nowCnt > max)
                    max = nowCnt;
                nowCnt = 1;
            }
        }

        System.out.print(max);
            
    }
}