import java.util.Scanner;

class intWrapper{

    int value;

    public intWrapper(int n){
        this.value = n;
    }
}

public class Main {
    public static int N, cnt = 0;
    public static Scanner sc = new Scanner(System.in);

    public static int fibo(int n){
        if(n == 1 || n == 2)
            return 1;
        else if(n>=3)
            return fibo(n-2) + fibo(n-1);
        else
            return 0;
    }


    public static void main(String[] args) {
        N = sc.nextInt();


        System.out.print(fibo(N));
    }
}