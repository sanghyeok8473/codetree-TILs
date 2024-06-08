import java.util.Scanner;
import java.util.*;

public class Main {
    public static int n, x, y, t = 0, dir = 0, startX, startY;
    public static boolean firstMove = false;
    public static char[][] board;
    public static int[] dx = { 0, 1, 0, -1 };  // 시계
    public static int[] dy = { 1, 0, -1, 0 };                        
                            // 우 하 좌 상
    public static int[] answer;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        n = sc.nextInt(); x = sc.nextInt(); y = sc.nextInt();
        x--; y--; board = new char[n][n]; startX = x; startY =  y;
        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            for(int j = 0 ; j < n ; j++)
                board[i][j] = str.charAt(j);
        }   // 입력 파트

        if(x >= 1 && y >= 1 && board[x + dx[0]][y + dy[0]] == '#' && board[x + dx[1]][y + dy[1]] == '#' && board[x + dx[2]][y + dy[2]] == '#' && board[x + dx[3]][y + dy[3]] == '#'){
            System.out.print(-1);
            System.exit(0);
        }
        
        while(true){
            move();
            if(firstMove == true && x == startX && y == startY){
                System.out.print(-1);
                System.exit(0);
            }
        }
    }
    public static void move(){
        int nextX = x + dx[dir], nextY = y + dy[dir];
        if(!inRange(nextX, nextY)){ // 다음 위치가 격자 밖이라면,  바로 이동하면서 탈출하므로 t+1을 출력 후 종료
            System.out.print(t+1);
            System.exit(0);
        }
        if(board[nextX][nextY] == '#')     // 다음 위치가 벽 일때
            dir = (dir+3)%4;               // 시계 반대 방향으로 회전
        else{     // 바로 앞이  벽이 아니여서 이동이 가능할 때
            if(board[nextX+dx[(dir+1)%4]][nextY+dy[(dir+1)%4]] == '#'){  // 더 나아갔을 때, 그 방향 기준 오른쪽이니까, 시계방향
                x = nextX; y = nextY; t++;
                firstMove = true;
            }
            else{
                firstMove = true;
                x = nextX; y = nextY; t++;
                dir = (dir+1)%4;
                x += dx[dir]; y += dy[dir]; t++;
            }
        }
    }

    public static boolean inRange(int row, int col){            // 받은 좌표 값이 범위 내의 좌표인지 판단
        return (row >= 0 && row < n && col >= 0 && col < n);
    }
}