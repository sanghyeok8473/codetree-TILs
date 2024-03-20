import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static String a;
    public static String b;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        a = sc.next();
        b = sc.next();

        char[] sorted_a = a.toCharArray();
        char[] sorted_b = b.toCharArray();

        Arrays.sort(sorted_a);
        Arrays.sort(sorted_b);

        int len_a = sorted_a.length;
        int len_b = sorted_b.length;

        if(len_a != len_b){
            System.out.print("No");
        }
        else{
            for(int i = 0 ; i < len_a ; i++){
                if(sorted_a[i]!=sorted_b[i]){
                    System.out.print("No");
                    break;
                }
                else if(sorted_a[i]==sorted_b[i] && i==len_a-1)
                    System.out.print("Yes");
            }
        }
    }
}