import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int[] date = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int elapsedDate1 = 0;
        int elapsedDate2 = 0;

        for( int i = 0 ; i < m1 ; i++){
            elapsedDate1 += date[i];
        }
        elapsedDate1 += d1;

        for( int i = 0 ; i < m2 ; i++){
            elapsedDate2 += date[i];
        }
        elapsedDate2 += d2;

        int elapsedtime = elapsedDate2 - elapsedDate1;

        System.out.print(elapsedtime);

    }
}