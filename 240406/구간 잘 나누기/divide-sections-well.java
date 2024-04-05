import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, m, div = 0, max = 0, min = 10000;


    // 해결 아이디어 : 입력 받을 때 i+=2로 입력 받고,값이 0인 구간(idx가 반드시 홀수)에 칸막이를 설치 할 수 있다는 방법으로 접근.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt();
        div = n/m;

        int[] nums = new int[n];

        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
            max = Math.max(nums[i], max);
        }
        if(n==m || n==2){
            System.out.print(max);
            System.exit(0);
        }

        // 답을 가정해보고 성립하는지 확인

        for(int lim = max ; lim <= 10000 ; lim++){ // 구간 합들의 최댓값을 미리 정하고 시작(구간의 최대값은 적어도 배열의 최대값 이상임)
            int part = 0, idx = 0;
            for(int i = 0 ; i < n ; i++){     // 구간을 나눴을 때의 구간의 끝이 될 수 있는 값
                int nowSum = 0;
                for(int j = idx ; j < i+1 ; j++){
                    nowSum += nums[j];
                }
                if(nowSum > lim){ // 
                    part++;             // 구간을 하나 나눔.
                    idx = i;            // 다음 구간의 시작점은 현재 구간의 합이 넘치게 된 끝점.
                }
            }
            if(part == m - 1){          // 구간 합들의 최댓값이 lim일 때, 정확히m개의 구간으로 나뉘었음.
                System.out.print(lim);   // 그러나, 구간의 크기가 1인(숫자 한개)데 현재 lim보다 클 수 있음.
                break;
            }

        }

    }
}