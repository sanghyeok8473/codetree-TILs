import java.util.Scanner;

public class Main {
    public static boolean inRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }

    public static int rotate(int dn){
        return (dn + 3)%4;
    }

    public static int n, x, y;
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};
                                     //E  N   W  S
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        
        int[][] arr = new int[n][n];

        x = y = (n-1)/2;
        
        int dirNum = 0;
        int num = 1;
        arr[x][y] = num;

        for(int i = 1 ; i < n ; i++){
            if(i < n-1){
                for(int j = 0 ; j < 2 ; j++){
                    for(int k = 0 ; k < i ; k++){
                        num++;
                        int nx = x + dx[dirNum], ny = y + dy[dirNum];
                        if(inRange(nx, ny)){
                            x += dx[dirNum];  y += dy[dirNum];
                            arr[x][y] = num;
                        }
                    }
                    dirNum = rotate(dirNum);
                }
                
            }
            else{
                for(int j = 0 ; j < 3 ; j++){
                    for(int k = 0 ; k < i ; k++){
                        num++;
                        int nx = x + dx[dirNum], ny = y + dy[dirNum];
                        if(inRange(nx, ny)){
                            x += dx[dirNum];  y += dy[dirNum];
                            arr[x][y] = num;
                        }
                    }
                    dirNum = rotate(dirNum);
                }
                
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
            
        

    }
}