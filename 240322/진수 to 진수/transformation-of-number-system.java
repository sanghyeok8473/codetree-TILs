import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();

        String n  = sc.next();
        int cnt = 0, num = 0;

        for(int i = 0 ; i < n.length(); i++ ){
            num = num*a + (n.charAt(i) - '0');
        } // a진수로 표현된 n을 10진수로 변환(num)
        

        int[] digits = new int[200];

        while(true){
            if( num < b ){
                digits[cnt] = num;
                break;
            }

            digits[cnt++] = num % b;
            num /= b;

        } // 10진수인 num을 b진수로 변경
        for(int i = cnt ; i >= 0 ; i--)
            System.out.print(digits[i]);
        
        
        
            
    }
}