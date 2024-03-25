import java.util.Scanner;

public class Main {
    public static boolean inRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }

    public static int nowDir(char c){
        if(c == 'E')
            return 0;
        else if(c == 'N')
            return 1;
        else if(c == 'W')
            return 2;
        else 
            return 3;
    }

    public static int n, x=0, y=0;
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};
                                     //E  N   W  S
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        char[] dir = new char[n];
        int[] move = new int[n];
        
        int dirNum = 0;
        int cnt = 0;

        for(int i = 0 ; i < n ; i++){
            dir[i] = sc.next().charAt(0);
            move[i] = sc.nextInt();
        }

        boolean comeback = false;

        for(int i = 0 ; i < n ; i++){
            dirNum = nowDir(dir[i]);
            for(int j = 1 ; j <= move[i] ; j++){
                x += dx[dirNum]; y += dy[dirNum];
                cnt++;

                if(x==0 && y==0){
                    comeback = true;
                    break;
                }
            }
            if(comeback == true)
                break;
        }
        
        if(comeback == true)
            System.out.print(cnt);
        else
            System.out.print(-1);
        
            
        

    }
}