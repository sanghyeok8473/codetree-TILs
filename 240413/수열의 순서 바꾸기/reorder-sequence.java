import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, m, cnt = 0, now, nowChk, nowChk2;
    public static int[] nums = new int[100];

    public static boolean check(int[] arr){
        for(int i = 0 ; i < n ; i++){
            if(arr[i] != i+1)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        // 매 턴마다 체크해주는 함수를 돌려서 함수가 true면 cnt를 출력하고 종료
        // 가능하면 now가 본인이 위치할 수 있는 곳으로 가면 좋음.
        // 만약 now가 n이면 배열의 끝으로 가면됨.
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
            // now가 끝에있는 숫자보다 작으면 본인의 숫자+1의 왼쪽으로 (본인숫자+1의 idx가 1이면 본인숫자+2의 왼쪽으로)
            if(now < nums[n-1]){     
                for(int i = 0 ; i < n ; i ++){
                    if(nums[i] == now+1)
                        nowChk = i;
                    if(nums[i] == now+2)
                        nowChk2 = i;
                }
                if(nowChk==1){
                    for(int i = 0 ; i < nowChk2-1 ; i ++){
                        nums[i] = nums[i+1];
                    }
                    nums[nowChk2-1] = now;
                    cnt++;
                }   
                else{
                    for(int i = 0 ; i < nowChk-1 ; i ++){
                        nums[i] = nums[i+1];
                    }
                    nums[nowChk-1] = now;
                    cnt++;
                }
            }
            // now가 끝에있는 숫자보다 크면 끝으로 이동
            else{
                for(int i = 0 ; i < n-1 ; i ++){
                    nums[i] = nums[i+1];
                }
                nums[n-1] = now;
                cnt++;
            }
        }
    }
}