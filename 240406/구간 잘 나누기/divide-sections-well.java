import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, m, max = 0, min = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt();

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
        // 만약 남은 배열의 수와  part의 수가 동일하면? 그즉시  break 후 lim을 말해도 성립

        for(int lim = max ; lim <= (100*100)/2 ; lim++){ // 구간 합들의 최댓값을 미리 정하고 시작(구간의 최대값은 적어도 배열의 최대값 이상임)
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
                if(n-idx == m-part){
                    System.out.print(lim); // n-idx == m-part라는건 남은 개수가 1칸씩으로 가능함 -> lim일때 part=m-1 성립한다는 의미.
                    System.exit(0);
                }
            }
            if(part == m - 1){          // 구간 합들의 최댓값이 lim일 때, 정확히m개의 구간으로 나뉘었음.
                System.out.print(lim);   // 또한 lim이 max부터 시작해 1씩 증가하기 때문에, 처음으로 칸막이가 m-1인 순간이 최소임.
                break;
            }

        }

    }
}