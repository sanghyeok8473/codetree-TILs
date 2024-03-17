import java.util.Scanner;

public class Main {
    public static boolean check(int n){

        if(n==1)
            return false;

        for(int i = 2 ; i < n ; i++){
            if(n%i==0){
                return false;
            }  
        }

        return true;

    }   

    public static int newsum(int a, int b){

        int sum= 0;

        for( int i = a ; i <= b ; i++){
            if(check(i)){
                sum+=i;
            }
        }
            
        return sum;
    }   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(newsum(a,b));

    }
}