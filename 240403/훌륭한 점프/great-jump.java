import java.util.Scanner;

public class Main {
    public static int n, k, max = 0, nowIdx = 0;
    public static int[] nums = new int[1001];

    public static int returnMinIdx (int x){
        int min = n+1, minIdx = 0;
        for(int i = x + 1 ; i <= x + k ; i++){
            if(min > nums[i]){
                min = nums[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); k = sc.nextInt();

        for(int i = 0 ; i < n ; i++)
            nums[i] = sc.nextInt();

        max = nums[nowIdx];
        
        while(nowIdx < n-1){
            max = Math.max(nums[nowIdx], nums[returnMinIdx(nowIdx)]);
            nowIdx = returnMinIdx(nowIdx);
        }

        System.out.print(max);
    }
}