import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int min = Integer.MAX_VALUE;

        int[] men = new int[n];

        for(int i = 0 ; i < n ; i++)
            men[i] = sc.nextInt();
        
              
        for(int i = 0 ; i < n ; i++){     // 시작할 지점 선택
            int nowSum = 0, cnt = 0, nowIdx = i;
            while(true){
                nowSum += men[nowIdx]*cnt;
                nowIdx = (nowIdx + 1) % n;
                cnt++;
                if(cnt == n){
                    cnt = 0;
                    break;
                }
            }
            if(nowSum < min)
                min = nowSum;
        }

        System.out.print(min);
    }
}