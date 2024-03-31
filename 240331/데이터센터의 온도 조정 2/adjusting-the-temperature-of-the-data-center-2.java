import java.util.Scanner;

public class Main {
    public static int n, c, g, h, max = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); c = sc.nextInt(); g = sc.nextInt(); h = sc.nextInt();

        int[] score  = new int[1001];       //온도가 idx일때의 점수를 나타냄.

        for(int i = 0 ; i < n ; i++){
            int Ta = sc.nextInt();
            int Tb = sc.nextInt();

            for(int j = 0 ; j < 1001 ; j++){
                if(j < Ta)
                    score[j] += c;
                else if(j >= Ta && j <= Tb)
                    score[j] += g;
                else
                    score[j] += h;
            }
        }
        for(int i = 0 ; i < 1001 ; i++)
            max = Math.max(max, score[i]);
        
        System.out.print(max);
    }
}