import java.util.Scanner;
import java.util.*;

public class Main {
    public static int[][] board = new int [100][100];
    public static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = sc.nextInt();
            }
        }
        // 입력 파트

        for(int i = 0 ; i < n ; i++){
            boolean check = false;
            for(int j = 0 ; j < n-1 ; j++){
                if(board[i][j] ==  board[i][j+1]){
                    int nowCheck = board[i][j];
                    for(int k = j ; k < j + m ; k++){
                        if(board[i][k] != nowCheck){
                            check = false;
                            break;
                        }
                        if(k == j+m-1)
                            check = true;
                    }
                }
                if(check){
                    answer++;
                    break;
                }
            }
        }

        for(int j = 0 ; j < n ; j++){
            boolean check = false;
            for(int i = 0 ; i < n-1 ; i++){
                if(board[i][j] ==  board[i+1][j]){
                    int nowCheck = board[i][j];
                    for(int k = i ; k < i + m ; k++){
                        if(board[k][j] != nowCheck){
                            check = false;
                            break;
                        }
                        if(k == i+m-1)
                            check = true;
                    }
                }
                if(check){
                    answer++;
                    break;
                }
            }
        }

        System.out.print(answer);
    }
}