import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String digits = sc.next();

        int num = 0;

        for(int i = 0 ; i < digits.length(); i++ ){
            num = num*2 + (digits.charAt(i) - '0');
        }

        System.out.print(num);
        
        
        
            
    }
}