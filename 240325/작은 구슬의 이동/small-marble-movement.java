import java.util.Scanner;

public class Main {
    public static boolean inRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }

    public static int getDir(char d){
        if(d == 'L')
            return 3;
        else if(d == 'R')
            return 0;
        else if(d == 'D')
            return 1;
        else
            return 2;
    }

    public static int n, t, r, c;
    public static char d;
    public static int[] dx = new int[]{1, 0, 0, -1};
    public static int[] dy = new int[]{0, -1, 1, 0};
                                     //E  N   S  W
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        t = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        r--;
        c--;
        d = sc.next().charAt(0);
        
        int[][] arr = new int[n][n];

        int dirNum = getDir(d);

        for(int x = 1 ; x <= t ; x++){
            int nx = c + dx[dirNum], ny = r + dy[dirNum];
            if(inRange(nx, ny) == false){
                dirNum = 3 - dirNum;
                continue;
            }

            c += dx[dirNum];
            r += dy[dirNum];
            

            

        }

        r++; c++;
        
        System.out.print(r+" "+c);
        
            
        

    }
}