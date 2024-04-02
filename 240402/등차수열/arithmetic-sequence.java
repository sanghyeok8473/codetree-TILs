import java.util.Scanner;

public class Main {
    public static int n, cnt = 0, max = 100, min = 1, maxCnt = 0;
    public static int[] nums = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();

            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        for( int k = min ; k <= max ; k++ ){
            cnt = 0;
            for( int i = 0 ; i <n-1 ; i++ ){
                for( int j = i+1 ; j < n ; j++ ){
                    if(nums[j] - k == k - nums[i])
                        cnt++;
                }
            }
            maxCnt = Math.max(cnt, maxCnt);
        }
        System.out.print(maxCnt);

    }
}