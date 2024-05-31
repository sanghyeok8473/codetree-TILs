import java.util.Scanner;
import java.util.*;

public class Main {
    public static int[][] board = new int [20][20];
    public static int totalMax = 0, n = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = sc.nextInt();
            }
        }
        // 입력 파트
        
        for(int i = 2 ; i < n ; i++){           //i,j는 시작점.
            for(int j = 1 ; j < n-1 ; j++){
                totalMax = Math.max(totalMax, returnSum(i, j));
            }
        }
        System.out.print(totalMax);
    }

    public static int returnSum (int i, int j){     // 시작점이 x,y인 좌표를 받으면 최대의 기울어진 직사각형을 만들어서 그 변의 합을 반환
        int sum = 0;
        int x = i, y = j;

        boolean end = false;     // 1번 방향
                

        while(!end){
            sum += board[x][y];
            x--; y++;
            
            if(x == 0 || y == n){
                x++; y--;
                x--; y--;
                end = true;
            }
        }

        end = false;                    // 2번 방향
        while(!end){
            sum += board[x][y];
            x--; y--;
            
            if(x <= 0 || y <= 0){
                x++; y++;
                x++; y--;
                end = true;
            }
        }

        end = false;                    // 3번 방향
        while(!end){
            sum += board[x][y];
            if(x >= n-1 || y <= 0){
                x++; y++;
                break;
            }
            x++; y--;
        }

        end = false;                    // 4번 방향
        while(!end){
            if((x == i && y == j) || (x >= n || y >= n))
                break;
            sum += board[x][y];
            if(x+1 == i && y+1 == j){
                break;
            }
            x++; y++;
        }

        return sum;
    }
}

// 어차피 최대가 되어야 하기 때문에, 기준을 잡고, 범위는 보드를 벗어날 때까지로 설정.
// 최소 1칸씩은 시작되는 범위는 i=2, j=1임.