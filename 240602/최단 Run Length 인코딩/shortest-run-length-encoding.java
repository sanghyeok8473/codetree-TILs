import java.util.Scanner;
import java.util.*;

public class Main {
    public static int n, min = 20;
    public static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        str = sc.next(); n = str.length();

        char[] s = str.toCharArray();

        if(allSame(s)){
            if(n==10){
                System.out.print(3);
                System.exit(0);
            }
            else{
                System.out.print(2);
                System.exit(0);
            }
        }
        
        for(int cnt = 0 ; cnt < n ; cnt++){
            char temp = s[n-1];
            for(int i = n-1 ; i >= 1 ; i--){
                s[i] = s[i-1];
            }
            s[0] = temp;
            min = Math.min(min, RLE(s));
        }
        System.out.print(min);
    }

    public static int RLE(char[] s){
        int len = 2;
        for(int i = 0 ; i < n-1 ; i++){
            if(s[i] != s[i+1]){
                len += 2;
            }
        }
        return len;
    }

    public static boolean allSame(char[] s){
        boolean nowAllSame = true;
        for(int i = 0 ; i < n-1 ; i++){
            if(s[i] != s[i+1])
                nowAllSame = false;
        }
        return nowAllSame;
    }
}