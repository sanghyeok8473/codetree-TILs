//  뱀이 전부 움직였거나, 움직이는 도중 격자를 벗어났거나, 움직이는 도중 몸이 꼬여 서로 겹쳐졌을 경우 종료
import java.util.*;

public class Main {
    public static int n, m, t, r, c;
    public static int[][] board, count, nextCount;
    public static int[] dx = { -1, 1, 0, 0 };
    public static int[] dy = { 0, 0, -1, 1 };
                            // 상 하 좌 우
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt(); t = sc.nextInt();
        board = new int[n][n]; count = new int[n][n]; nextCount = new int[n][n]; 
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                board[i][j] = sc.nextInt();
        
        for(int i = 0 ; i < m ; i++){
            r = sc.nextInt();
            c = sc.nextInt();
            r--; c--;
            count[r][c] = 1;
        }
        // 입력 파트
        for(int time = 0 ; time < t ; time++){
            nextCount = new int[n][n];
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(count[i][j] == 1){
                        int[] nextXandY = returnNext(i, j);
                        int nextX = nextXandY[0];
                        int nextY = nextXandY[1];
                        nextCount[nextX][nextY]++;
                    }
                }
            }
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(nextCount[i][j] > 1){    // 충돌이 일어났다는 뜻.
                        nextCount[i][j] = 0;
                    }
                }
            }
            count = copy(nextCount);
        }
        countOne(count);
    }

    public static int[] returnNext(int r, int c){
        int max = 0, nextX = r, nextY = c;
        for(int dir = 0 ; dir < 4 ; dir++){
            if(rangeValid(r + dx[dir], c + dy[dir])){       // 상, 하, 좌, 우 순서로 돌면서, 유효하면서 최대값을 가장 마지막으로 갱신한 좌표를 뽑아옴.
                if(board[r + dx[dir]][c + dy[dir]] > max){
                    max = board[r + dx[dir]][c + dy[dir]];
                    nextX = r + dx[dir]; nextY = c + dy[dir]; 
                }
            }
        }
        int[] temp = { nextX, nextY };
        return temp;
    }

    public static int[][] copy(int[][] arr){
        int[][] temp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                temp[i][j] = arr[i][j];
            }
        }
        return temp;
        
    }

    public static void countOne(int[][] arr){
        int returnCnt = 0;
        int[][] temp = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(arr[i][j] == 1)
                    returnCnt++;
            }
        }
        System.out.print(returnCnt);
    }

    public static boolean rangeValid(int r, int c){
        return (r >= 0 && r < n && c >= 0 && c < n);
    }
}