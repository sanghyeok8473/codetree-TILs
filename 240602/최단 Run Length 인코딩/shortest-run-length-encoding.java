import java.util.Scanner;
import java.util.*;

public class Main {
    public static int n, min = 20;
    public static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        str = sc.next(); n = str.length();

        char[] s = str.toCharArray();
        
        for(int cnt = 0 ; cnt < n-1 ; cnt++){
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
        int len = 2; boolean first = false;
        for(int i = 0 ; i < s.length-1 ; i++){
            if(s[i] != s[i+1]){
                if(first == false)
                    first = true;
                if(first == true){
                    len += 2;
                }
            }
        }
        if(s[s.length-1] != s[s.length-2])
            len += 2;
        
        return len;
    }
}