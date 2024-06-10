import java.util.*;

// 1(/)일때, 방향이 상/하이면 우회전 해서 우/좌, 방향이 좌/우이면 좌회전해서 하/상 (dir+1)%4 / (dir+3)%4
// 2(\)일때, 방향이 상/하이면 좌회전 해서 좌/우, 방향이 좌/우이면 우회전해서 상/하 (dir+3)%4 / (dir+1)%4 

public class Main {
    public static int n, nowT, nowDir, maxTime = 0;
    public static int[][] board;
    public static int[] dx = { -1, 0, 1, 0 };
    public static int[] dy = { 0, 1, 0, -1 };
                            // 상 우 하 좌
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); board = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = sc.nextInt();
            }
        } // 입력 파트

        for(int j = 0 ; j < n ; j++){
            maxTime = Math.max(maxTime, returnTimeUp(-1, j));   // 벗어나는 범위를 주어야함.(들어가자마자 대각선이 존재할 수 있기 때문에.)
            maxTime = Math.max(maxTime, returnTimeDown(n, j));
        }
        for(int i = 0 ; i < n ; i++){
            maxTime = Math.max(maxTime, returnTimeLeft(i, -1));
            maxTime = Math.max(maxTime, returnTimeRight(i, n));
        }

        System.out.print(maxTime);
    }

    public static int returnTimeUp(int x, int y){ // 위에서 시작하는 부분
        nowT = 0; nowDir = 2; // 위에서 시작하므로 방향은 아래방향.
        x += dx[nowDir]; y += dy[nowDir]; nowT++;
        while(rangeValid(x,y)){
            switch(board[x][y]){
                case 0:
                    x += dx[nowDir]; y += dy[nowDir]; nowT++;
                    break;
                case 1: // /모양.
                    if(nowDir == 0 || nowDir == 2)
                        nowDir = (nowDir+1)%4;
                    else
                        nowDir = (nowDir+3)%4;
                    x += dx[nowDir]; y += dy[nowDir]; nowT++;
                    break;
                case 2: // \모양.
                    if(nowDir == 0 || nowDir == 2)
                        nowDir = (nowDir+3)%4;
                    else
                        nowDir = (nowDir+1)%4;
                    x += dx[nowDir]; y += dy[nowDir]; nowT++;
                    break;
            }
        }
        return nowT;
    }

    public static int returnTimeDown(int x, int y){ // 아래에서 시작하는 부분
        nowT = 0; nowDir = 0; // 아래에서 시작하므로 방향은 위 방향.
        x += dx[nowDir]; y += dy[nowDir]; nowT++;
        while(rangeValid(x,y)){
            switch(board[x][y]){
                case 0:
                    x += dx[nowDir]; y += dy[nowDir]; nowT++;
                    break;
                case 1: // /모양.
                    if(nowDir == 0 || nowDir == 2)
                        nowDir = (nowDir+1)%4;
                    else
                        nowDir = (nowDir+3)%4;
                    x += dx[nowDir]; y += dy[nowDir]; nowT++;
                    break;
                case 2: // \모양.
                    if(nowDir == 0 || nowDir == 2)
                        nowDir = (nowDir+3)%4;
                    else
                        nowDir = (nowDir+1)%4;
                    x += dx[nowDir]; y += dy[nowDir]; nowT++;
                    break;
            }
        }
        return nowT;
    }

    public static int returnTimeLeft(int x, int y){ // 왼쪽에서 시작하는 부분
        nowT = 0; nowDir = 1; // 왼쪽에서 시작하므로 방향은 오른쪽방향.
        x += dx[nowDir]; y += dy[nowDir]; nowT++;
        while(rangeValid(x,y)){
            switch(board[x][y]){
                case 0:
                    x += dx[nowDir]; y += dy[nowDir]; nowT++;
                    break;
                case 1: // /모양.
                    if(nowDir == 0 || nowDir == 2)
                        nowDir = (nowDir+1)%4;
                    else
                        nowDir = (nowDir+3)%4;
                    x += dx[nowDir]; y += dy[nowDir]; nowT++;
                    break;
                case 2: // \모양.
                    if(nowDir == 0 || nowDir == 2)
                        nowDir = (nowDir+3)%4;
                    else
                        nowDir = (nowDir+1)%4;
                    x += dx[nowDir]; y += dy[nowDir]; nowT++;
                    break;
            }
        }
        return nowT;
    }

    public static int returnTimeRight(int x, int y){ // 오른쪽에서 시작하는 부분
        nowT = 0; nowDir = 3; // 오른쪽에서 시작하므로 방향은 왼쪽방향.
        x += dx[nowDir]; y += dy[nowDir]; nowT++;
        while(rangeValid(x,y)){
            switch(board[x][y]){
                case 0:
                    x += dx[nowDir]; y += dy[nowDir]; nowT++;
                    break;
                case 1: // /모양.
                    if(nowDir == 0 || nowDir == 2)
                        nowDir = (nowDir+1)%4;
                    else
                        nowDir = (nowDir+3)%4;
                    x += dx[nowDir]; y += dy[nowDir]; nowT++;
                    break;
                case 2: // \모양.
                    if(nowDir == 0 || nowDir == 2)
                        nowDir = (nowDir+3)%4;
                    else
                        nowDir = (nowDir+1)%4;
                    x += dx[nowDir]; y += dy[nowDir]; nowT++;
                    break;
            }
        }
        return nowT;
    }

    public static boolean rangeValid(int r, int c){
        return (r >= 0 && r < n && c >= 0 && c < n);
    }
}