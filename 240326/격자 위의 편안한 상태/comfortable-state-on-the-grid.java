import java.util.Scanner;

public class Main {
    public static boolean inRange(int[][] arr, int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static boolean comfortable(int[][] arr, int x, int y){
        int cnt = 0;

        for(int i = 0 ; i < 4 ; i++ ){
            int nx = x+dx[i], ny = y + dy[i];
            if(inRange(arr, nx, ny) && arr[nx][ny] == 1)
                cnt++;
        }
        
        if(cnt == 3)
            return true;
        else
            return false;
    }

    public static int n, m;
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};
                                     //E  N   W  S
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int[] orderX = new int[m];
        int[] orderY = new int[m];
        int[][] arr = new int[n][n];

        for(int i = 0 ; i < m ; i++){
            orderX[i] = sc.nextInt();
            orderY[i] = sc.nextInt();

            orderX[i]--;
            orderY[i]--;
        }

        for(int i = 0 ; i < m ; i++){
            int nx = orderX[i], ny = orderY[i];

            if(inRange(arr, nx, ny))
                arr[nx][ny] = 1;

            if(comfortable(arr, nx, ny))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}