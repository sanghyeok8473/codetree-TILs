import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, totalMin = 99;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] x1 = new int[n], x2 = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n ; i++){       // 제외할 선분
            int nowMin = 100, nowMax =1;
            for(int j = 0 ; j < n ; j++){
                if(j==i)
                    continue;
                
                nowMin = Math.min(nowMin, x1[j]);
                nowMax = Math.max(nowMax, x2[j]);
            }
            totalMin = Math.min(totalMin, (nowMax-nowMin));
        }

        System.out.print(totalMin);
        
    }
    
}