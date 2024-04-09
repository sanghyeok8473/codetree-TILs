import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, max = -1;
    public static int[] seat = new int[1000];

    public static int maxMin(int x){
        seat[x] = 1; int nowMin = 2000;
        for(int i = 0 ; i < n-1 ; i++){
            if(seat[i] == 1){
                for(int j = i+1 ; j < n ; j++){
                    if(seat[j] == 1){       
                        nowMin = Math.min(nowMin, j-i);
                        break;
                    }   
                }
            }
        }
        seat[x] = 0;
        return nowMin;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        String str = sc.next();

        for(int i = 0 ; i < n ; i++)
            seat[i] = str.charAt(i) - '0';

        for(int i = 0 ; i < n ; i++){
            if(seat[i] == 1)
                continue;
            max = Math.max(max, maxMin(i));
        }
        System.out.print(max);
            

        
        
    }
}