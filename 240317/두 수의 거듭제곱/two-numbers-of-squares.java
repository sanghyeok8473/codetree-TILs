import java.util.Scanner;

public class Main {
    public static void nprint(int a, int b){

        int n = 1;

        for( int i = 0 ; i < b ; i ++){
            n *= a;
        }

        System.out.print(n);

    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        nprint(a, b);

    }
}