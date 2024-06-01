import java.util.Scanner;
import java.util.*;

public class Main {
    public static int[][] board;
    public static int[] row;
    public static char[] dir;
    public static int totalMax = -1, n, m, q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt(); q = sc.nextInt();
        board = new int[n][m]; row = new int[q]; dir = new char[q];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                board[i][j] = sc.nextInt();
            }
        }  

        for(int i = 0 ; i < q ; i++){
            row[i] = sc.nextInt();
            dir[i] = sc.next().charAt(0);
            row[i]--;
        }   // 입력 파트

        for(int i = 0 ; i < q ; i++){
            wind(row[i], dir[i]);
            windUp(row[i], dir[i]);
            windDown(row[i], dir[i]);
        }   

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }  // 출력 파트
    }

    public static void wind(int r, char d){
        if(d == 'L'){     // 오른쪽으로 밀려야함.
            int temp = board[r][m-1];
            for(int j = m - 1 ; j >= 1 ; j--){
                board[r][j] = board[r][j-1];
            }
            board[r][0] = temp;
        }
        else if(d == 'R'){     // 왼쪽으로 밀려야함.
            int temp = board[r][0];
            for(int j = 0 ; j < m - 1 ; j++){
                board[r][j] = board[r][j+1];
            }
            board[r][m-1] = temp;
        }
    }

    public static void windUp(int r, char d){
        if(d == 'L')
            d = 'R';
        else
            d = 'L';
        
        if(windValid(r, r-1)){
            wind(r-1, d);
            windUp(r-1, d);
        }
    }
    

    public static void windDown(int r, char d){
        if(d == 'L')
            d = 'R';
        else
            d = 'L';

        if(windValid(r, r+1)){
            wind(r+1, d);
            windDown(r+1, d);
        }
    }

    public static boolean windValid(int r1, int r2){
        if(r2 < 0 || r2 >= n)       // 범위를 벗어난 부분은 볼 것도 없이 false;
            return false;

        for(int j = 0 ; j < m ; j++){
            if(board[r1][j] == board[r2][j])
                return true;       // 하나라도 같으면 전파
        }

        return false;               // 여기까지 왔으면, 모두 다른 거니까 false;
    }  
}