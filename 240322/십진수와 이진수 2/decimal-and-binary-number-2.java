import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String N  = sc.next();
        int cnt = 0, num = 0;

        for(int i = 0 ; i < N.length(); i++ ){
            num = num*2 + (N.charAt(i) - '0');
        }

        num *= 17;
        

        int[] digits = new int[200];

        while(true){
            if( num < 2 ){
                digits[cnt] = num;
                break;
            }

            digits[cnt++] = num % 2;
            num /= 2;

        }
        for(int i = cnt ; i >= 0 ; i--)
            System.out.print(digits[i]);
        
        
        
            
    }
}