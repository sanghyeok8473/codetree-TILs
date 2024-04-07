import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int x, nowT, nowV, nowX, minT = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        x = sc.nextInt();
        // 줄이기 시작하는 지점을 미리 지정해놓고 for문 돌기?
        
        for(int highT = 1 ; highT <= x ; highT++ ){     // 줄이기 시작하는 지점을 미리 지정
            nowV = 0; nowX = 0; nowT = 0;
            boolean finishOne = false;
            for(int t = 1 ; t <= highT ; t++){
                nowV++;
                nowX += nowV;
                nowT ++;
            }
            for(int t = highT ; t <= x ; t++){
                if(nowV != 1)
                    nowV--;
                nowX += nowV;
                nowT ++;
                if(nowX == x && nowV == 1){
                    finishOne = true;
                    break;
                }
            }
            if(finishOne)
                minT = Math.min(nowT, minT);
        }
        System.out.print(minT);

    }
}