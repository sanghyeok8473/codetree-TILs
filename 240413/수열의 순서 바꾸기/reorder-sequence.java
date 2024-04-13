import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, m, cnt = 0, now, nowChk;
    public static int[] nums = new int[100];

    public static void caseN(){
        for(int i = 0 ; i < n-1 ; i++)
            nums[i] = nums[i+1];
        nums[n-1] = n;
        cnt++;
    }

    public static void caseOne(){
        int twoIdx = 0, threeIdx= 0;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 2)
                twoIdx = i;
            if(nums[i] == 3)
                threeIdx = i;
        }
        if(twoIdx == 1){        // 3의 왼쪽으로 가야함.
            for(int i = 0 ; i < threeIdx-1 ; i ++){
                nums[i] = nums[i+1];
            }
            nums[threeIdx-1] = 1;
            cnt++;
        }
        else{                   // 2의 왼쪽으로 가면 됨.
            for(int i = 0 ; i < twoIdx-1 ; i ++){
                nums[i] = nums[i+1];
            }
            nums[twoIdx-1] = 1;
            cnt++;
        }
    }


    public static boolean check(int[] arr){
        for(int i = 0 ; i < n ; i++){
            if(arr[i] != i+1)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        // 매 턴마다 체크해주는 함수를 돌려서 함수가 true면 cnt를 출력하고 종료
        // 만약 now가 n이면 숫자가 있어야 할 위치(배열의 끝)로 가면됨.
        // 맨 앞에 있는 숫자는 now-1의 오른쪽으로 가는게 최선 만약 안되면(now가 1이면) 2의 왼쪽으로
        // 만약 now가 1인데, 2의 idx가 1이면 3의 왼쪽으로 이동
        // 만약 맨 앞에있는 숫자가 n이면, 
        

        // 
        // 못 가는 경우 : 맨 앞에 있는 숫자가 1일 때
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++)
            nums[i] = sc.nextInt();
        

        while(true){
            if(check(nums)){
                System.out.print(cnt);
                break;
            }
            now = nums[0];
            if(now==n){
                caseN();
                continue;
            }
            if(now==1){
                caseOne();
                continue;
            }
            for(int i = 0 ; i < n ; i++){       // now-1의 오른쪽으로 가면됨.
                if(nums[i] == now-1)
                    nowChk = i;
            }
            if(nowChk == n-1){                   // 만약 now-1의 위치가 배열 맨 끝이라면
                for(int i = 0 ; i < n-1 ; i ++){
                    nums[i] = nums[i+1];
                }
                nums[n-1] = now;
                cnt++;
            }
            else{
                for(int i = 0 ; i < nowChk ; i ++){
                    nums[i] = nums[i+1];
                }
                nums[nowChk] = now;
                cnt++;
            }
        }
            

        



        
    }
}