import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n = 0, k = 0;
    public static String[] str  = new String[101];
    public static String[] after_Str  = new String[101];
    public static String T;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        T = sc.next();

        int len = T.length();
        

        for(int i = 1 ; i <= n ; i++ ){
            str[i] = sc.next();
        }

        int idx = 1;

        for(int i = 1 ; i <= n ; i++ ){
            if( str[i].substring(0, len).equals(T) ){
                after_Str[idx] = str[i];
                idx++;
            }
        }

        Arrays.sort(after_Str, 1, idx);

        System.out.print(after_Str[k]);
    }
}