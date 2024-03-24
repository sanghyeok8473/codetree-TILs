import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
                           //E  S   W  N

        int nx = 0;
        int ny = 0;

        for(int i = 0 ; i < N ; i++){
            char o = sc.next().charAt(0);
            int m = sc.nextInt();

            int dirNum = 0;

            if( o == 'E'){
                dirNum = 0;
            }
            if( o == 'S'){
                dirNum = 1;
            }
            if( o == 'W'){
                dirNum = 2;
            }
            if( o == 'N'){
                dirNum = 3;
            }

            
            nx += dx[dirNum]*m;
            ny += dy[dirNum]*m;
        }
        
        System.out.print(nx+" "+ny);
        
            
        

    }
}