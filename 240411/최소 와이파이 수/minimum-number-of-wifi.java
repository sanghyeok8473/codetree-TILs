import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, m, cnt = 0, max = 1, finalMin = Integer.MAX_VALUE;

    public static int compareMinus(int[] arr){      // 양수가 하나라도 있는 배열이 정렬되어 들어옴.
        int minusTwo = 0, allPlus = 0;          // 따라서 맨 왼쪽 두개와 맨 오른쪽 하나를 곱한 값과
        minusTwo = arr[0] * arr[1] * arr[n-1];  // 맨 오른쪽 3개의 곱을 비교해보면 됨.
        allPlus = arr[n-1] * arr[n-2] * arr[n-3];

        return Math.max(minusTwo, allPlus);
    }
    
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

        // 범위안이 전부 0이면 넘어가면서 설치해야됨.
        for(int i = 1 ; i <= (n/(m+2)) ; i++){  // 공유기의 수를 미리 정의 -> 설치 후 성립하면 바로 break
            int nowCnt = 0, install = 0;
            for(int j = m ; j < n-m ; j+=(2*m+1)){
                boolean nowOnlyZero = true;
                for(int k = j-m ; k <= j+m ; k++){
                    if(nums[k] == 1)
                        nowOnlyZero = false;
                }
                if(nowOnlyZero){
                    continue;
                }
                install++;
                for(int k = j - m ; k <= j + m ; k++){
                    if(nums[k] == 1)
                        nowCnt++;
                }  
                if(install==i){
                    if(j+3*m+1 >= n-1){      // 1개로 커버되는 범위만큼 남았을 때 
                        if(nowCnt == cnt){
                            System.out.print(i);
                            System.exit(0);
                        }
                        else{
                            System.out.print(i);
                            System.exit(0);
                        }
                    }  
                }
            }
        }
    }
}