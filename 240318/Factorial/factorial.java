import java.util.Scanner;

class intWrapper{

    int value;

    public intWrapper(int n){
        this.value = n;
    }
}

public class Main {
    public static int n;
    public static Scanner sc = new Scanner(System.in);

    public static int factorial(int n){
        if(n<=1)
            return 1;
        
        return factorial(n-1) * n;
    }


    public static void main(String[] args) {
        n = sc.nextInt();


        System.out.print(factorial(n));
    }
}