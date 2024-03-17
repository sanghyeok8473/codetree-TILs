import java.util.Scanner;

public class Main {
    public static boolean newcal(int a){
        
        for( int i = 2 ; i < a ; i ++){
            if(a%i==0)
                return false;
        }

        return true;

    }

    public static boolean sumeven(int a){
        
        int sum = 0;

        while(a > 0){
            sum += a%10;

            a /= 10;
        }

        if(sum%2==0)
            return true;
        else
            return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int cnt = 0; 

        for(int i = a ; i<= b; i++){
            if(newcal(i) && sumeven(i))
                cnt++;

        }

        System.out.print(cnt);




    }
}