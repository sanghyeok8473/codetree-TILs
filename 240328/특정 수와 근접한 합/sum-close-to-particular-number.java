import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), s = sc.nextInt(), sum = 0, min = Integer.MAX_VALUE;

        int[] nums = new int[n];

        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
            sum += nums[i];             // 입력받으면서 총합을 미리 구해놓음
        } 

        for(int i = 0 ; i < n-1 ; i++){ // 제외할 두 수 중 첫 번째 수
            for(int j = i+1 ; j < n ; j++){ // 제외할 두 수 중 두 번째 수
                int sumDiff = Math.abs(s - (sum - nums[i] - nums[j])); // S와 N-2개의 합의 차이를 구함. 이 값의 최소값을 구함.
                if(sumDiff < min)
                    min = sumDiff;
            }
        }
        System.out.print(min);
    }
}