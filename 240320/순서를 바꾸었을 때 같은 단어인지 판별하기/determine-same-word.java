import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        

        String a = sc.next();
        String b = sc.next();

        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();

        Arrays.sort(charA);
        Arrays.sort(charB);

        String sorted_a = new String(charA);
        String sorted_b = new String(charB);

        if(sorted_a.equals(sorted_b))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}