import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, k, cnt, max = 1;
    public static int[] nums = new int[1000];

    public static boolean arrayExist(int x){
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == x)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); k = sc.nextInt(); 

        for(int i = 0 ; i < n ; i++)
            nums[i] = sc.nextInt();
        
        for(int min = 1 ; min <= 10000 ; min++){ // 미리 생각해보는 최소값. 이 최소값이 일단 먼저 배열에 존재해야함. 존재할 때 k범위 이내를 다합한 최대값을 구함.
            if(!arrayExist(min)){
                continue;
            }
            cnt = 0;
            for(int i = 0 ; i < n ; i++){
                if(nums[i] >= min && nums[i] - min <= k)
                    cnt++;
            }
            max = Math.max(cnt, max);
            
        }

        System.out.print(max);
    }
}