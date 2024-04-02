import java.util.Scanner;

public class Main {
    public static int a, b, c, nowSum = 0, maxSum = 0;
    public static int[] nums = new int[101], tmp = new int[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt(); 

        for(int i = 0 ; i <= c/a ; i++){     // (c/a)*a는 a를 1씩 높여가며 곱했을때 c에 가장 가까운 c이하의 수임
            for( int j = 0 ; j <= c/b ; j++ ){  // (c/a)*a는 a를 1씩 높여가며 곱했을때 c에 가장 가까운 c이하의 수임
                nowSum = a*i + b*j;
                if(nowSum <= c)
                    maxSum = Math.max(maxSum, nowSum);
            } 
        }


        System.out.print(maxSum);

    }
}