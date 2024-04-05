import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, l, lCnt, hCnt, max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); l = sc.nextInt();

        int[] nums = new int[n];
        
        for(int i = 0 ; i < n ; i++)
            nums[i] = sc.nextInt();
        
        // H점수를 max부터 시작해서 1씩 줄어들면서, 만족하려면 몇개의 값을 1만큼 올려야 되는지 확인, 없거나 L을 넘어가면 h--;
        // 배열을 돌면서 nums[i]가 h 이상이거나 h가 nums[i]보다 1만큼 클 때만 cnt를 ++해줌.
        // 이때 이상이면 L값에 해당하는 lCnt를 증가하지 않고 hCnt를, nums[i] == h-1일때는 lCnt를 더함고 hCnt도 증가.
        for(int h = n ; h >= 0 ; h--){ // 확인해볼 h점수. h점수는 반드시 n 이하임. 만약 성립하면, break 후 출력.
            lCnt = 0; hCnt = 0;
            for(int i = 0 ; i < n ; i++){
                if(nums[i] >= h)            // 이미 h이상이면, 1을 더해 lCnt를 증가시키지 않아도 조건을 충족함.
                    hCnt++;
                else if(nums[i] == h - 1){  // h-1일때는 nums[i]에 1을 증가시키면 H점수에 들어가나, l을 넘는지의 여부를 체크하기 위해 lCnt도 증가.
                    hCnt++; lCnt++;
                }
            }
            if(hCnt >= h && (lCnt - (hCnt - h)) <= l){
                System.out.print(h);
                break;
            }

        }

    }
}