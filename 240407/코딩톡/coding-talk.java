import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, m, p, cnt = 0;
    public static char[] c = new char[100];
    public static int[] u = new int[100];
    public static int[] checkedUser = new int[26]; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt(); m = sc.nextInt(); p = sc.nextInt();

        for(int i = 1 ; i <= m ; i++){
            c[i] = sc.next().charAt(0);
            u[i] = sc.nextInt();
        }
        
        for(int i = p ; i <= m ; i++){
            int nowUser = c[i] - 'A';
            checkedUser[nowUser] = 1;
        }
        for(int i = 0 ; i < n ; i++){
            if(checkedUser[i] == 0){
                char nowC = (char)(i+65);
                System.out.print(nowC+" ");
            }
        }

        
        


        


    }
}