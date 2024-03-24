import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
                           //E  N   W  S

        int nx = 0;
        int ny = 0;
        int dirNum = 3;

        //for(int i = 0 ; i < N ; i++){
        char dir = sc.next().charAt(0);

            

            if( dir == 'L'){
                dirNum = (dirNum + 3) % 4;
            }
            if( dir == 'R'){
                dirNum = (dirNum + 1) % 4;
            }

            
            nx += dx[dirNum];
            ny += dy[dirNum];
        //}
        
        System.out.print(nx+" "+ny);
        
            
        

    }
}