import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        char[] before_sorted = str.toCharArray();

        Arrays.sort(before_sorted);

        String sortedstr = new String(before_sorted);

        System.out.print(sortedstr);

        

    }
}