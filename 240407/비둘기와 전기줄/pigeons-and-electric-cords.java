import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, cnt = 0;
    public static int[] latestWatched = new int[11];
    public static int[] picked = new int[11];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        
        for(int i = 1 ; i <= n ; i++){
            int pigeonNum = sc.nextInt();
            int num = sc.nextInt();

            if(picked[pigeonNum] == 0){         //처음관찰 되었을 때는 횟수로 세면 안됨.
                latestWatched[pigeonNum] = num;
                picked[pigeonNum] = 1;
            }
            else{         // 관찰된 적 있음.
                if(latestWatched[pigeonNum] != num){
                    latestWatched[pigeonNum] = num;
                    cnt++;
                }
            }
            
            
        }
        System.out.print(cnt);


        


    }
}