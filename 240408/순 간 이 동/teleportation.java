import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int a, b, x, y, min = 500;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        a = sc.nextInt(); b = sc.nextInt(); x = sc.nextInt(); y = sc.nextInt(); 

        min = Math.min(min,(Math.abs(a-x)+Math.abs(b-y)));  // x로 가서 순간이동 후 이동
        min = Math.min(min,(Math.abs(a-y)+Math.abs(b-x)));  // y로 가서 순간이동 후 이동
        min = Math.min(min,(Math.abs(b-a)));                // 그냥 이동

        System.out.print(min);
        
    }
}