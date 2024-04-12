import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, m, oddCnt = 0, evenCnt = 0, total = 0, now = 1;
    
    public static void main(String[] args) {
        // 홀+홀 = 짝
        // 홀수를 짝수개(2,4,6...)만큼 더하면 짝
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0 ; i < n ; i++){
            nums[i] = sc.nextInt();
            if(nums[i]%2 == 0)
                evenCnt++;              // 짝수 개수
            else
                oddCnt++;               // 홀수 개수
        }
        if(oddCnt == evenCnt){ // n이 짝수이고, 홀수와 짝수가 정확히 반반일때(반반이려면 n은 반드시 짝수임)
            System.out.print(n);
            System.exit(0);
        }
        if(n%2==1 && evenCnt == oddCnt+1){ // n이 홀수이고, 짝수가 홀수보다 한개 많으면 짝홀짝...으로감
            System.out.print(n);
            System.exit(0);
        }
        //now는 현재 어떤 묶음이 와야 하는지 명시
        while(true){
            if(now == 1){           // 이번 차례가 짝수일때
                if(evenCnt > 0){    // 남은 짝수가 있으면
                    total++;
                    evenCnt--;
                    now = 0;
                    continue;
                }
                else{               // 남은 짝수가 없을때
                    if(oddCnt > 5){
                        total++;
                        oddCnt-=2;
                        now = 0;
                        continue;
                    }
                    else if(oddCnt == 5){
                        total +=3;
                        break;
                    }
                    else if(oddCnt == 4 || oddCnt == 2){
                        total ++;
                        break;
                    }
                    else if(oddCnt == 3){
                        total +=2;
                        break;
                    }
                }
            }
            else if(now==0){        // 이번 차례가 홀수일 때
                if(oddCnt > 0){    
                    total++;
                    oddCnt--;
                    now = 1;
                }
            }
        }
        System.out.print(total);
            

        



        
    }
}