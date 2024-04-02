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
        
        for(int min = 1 ; min <= 10000 ; min++){ // 미리 생각해보는 최소값. 
            if(!arrayExist(min))                    // 이 최소값이 일단 먼저 배열에 존재해야함. 존재하지 않으면 불가능한 조합이므로 패스.
                continue;
            cnt = 0;
            for(int i = 0 ; i < n ; i++){
                if(nums[i] >= min && nums[i] - min <= k)  // 미리 생각해본 최소값부터 k이하로 크면 cnt를 추가.
                    cnt++;
            }
            max = Math.max(cnt, max);
            
        }

        System.out.print(max);
    }
}