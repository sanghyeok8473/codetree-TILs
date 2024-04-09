import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int lx, ly, bx, by, rx, ry, result = 0;

    public static char[][] board = new char[10][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0 ; i < 10 ; i++){
            String str = sc.next();
            for(int j = 0 ; j < 10 ; j++){
                board[i][j] = str.charAt(j);
                if(board[i][j] == 'L'){
                    lx = i ; ly = j;
                }
                if(board[i][j] == 'R'){
                    rx = i ; ry = j;
                }
                if(board[i][j] == 'B'){
                    bx = i ; by = j;
                }
            }
        }
        if((lx == rx && rx == bx) && ((ry < ly && ry > by) || (ry < by && ry > ly)))
            result = Math.abs(lx-bx)+Math.abs(ly-by)-1 + 2;
        else if((ly == ry && ry == by) && ((rx < lx && rx > bx) || (rx < bx && rx > lx)))
            result = Math.abs(lx-bx)+Math.abs(ly-by)-1 + 2;
        else
            result = Math.abs(lx-bx)+Math.abs(ly-by)-1;

        System.out.print(result);
        
    }
}