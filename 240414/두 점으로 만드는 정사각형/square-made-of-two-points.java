import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, m, cnt = 0, nowCnt = 0, max = 1, finalMin = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt(); int y1 = sc.nextInt(); int x2 = sc.nextInt(); int y2 = sc.nextInt(); 
        int a1 = sc.nextInt(); int b1 = sc.nextInt(); int a2 = sc.nextInt(); int b2 = sc.nextInt(); 
        

        int xMin = Math.min(x1, a1); int xMax = Math.max(x2, a2);
        int yMin = Math.min(y1, b1); int yMax = Math.max(y2, b2);

        int x = Math.max((xMax-xMin),(yMax-yMin));

        System.out.print(x*x);
        
    }
    
}