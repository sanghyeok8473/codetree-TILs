import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] digits = new int[8];

        int num = 0;

        int n = sc.nextInt();

        if( n == 1 )
            System.out.print(1);
        else if( n == 0 )
            System.out.print(0);
        else{
            int i = 1;

            while(true){
                if(n%10 != 0)
                    num += Math.pow(i, n%10);
                n /= 10;
                i*=2;

                if(n<10){
                    num += Math.pow(i, n%10);
                    break;
                }
            }
            System.out.print(num);
        }
        
        
        
            
    }
}