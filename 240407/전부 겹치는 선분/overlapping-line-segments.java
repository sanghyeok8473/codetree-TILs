import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, k, minCost = 10000*100;
    public static int[] segX = new int[100];
    public static int[] segY = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        
        for(int i = 0 ; i < n ; i++){
            segX[i] = sc.nextInt();
            segY[i] = sc.nextInt();
        }
            

        for(int i = 1 ; i <= 100 ; i++){
            boolean exist = true;
            for(int j = 0 ; j < n ; j++){
                if(segX[j] > i || segY[j] < i){
                    exist = false;
                    break;
                }
            }
            if(exist){
                System.out.print("Yes");
                break;
            }
            if(!exist && i==100){
                System.out.print("No");
                break;
            }
        }
        


    }
}