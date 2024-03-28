import java.util.Scanner;

public class Main {
    public static int judgmentVec(int x, int y){ // 수직방향일 때 성립하는지 판단
        char nowChar = board[x][y];
        if(nowChar != 'L')
            return 0;
        else{ //현재 위치값이 L일때
            int cnt = 0;

            if(x + 2  <= n && board[x+1][y] == 'E' && board[x+2][y] == 'E')      
                cnt++;
            if(x - 2 >= 0 && board[x-1][y] == 'E' && board[x-2][y] == 'E')
                cnt++;

            // LEE가 만들어질수 있는 조건 : LEE가 방향대로 만들어질 만큼의 공간이 있고 LEE일 때.

            return cnt; // 현재 위치값이 L일때 정방향과 역방향의 값이 LEE인 갯수를 return함.
        }
    }

    public static int judgmentHor(int x, int y){ // 수평방향일 때 성립하는지 판단
        char nowChar = board[x][y];
        if(nowChar != 'L')
            return 0;
        else{ //현재 위치값이 L일때
            int cnt = 0;

            if(y + 2  <= n && board[x][y+1] == 'E' && board[x][y+2] == 'E')      
                cnt++;
            if(y - 2 >= 0 && board[x][y-1] == 'E' && board[x][y-2] == 'E')
                cnt++;

            // LEE가 만들어질수 있는 조건 : LEE가 방향대로 만들어질 만큼의 공간이 있고 LEE일 때.

            return cnt; // 현재 위치값이 L일때 정방향과 역방향의 값이 LEE인 갯수를 return함.
        }
    }

    public static int judgmentDiaUp(int x, int y){ // 대각선 위 방향일 때 성립하는지 판단
        char nowChar = board[x][y];
        if(nowChar != 'L')
            return 0;
        else{ //현재 위치값이 L일때
            int cnt = 0;

            if(x - 2  >= 0 && y + 2 <= n && board[x-1][y+1] == 'E' && board[x-2][y+2] == 'E')      
                cnt++;
            if(x + 2  <= n && y - 2 >= 0 && board[x+1][y-1] == 'E' && board[x+2][y-2] == 'E')
                cnt++;

            // LEE가 만들어질수 있는 조건 : LEE가 방향대로 만들어질 만큼의 공간이 있고 LEE일 때.

            return cnt; // 현재 위치값이 L일때 정방향과 역방향의 값이 LEE인 갯수를 return함.
        }
    }

    public static int judgmentDiaDown(int x, int y){ // 대각선 위 방향일 때 성립하는지 판단
        char nowChar = board[x][y];
        if(nowChar != 'L')
            return 0;
        else{ //현재 위치값이 L일때
            int cnt = 0;

            if(x + 2 <= n && y + 2 <= n && board[x+1][y+1] == 'E' && board[x+2][y+2] == 'E')      
                cnt++;
            if(x - 2  >= 0 && y - 2 >= 0 && board[x-1][y-1] == 'E' && board[x-2][y-2] == 'E')
                cnt++;

            // LEE가 만들어질수 있는 조건 : LEE가 방향대로 만들어질 만큼의 공간이 있고 LEE일 때.

            return cnt; // 현재 위치값이 L일때 정방향과 역방향의 값이 LEE인 갯수를 return함.
        }
    }

    


    public static char[][] board = new char[50][50];
    public static int n, m, cnt = 0;
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            String str = sc.next();
            for(int j = 0 ; j < m ; j++){
                board[i][j] = str.charAt(j);
            }
        } // 판 입력
            
        if(n < 3 && m < 3){
            System.out.print(cnt);
            System.exit(0);
        }
        //

        int cnt = 0;

        for(int i = 0 ; i < n ; i++){      //수직, j가 (m-2)미만일 때는 대각선 아래도 가능.
            for(int j = 0 ; j < m ; j++){
                cnt += judgmentDiaDown(i, j) + judgmentDiaUp(i, j) + judgmentHor(i, j) + judgmentVec(i, j); //현재 위치에서 만족하는 것의 개수를 다 더함.
            } // 범위 조건은 각 함수의 조건문에서 가장 앞에 있으므로 상관없음.
        }

        System.out.print(cnt);
    }
}