import java.util.Scanner;

public class Main {
    public static boolean inRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }

    public static int n;
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};
                                     //E  N   W  S
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[][] arr = new int[n][n];

        for(int x = 0 ; x < n ; x++){
            for(int y = 0 ; y < n ; y++){
                arr[x][y] = sc.nextInt();
            }
        }

        int nx = 0;
        int ny = 0;
        int totalCnt = 0;

        for(int x = 0 ; x < n ; x++){
            for(int y = 0 ; y < n ; y++){
                int cnt = 0;
                for(int dirNum = 0 ; dirNum < 4 ; dirNum++){
                    nx = x + dx[dirNum];
                    ny = y + dy[dirNum];
                    if(inRange(nx, ny) && arr[nx][ny] == 1)
                        cnt++;
                }
                if(cnt>=3)
                    totalCnt++;
            }
        }
        
        System.out.print(totalCnt);
        
            
        

    }
}