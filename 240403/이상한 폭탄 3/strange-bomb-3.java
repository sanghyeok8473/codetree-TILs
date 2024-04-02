import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, k, max = -1;
    public static int[] bombs = new int[100];
    public static int[] checkBoom = new int[1000001];
    public static int[] alreadyBoom = new int[100];

    // 한개일 때는 무조건 차가 0이므로 최대 숫자의 개수는 최소 1
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); k = sc.nextInt(); 

        for(int i = 0 ; i < n ; i++){
            bombs[i] = sc.nextInt();
            max = Math.max(bombs[i], max);
        }
            
        boolean none = true;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(j==i || Math.abs(j-i) > k)
                    continue;
                if(bombs[j] == bombs[i]){
                    none = false;
                    if(alreadyBoom[i] == 0){
                        checkBoom[bombs[i]]++;
                        alreadyBoom[i] = 1;
                    }
                    if(alreadyBoom[j] == 0){
                        checkBoom[bombs[i]]++;
                        alreadyBoom[j] = 1;
                    }
                }
            }
        }
        if(none){
            System.out.print(0);
            System.exit(0);
        }
        int maxCnt = -1, maxNum = -1;
        for(int i = 0 ; i <= max ; i++){
            if(checkBoom[i] > maxCnt){
                maxNum = i;
                maxCnt = checkBoom[i];
            }
            else if(checkBoom[i] == maxCnt){
                maxNum = i;
            }
        }
        System.out.print(maxNum);
    }
}