import java.util.Scanner;

public class Main {
    public static int n, nowDist, distMin = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[] x = new int[n], y = new int[n];                                                                                                                                                         

        for(int i = 0 ; i < n ; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n-1 ; i++){ // 첫 번째 점의 좌표
            for(int j = i+1 ; j < n ; j++){ // 두 번째 점의 좌표
                nowDist = (x[i]-x[j])*(x[i]-x[j]) + (y[i]-y[j])*(y[i]-y[j]);
                distMin = Math.min(distMin, nowDist);
            }  
        }

        System.out.print(distMin);


    }
}