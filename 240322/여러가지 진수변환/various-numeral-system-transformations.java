import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();
        int cnt = 0;

        int[] digits = new int[200];

        while(true){
            if( N < B ){
                digits[cnt] = N;
                break;
            }

            digits[cnt++] = N % B;
            N /= B;

        }
        for(int i = cnt ; i >= 0 ; i--)
            System.out.print(digits[i]);
        
        
        
            
    }
}