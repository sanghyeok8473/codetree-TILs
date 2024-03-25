import java.util.Scanner;

public class Main {
    public static boolean inRange(int x, int y){
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public static int sideDirection(int side){
        if(side == 1)
            return 1;
        else if(side == 2)
            return 2;
        else if(side == 3)
            return 3;
        else
            return 0;
    }

    public static int sideSelectX(int side){
        if(side == 1)
            return 0;
        else if(side == 2)
            return k - (((side-1)*n)+1);
        else if(side == 3)
            return n-1;
        else
            return side*n - k;
    }

    public static int sideSelectY(int side){
        if(side == 1)
            return k-1;
        else if(side == 2)
            return n-1;
        else if(side == 3)
            return side*n - k;
        else
            return 0;
    }

    public static int n, k, x = 0, y = 0, cnt = 0, dirNum;
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};
                                     //E  N   W  S
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        char[][] arr = new char[n][n];

        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        k = sc.nextInt();
        int side = 0;

        for(int i = 1 ; i <= 4 ; i++){
            if(k <= n*i && k >= n*(i-1)+1)
                side = i;
        }

        x = sideSelectX(side);
        y = sideSelectY(side);          // 격자의 어떤 면에서 시작하는지를 기준으로 시작점을 설정
        dirNum = sideDirection(side);   // 격자의 어떤 면에서 시작하는지를 기준으로 초기 방향을 설정

        while(inRange(x, y)){
            if(arr[x][y] == '/'){
                if(dirNum == 1 || dirNum == 3)
                    dirNum = (dirNum + 1) % 4;     // 위나 아래에서 들어올때는 오른쪽으로 꺾임.
                else
                    dirNum = (dirNum + 3) % 4;     // 왼쪽이나 오른쪽에서 들어올때는 왼쪽으로 꺾임.
            }
            else{
                if(dirNum == 1 || dirNum == 3)
                    dirNum = (dirNum + 3) % 4;     // 위나 아래에서 들어올때는 왼쪽으로 꺾임.
                else
                    dirNum = (dirNum + 1) % 4;     // 왼쪽이나 오른쪽에서 들어올때는 오른쪽으로 꺾임.
            }
            cnt++;
            x += dx[dirNum]; y += dy[dirNum];
        }

        System.out.print(cnt);
    }
}