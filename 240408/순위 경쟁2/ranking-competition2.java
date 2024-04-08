import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, cnt = 0, nowB = 0, nowA = 0, nowWinner = 2;
    public static char[] c = new char[100];
    public static int[] s = new int[100];

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            c[i] = sc.next().charAt(0);
            s[i] = sc.nextInt();
        }
        // A만 올라가면 0, B만 올라가면 1,  AB가 둘다 올라가면 2;
        for(int i = 0 ; i < n ; i++){
            if(c[i] == 'A')
                nowA += s[i];
            else
                nowB += s[i];

            if(nowA > nowB && nowWinner != 0){
                cnt++;
                nowWinner = 0;
            }
            else if(nowB > nowA && nowWinner != 1){
                cnt++;
                nowWinner = 1;
            }
            else if(nowB == nowA && nowWinner != 2){
                cnt++;
                nowWinner = 2;
            }

        }
        System.out.print(cnt);
    }
}