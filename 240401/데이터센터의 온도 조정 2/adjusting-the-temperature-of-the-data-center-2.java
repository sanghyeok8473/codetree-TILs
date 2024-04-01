import java.util.Scanner;

public class Main {
    public static int n, c, g, h, max = -1, min = 1001, nowSum = 0, maxSum = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); c = sc.nextInt(); g = sc.nextInt(); h = sc.nextInt();

        int[][] seg = new int[n][2];

        for(int i = 0 ; i < n ; i++){
            seg[i][0] = sc.nextInt();
            seg[i][1] = sc.nextInt();

            min = Math.min(min, seg[i][0]);
            max = Math.max(max, seg[i][1]);
        }
        
        for(int i = min ; i <= max ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i < seg[j][0])
                    nowSum += c;
                else if(i >= seg[j][0] && i <= seg[j][1])
                    nowSum += g;
                else
                    nowSum += h;
            }
            maxSum = Math.max(maxSum, nowSum);
            nowSum = 0;
        }
        
        System.out.print(maxSum);
    }
}