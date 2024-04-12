import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, m, cnt = 0, nowCnt = 0, max = 1, finalMin = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt(); m = sc.nextInt();
        int[] nums = new int[n];

        boolean ghost = true;
        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
            if(nums[i]==1){
                cnt++;
                ghost = false;
            }
        }
        if(ghost){
            System.out.print(0);
            System.exit(0);
        }
        if(m==0){
            System.out.print(cnt);
            System.exit(0);
        }
        if(m>=n/2){
            System.out.print(1);
            System.exit(0);
        }
        for(int j = m ; j < n-m ; j+=(2*m+1)){
            boolean nowOnlyZero = true;
            int first = 0;
            for(int k = j-m ; k <= j+m ; k++){
                if(nums[k] == 1){
                    nowOnlyZero = false;
                    first = k;
                    break;
                }
            }
            if(nowOnlyZero == false){
                j += (first - (j-m));
                nowCnt++;
            }
            if(j+m < n-1 && j+3*m+1 >= n-1){        // 1개로 커버되는 범위만큼 남았을 때 
                boolean nextOnlyZero = true;
                for(int k = j+m+1 ; k < n; k++){
                    if(nums[k] == 1){
                        nextOnlyZero = false;
                        break;
                    }
                }
                if(nextOnlyZero){
                    System.out.print(nowCnt);
                    System.exit(0);
                }
                else{
                    System.out.print(nowCnt+1);
                    System.exit(0);
                }
            }
        }
        // 0 0 0 0 1 0 1 일 때, 0 0 0 다음 구간을 0 1 0 이 아닌 1 0 1 로 잡는 아이디어가 필요함(효율성)
        // 즉, 구간의 중간지점은 2*m+1로 잡지만, 구간의 시작점이 0이면 구간의 시작점이 1일때까지(nowOnlyZero는 false이니 1이 있긴 있음)
        // 구간을 옮기고 시작하면 됨.

        // 범위안이 전부 0이면 넘어가면서 설치해야됨.
    }
}