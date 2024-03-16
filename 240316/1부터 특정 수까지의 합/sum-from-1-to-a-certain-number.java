import java.util.Scanner;

public class Main {
    public static int newprint(int n){

        int result = 0;

        for(int i = 1 ; i <= n; i++){
            result += i;
        }
        
        return result/10;
            
    }   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.print(newprint(n));
            
        

    }
}