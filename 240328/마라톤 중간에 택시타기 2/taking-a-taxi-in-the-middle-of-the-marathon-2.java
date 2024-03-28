import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int min = Integer.MAX_VALUE;

        int[] X = new int[n];
        int[] Y = new int[n];

        for(int i = 0 ; i < n ; i++){
            X[i] = sc.nextInt();
            Y[i] = sc.nextInt();
        }
        
        int x = X[0], y = Y[0];
        int total = 0;
        
        for(int i = 1 ; i < n-1 ; i++){     // 건너뛸 체크포인트
            int nowSum = 0;
            for(int j = 0 ; j < n-1 ; j++){
                if(j==i)      //건너뛸 체크포인트는 건너뛰기.
                    continue;
                if(j == i-1)  // 건너뛸 체크포인트 직전이면, 다다음 체크포인트와 거리를 구하기 
                    nowSum += (Math.abs(X[j+2] - X[j]) + Math.abs(Y[j+2] - Y[j]));
                else
                    nowSum += (Math.abs(X[j+1] - X[j]) + Math.abs(Y[j+1] - Y[j])); //체크포인트 직전이 아니면, 그 다음 체크포인트와의 거리를 구함.
            }
            if(nowSum < min)
                min = nowSum;
        }

        System.out.print(min);
    }
}