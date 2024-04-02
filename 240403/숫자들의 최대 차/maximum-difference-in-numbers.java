import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, k, maxCnt = 1;
    public static int[] nums = new int[1000];

    public static int returnMaxMinDiff(int x, int y){
        int max = 0, min = 10001;

        for(int i = x ; i <= y ; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        return max - min;

    }
    // 한개일 때는 무조건 차가 0이므로 최대 숫자의 개수는 최소 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); k = sc.nextInt(); 

        for(int i = 0 ; i < n ; i++)
            nums[i] = sc.nextInt();

        Arrays.sort(nums);
        for(int ans = 2 ; ans <= n ; ans++){      // 고르는 숫자의 개수
            boolean exist;
            for(int i = 0 ; i < n - ans ; i++){     // 처음 고르는 숫자
                exist = false;
                for(int j = i+1 ; j < i+ans ; j++){   // 개수만큼 영역 선택
                    if(returnMaxMinDiff(i, j) <= k){
                        exist = true;
                        break;
                    }
                }
                if(exist)
                    maxCnt = ans;
            }
        }

        System.out.print(maxCnt);
    }
}