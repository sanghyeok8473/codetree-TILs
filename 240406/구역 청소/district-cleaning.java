import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, k, minCost = 10000*100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c, d;
        
        a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt(); d = sc.nextInt();
        
        if(b<=c || d<=a)                        // 구역이 겹치지 않는 경우
            System.out.print((b-a) + (d-c));
        else if(a <= c && d >= b)
            System.out.print(d-a);
        else if(a <= c && b >= d)
            System.out.print(b-a);
        else if(c <= a && d >= b)
            System.out.print(d-c);
        else if(c <= a && b >= d)
            System.out.print(b-c);

    }
}