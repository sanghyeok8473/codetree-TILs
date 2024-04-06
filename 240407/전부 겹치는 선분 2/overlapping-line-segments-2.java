import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, k, minCost = 10000*100;
    public static int[] segX = new int[100];
    public static int[] segY = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        
        for(int i = 0 ; i < n ; i++){
            segX[i] = sc.nextInt();
            segY[i] = sc.nextInt();
        }
            
        
        for(int i = 1 ; i <= 100 ; i++){            // 겹친다고 가정하는 지점
            boolean exist = true;
            for(int exc = 0 ; exc < n; exc++){      // 제외할 지점
                exist = true;
                for(int j = 0 ; j < n ; j++){       // 탐색할 전체 구간
                    if(j==exc)                      // 제외할 지점은 보지 않고 넘어감.
                        continue;
                    if(segX[j] > i || segY[j] < i){
                        exist = false;
                        break;
                    }
                }
                if(exist)
                    break;
            }
            if(exist){
                System.out.print("Yes");
                break;
            }
        }
        


    }
}