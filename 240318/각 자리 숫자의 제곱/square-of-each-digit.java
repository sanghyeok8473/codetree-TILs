import java.util.Scanner;

class intWrapper{

    int value;

    public intWrapper(int n){
        this.value = n;
    }
}

public class Main {
    public static int N;
    public static Scanner sc = new Scanner(System.in);

    public static int f(int n){
        if(n < 10)
            return n*n;

        return f(n / 10) + (n%10)*(n%10);

    }

    public static void main(String[] args) {
        N = sc.nextInt();


        System.out.print(f(N));
    }
}