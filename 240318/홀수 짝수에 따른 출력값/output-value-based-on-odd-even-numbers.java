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

    public static int f(int n){
        if(n < 1)
            return 0;
        
        return f(n-2) + n;
    }


    public static void main(String[] args) {
        n = sc.nextInt();


        System.out.print(f(n));
    }
}