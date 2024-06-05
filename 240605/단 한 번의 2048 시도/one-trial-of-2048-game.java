import java.util.Scanner;
import java.util.*;

public class Main {
    public static char dir;
    public static int[][] board = new int[4][4], temp= new int[4][4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        for(int i = 0 ; i < 4 ; i++)
            for(int j = 0 ; j < 4 ; j++)
                board[i][j] = sc.nextInt();
        dir = sc.next().charAt(0); // 입력 파트

        gravity(dir);
        combine(dir);

        for(int i = 0 ; i < 4 ; i++){
            for(int j = 0 ; j < 4 ; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
    public static void combine(char d){
        switch(d){
            case 'L':
                board = combL();
                break;
            case 'R':
                board = combR();
                break;
            case 'U':
                board = combU();
                break;
            case 'D':
                board = combD();
                break;
        }
    }

    public static void gravity(char d){
        switch(d){
            case 'L':
                board = gravL();
                break;
            case 'R':
                board = gravR();
                break;
            case 'U':
                board = gravU();
                break;
            case 'D':
                board = gravD();
                break;
        }
    }

    public static int[][] gravL(){
        int[][] tempL = new int[4][4];
        for(int i = 0 ; i < 4 ; i++){
            int idx = 0;
            for(int j = 0 ; j < 4 ; j++){
                if(board[i][j] != 0){
                    tempL[i][idx] = board[i][j];
                    idx++;
                }
            }
        }
        return tempL;
    }

    public static int[][] gravR(){
        int[][] tempR = new int[4][4];
        for(int i = 0 ; i < 4 ; i++){
            int idx = 3;
            for(int j = 3 ; j >= 0 ; j--){
                if(board[i][j] != 0){
                    tempR[i][idx] = board[i][j];
                    idx--;
                }
            }
        }
        return tempR;
    }

    public static int[][] gravU(){
        int[][] tempU = new int[4][4];
        for(int j = 0 ; j < 4 ; j++){
            int idx = 0;
            for(int i = 0 ; i < 4 ; i++){
                if(board[i][j] != 0){
                    tempU[idx][j] = board[i][j];
                    idx++;
                }
            }
        }
        return tempU;
    }

    public static int[][] gravD(){
        int[][] tempD = new int[4][4];
        for(int j = 0 ; j < 4 ; j++){
            int idx = 3;
            for(int i = 3 ; i >= 0 ; i--){
                if(board[i][j] != 0){
                    tempD[idx][j] = board[i][j];
                    idx--;
                }
            }
        }
        return tempD;
    }

    public static int[][] combL(){
        temp = new int[4][4];
        for(int i = 0 ; i < 4 ; i++){
            int idx = 0;
            for(int j = 0 ; j < 3 ; j++){
                if(board[i][j] != board[i][j+1]){
                    temp[i][idx] = board[i][j];
                    idx++;
                    if(j == 2)
                        temp[i][j+1] = board[i][j+1];
                }
                else{
                    board[i][j] += board[i][j+1];
                    board[i][j+1] = 0;
                    board = gravL();
                    temp[i][idx] = board[i][j];
                    idx++;
                }
            }
        }
        return temp;
    }

    public static int[][] combR(){
        temp = new int[4][4];
        for(int i = 0 ; i < 4 ; i++){
            int idx = 3;
            for(int j = 3 ; j > 0 ; j--){
                if(board[i][j] != board[i][j-1]){
                    temp[i][idx] = board[i][j];
                    idx--;
                    if(j == 1)
                        temp[i][j-1] = board[i][j-1];
                }
                else if (board[i][j] == board[i][j-1]){
                    board[i][j] += board[i][j-1];
                    board[i][j-1] = 0;
                    board = gravR();
                    temp[i][idx] = board[i][j];
                    idx--;
                }
            }
        }
        return temp;
    }

    public static int[][] combU(){
        temp = new int[4][4];
        for(int j = 0 ; j < 4 ; j++){
            int idx = 0;
            for(int i = 0 ; i < 3 ; i++){
                if(board[i][j] != board[i+1][j]){
                    temp[idx][j] = board[i][j];
                    idx++;
                    if(i == 2)
                        temp[i+1][j] = board[i+1][j];
                }
                else{
                    board[i][j] += board[i+1][j];
                    board[i+1][j] = 0;
                    board = gravU();
                    temp[idx][j] = board[i][j];
                    idx++;
                }
            }
        }
        return temp;
    }

    public static int[][] combD(){
        temp = new int[4][4];
        for(int j = 0 ; j < 4 ; j++){
            int idx = 3;
            for(int i = 3 ; i > 0 ; i--){
                if(board[i][j] != board[i-1][j]){
                    temp[idx][j] = board[i][j];
                    idx--;
                    if(i == 1)
                        temp[i-1][j] = board[i-1][j];
                }
                else{
                    board[i][j] += board[i-1][j];
                    board[i-1][j] = 0;
                    board = gravD();
                    temp[idx][j] = board[i][j];
                    idx--;
                }
            }
        }
        return temp;
    }
    
}