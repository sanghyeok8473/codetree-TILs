import java.util.*;

public class Main {
    public static int n, m;
    public static int[][] board;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); m = sc.nextInt();
        board = new int[n][n];
        for(int i = 0 ; i < n ; i++)
            for(int j = 0 ; j < n ; j++)
                board[i][j] = sc.nextInt();
        // 입력 파트

        for(int i = 0 ; i < m ; i++){
            change();
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++)
                System.out.print(board[i][j]+" ");
            System.out.println();
        }
    }

    public static void change(){
        for(int nowNum = 1 ; nowNum <= n*n ; nowNum++){
            int[] XandY = returnXandY(nowNum);
            int nowX = XandY[0], nowY = XandY[1]; // nowNum의 위치를 반환
            int[] maxXandY = maxXandY(nowX, nowY);
            int maxX = maxXandY[0], maxY = maxXandY[1];

            int temp = board[nowX][nowY];
            board[nowX][nowY] = board[maxX][maxY];
            board[maxX][maxY] = temp;
        }
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

    public static int[] returnXandY(int x){
        int returnX = 0, returnY = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == x){
                    returnX = i; returnY = j;
                }
            }
        }
        return new int[] { returnX, returnY };
    }

    public static int[] maxXandY(int x, int y){ // 주변 8방향에서 가장 큰 숫자를 찾아 리턴해주는 함수
        int max = 0, maxX = 0, maxY = 0;
        if(rangeValid(x-1, y-1)){
            if(board[x-1][y-1] > max){
                max = board[x-1][y-1];
                maxX = x-1; maxY = y-1;
            }
        }
        if(rangeValid(x-1, y)){
            if(board[x-1][y] > max){
                max = board[x-1][y];
                maxX = x-1; maxY = y;
            }
        }
        if(rangeValid(x-1, y+1)){
            if(board[x-1][y+1] > max){
                max = board[x-1][y+1];
                maxX = x-1; maxY = y+1;
            }
        }
        if(rangeValid(x, y-1)){
            if(board[x][y-1] > max){
                max = board[x][y-1];
                maxX = x; maxY = y-1;
            }
        }
        if(rangeValid(x, y+1)){
            if(board[x][y+1] > max){
                max = board[x][y+1];
                maxX = x; maxY = y+1;
            }
        }
        if(rangeValid(x+1, y-1)){
            if(board[x+1][y-1] > max){
                max = board[x+1][y-1];
                maxX = x+1; maxY = y-1;
            }
        }
        if(rangeValid(x+1, y)){
            if(board[x+1][y] > max){
                max = board[x+1][y];
                maxX = x+1; maxY = y;
            }
        }
        if(rangeValid(x+1, y+1)){
            if(board[x+1][y+1] > max){
                max = board[x+1][y+1];
                maxX = x+1; maxY = y+1;
            }
        }
        return new int[] { maxX, maxY };
    }
    

    public static boolean rangeValid(int r, int c){
        return (r >= 0 && r < n && c >= 0 && c < n);
    }
}