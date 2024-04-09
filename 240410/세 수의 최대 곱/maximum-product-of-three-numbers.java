import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, max = -1000000000;
    public static int[] nums = new int[100000];

    public static int triple(int a, int b, int c){
        return a*b*c;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++)
            nums[i] = sc.nextInt();

        for(int i = 0 ; i < n-2 ; i++){
            for(int j = i+1 ; j < n-1 ; j++){
                for(int k = j+1 ; k < n ; k++){
                    max = Math.max(triple(nums[i], nums[j], nums[k]), max);
                }
            }
        }
        System.out.print(max);
    }
}