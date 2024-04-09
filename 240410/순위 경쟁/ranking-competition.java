import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, cnt = 0, nowB = 0, nowA = 0, nowC=0, nowWinner = 2;
    public static char[] c = new char[100];
    public static int[] s = new int[100];

    public static int status(int a, int b, int c){
        if(a > b && a > c)          // A 단독
            return 1;
        else if(b > a && b > c)          // B 단독
            return 2;
        else if(c > b && c > a)          // C 단독
            return 3;
        else if(a == b && a > c)          // A, B 공동
            return 4;
        else if(a == c && a > b)          // A, C 공동
            return 5;
        else if(b == c && b > a)          // B, C 공동
            return 6;
        else                             // A, B, C 공동
            return 7;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            c[i] = sc.next().charAt(0);
            s[i] = sc.nextInt();
        }
        // A만 올라가면 0, B만 올라가면 1,  AB가 둘다 올라가면 2;
        for(int i = 0 ; i < n ; i++){
            if(c[i] == 'A'){
                if(status(nowA,nowB,nowC) != status(nowA+s[i],nowB,nowC))
                    cnt++;
                nowA += s[i];
            }
            if(c[i] == 'B'){
                if(status(nowA,nowB,nowC) != status(nowA,nowB+s[i],nowC))
                    cnt++;
                nowB += s[i];
            }
            if(c[i] == 'C'){
                if(status(nowA,nowB,nowC) != status(nowA,nowB,nowC+s[i]))
                    cnt++;
                nowC += s[i];
            }

        }
        System.out.print(cnt);
    }
}