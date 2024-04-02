import java.util.Scanner;

public class Main {
    public static int n, nowSum = 0, minSum = Integer.MAX_VALUE;
    public static int[] nums = new int[101], tmp = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); 

        for( int i = 0 ; i < n ; i++ )
            nums[i] = sc.nextInt();

        for(int i = 0 ; i < n ; i++){     // 2배할 숫자
            for( int j = 0 ; j < n ; j++ )
                tmp[j] = nums[j];
            tmp[i] *= 2;

            for(int j = 0 ; j < n ; j++){ // 제외할 숫자
                nowSum = 0;
                int[] newTmp = new int[n-1];
                for(int k = 0 ; k < n ; k++){
                    if(k == j)
                        continue;
                    if(k>j)
                        newTmp[k-1] = tmp[k];
                    else if(k<j)
                        newTmp[k] = tmp[k];
                }
                for(int k = 0 ; k < n-2 ; k++){
                    nowSum += Math.abs(newTmp[k] - newTmp[k+1]);
                }
                minSum = Math.min(minSum, nowSum);
            }
            

        }
        System.out.print(minSum);

    }
}