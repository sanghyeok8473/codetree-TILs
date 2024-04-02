import java.util.Scanner;

public class Main {
    public static int n, a, b, c, nowCnt = 0, maxCnt = 0;
    public static int[][] change = new int[101][2];
    public static int[] check = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); 

        for( int i = 0 ; i < n ; i++ ){
            change[i][0] = sc.nextInt();
            change[i][1] = sc.nextInt();
            check[i] = sc.nextInt();
        }

        for(int i = 1 ; i <= 3 ; i++){  // 처음 조약돌을 넣을 위치, 조약돌이 있는 곳이 1임.
            int[] cup = new int[4];
            cup[i] = 1; nowCnt = 0;
            for(int j = 0 ; j < n ; j++){
                int tmp = cup[change[j][0]];
                cup[change[j][0]] = cup[change[j][1]];
                cup[change[j][1]] = tmp;

                if(cup[check[j]] == 1)
                    nowCnt++;
            }
            maxCnt = Math.max(maxCnt, nowCnt);

        }
        System.out.print(maxCnt);

    }
}