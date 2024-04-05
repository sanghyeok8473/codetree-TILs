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

        // max부터 전체의 총합까지 i를 증가시키면서, 현재 i값이 최대값이 되게 나눌 수 있는지를 계산해서, 이게 가능하면 break후 출력?
        // div(n / m)을 구해놓고,  div만큼의 범위 값이 최소라 가정, 이게 가능한지를 확인?
        max = 0;
        for(int lim = 1 ; lim <= 100 * 100 + 1 ; lim++){ // 최대값들의 최소값을 미리 정하고 시작
            int prev_i = 0, partition = 0;
            for(int i = 0 ; i < n ; i++){               // 파티션을 나눌때의 인덱스값
                int nowSum = 0;
                for(int j = prev_i ; j < i+1 ; j++){
                    nowSum += nums[j];
                }
                if(lim < nowSum){                   // 마지막 구간끼리의 합은 lim을 넘으면 안됨.
                    partition += 1;
                    prev_i = i;     // 파티션이 나뉘었고, 시작 idx를 파티션 직후로 설정
                }
            }
            if(partition == m-1){
                System.out.print(Math.max(lim, max));
                break;
            }
        }

    }
}