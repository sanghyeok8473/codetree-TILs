import java.util.Scanner;

public class Main {
    public static int cnt = 0;
    public static int[][] board = new int[3][3];

    public static boolean checkVec(int x, int y){
        int xSum, ySum;
        for(int i = 0 ; i < 3 ; i++){
            xSum = 0; ySum = 0;
            for(int j = 0 ; j < 3 ; j++){
                if(board[j][i] == x)
                    xSum++;
                if(board[j][i] == y)
                    ySum++;
            }
            if(ySum != 0 && xSum != 0 && ySum + xSum == 3)
                return true;
        }
        return false;   
    }

    public static boolean checkHor(int x, int y){
        int xSum, ySum;
        for(int i = 0 ; i < 3 ; i++){
            xSum = 0; ySum = 0;
            for(int j = 0 ; j < 3 ; j++){
                if(board[i][j] == x)
                    xSum++;
                if(board[i][j] == y)
                    ySum++;
            }
            if(ySum != 0 && xSum != 0 && ySum + xSum == 3)
                return true;
        }
        return false;
    }

    public static boolean checkDia(int x, int y){
        int xSum, ySum;
        xSum = 0; ySum = 0;
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(i == j && board[i][j] == x)
                    xSum++;
                if(i == j && board[i][j] == y)
                    ySum++;
            }
        }
        if(ySum != 0 && xSum != 0 && ySum + xSum == 3)
            return true;
        xSum = 0; ySum = 0;
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(i+j==2 && board[i][j] == x)
                    xSum++;
                if(i+j==2 && board[i][j] == y)
                    ySum++;
            }
        }
        if(ySum != 0 && xSum != 0 && ySum + xSum == 3)
            return true;

        return false;
    }

    public static boolean checkWin(int x, int y){
        if(checkVec(x, y))
            return true;
        if(checkHor(x,y))
            return true;
        if(checkDia(x,y))
            return true;
        
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < 3 ; i++){
            int now = sc.nextInt();
            board[i][0] = now/100;
            board[i][1] = (now/10)%10;
            board[i][2] = now%10;
        }

        for(int i = 1 ; i <= 8 ; i++){  // 첫 번째 사람의 숫자
            for(int j = i+1 ; j <= 9 ; j++){  // 두 번째 사람의 숫자
                if(checkWin(i,j))
                    cnt++;
            }
        }
        System.out.print(cnt);
    }
}