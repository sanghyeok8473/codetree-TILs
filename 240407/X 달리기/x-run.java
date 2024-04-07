import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int x, nowT, nowV = 1, nowX = 0, minT = Integer.MAX_VALUE;

    public static int returnMinX(int v){            //최소 이동거리를 뽑아줍니다.(5+4+3+2+1 의 결과를 리턴합니다.)
        if(v == 1)
            return 1;
        
        return v + returnMinX(v-1);
    }

    public static int returnMaxV(int x){
        for(int i = 1; i <= x ; i++){
            if(maxVX(i) <= x && maxVX(i+1) > x)
                return i;
        }

        return 0;
    }

    public static int maxVX(int x){
        int returnX = 0;
        for(int i = 1; i <= x ; i++){
            returnX += i;
        }
        returnX *= 2;
        returnX -= x;
        return returnX;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        x = sc.nextInt();

        for(int i = 1 ; i <= returnMaxV(x) ; i++){
            nowV = i;
            nowX += nowV;
            nowT++;
        }
        while(true){
            if(returnMinX(nowV) > (x - nowX) && nowV > 1)
                nowV--;
            nowX += nowV;
            nowT++;
            if(nowX == x){
                System.out.print(nowT);
                break;
            }
        }
    }
}