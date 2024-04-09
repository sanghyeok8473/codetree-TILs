import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, max = -1000000000;

    public static int compareMinus(int[] arr){
        int minusTwo = 0, allPlus = 0;
        minusTwo = arr[0] * arr[1] * arr[n-1];
        allPlus = arr[n-1] * arr[n-2] * arr[n-3];

        return Math.max(minusTwo, allPlus);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        int[] nums = new int[n];
        boolean allMinus = true;
        boolean zeroExist = false;

        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
            if(nums[i] > 0)
                allMinus = false;
            if(nums[i] == 0)
                zeroExist = true;
        }
        Arrays.sort(nums);

        // 하나라도 양수면, 답은 반드시 양수임.
        // 모든 값이 음수일때만 절대값이 작은것 세개를 곱하면 됨.
        // 모든 값이 음수일때 0이 있으면 답은 반드시 0임.
        // 이외에는 양수3개 또는 양수1개에 음수2개를 선택
        if(allMinus){
            if(zeroExist){
                System.out.print(0);
                System.exit(0);
            }
            System.out.print(nums[n-1] * nums[n-2] * nums[n-3]);            // 정렬 했으므로
            System.exit(0);
        }
        else{
            System.out.print(compareMinus(nums));
        }
    }
}