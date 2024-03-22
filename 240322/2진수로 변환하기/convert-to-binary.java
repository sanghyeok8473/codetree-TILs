import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] digits = new int[100];
        int cnt = 0;

        while(n >= 2){
            digits[cnt] = n % 2;
            n /= 2;
            cnt++;
        }
        digits[cnt] = n;

        for(int i = cnt; i >= 0 ; i--){
            System.out.print(digits[i]);
        }
            
    }
}