import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, max = -1;
    public static boolean success;
    public static int[] sums = new int[1000];

    // 해결 아이디어 : 1부터 n까지의 숫자를 무작위로 배치한 배열이 sums 조건을 만족하는지 계속 체크
    // 사전순으로 가장 앞선 수열을 출력하므로 사전 순 기준 가장 먼저 오는 수부터 시작해서 비교하는 조건
    // 무작위로 배치한다는 것이 굉장히 힘듬. 따라서 n을 받으면, 1부터 n까지 순서대로 들어가있는 배열을 하나 만들고,
    // 사전순을 기준으로 한칸 뒤에 있는 배열을 만들고, 이 배열이 성립하면 끝.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0 ; i < n-1 ; i++)
            sums[i] = sc.nextInt();                         // 처음 입력받는 인접한 수 끼리의 합

        for(int i = 0 ; i < n ; i++){                       // 시작점에 넣어줄 숫자
            success = true;
            int[] nums = new int[n];
            nums[0] = i+1;
            int[] alreadyUsed = new int[n*4];
            for(int j = 0 ; j < n-1 ; j++){
                int diff = sums[j] - nums[j];
                if(diff <= 0 || diff > n){
                    success = false;
                    break;
                }
                if(alreadyUsed[diff] == 1 || (sums[j]%2 == 0 && nums[j] == sums[j]/2)){
                    success = false;
                    break;
                }
                alreadyUsed[diff] = 1;
                nums[j+1] = diff;
            }
            if(success){
                for(int k = 0 ; k < n ; k++){
                    System.out.print(nums[k]+" ");
                }
                break;
            }
        }
        
        
        
    }
}