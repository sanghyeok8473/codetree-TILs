import java.util.Scanner;

public class Main {
    public static int n, m, maxCnt = 0;
    public static int[][] check = new int[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt(); 

        for(int i = 0 ; i < m ; i++){
            int x = sc.nextInt(), y = sc.nextInt();

            check[x][y]++;
        }
        for(int i = 1 ; i <= n ; i++){ 
            for(int j = 1 ; j <= n ; j++){ 
                maxCnt = Math.max(maxCnt, check[i][j] + check[j][i]);
            }  
        }
        System.out.print(maxCnt);
    }
}