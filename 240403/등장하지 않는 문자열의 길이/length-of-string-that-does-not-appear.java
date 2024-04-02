import java.util.Scanner;

public class Main {
    public static int n;
    public static String str, nowSub = "", compareSub = "";
    public static boolean exist;
    public static int[][] board = new int[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        str = sc.next();
        // 연속부분문자열이 최소 두개는 나타나야 하므로, 확인할 범위는 n/2만큼임. n이7이면 7/2 = 3이고, 3보다 큰 연속부분문자열은
        // 나타날 수 없음.

        for(int i = 1 ; i <= n ; i++){        //연속 부분문자열의 길이            
            for(int j = 0 ; j <= n-i ; j++){    // 연속 부분문자열의 시작점.
                exist = false;
                nowSub = str.substring(j, j + i);
                for(int k = j+1 ; k <= n-i ; k++){ // 비교할 연속 부분문자열의 시작점
                    compareSub = str.substring(k, k + i);
                    if(k != j && compareSub.equals(nowSub)){
                        exist = true;
                        break;
                    }
                }
                if(exist == true)       // 길이가 i일때 연속 부분문자열이 있음.
                    break;
            }
            if(exist == false){     // 문자열의 길이가 i일때, 연속 부분문자열이 없음.
                System.out.print(i);
                System.exit(0);
            }
        }
    }
}