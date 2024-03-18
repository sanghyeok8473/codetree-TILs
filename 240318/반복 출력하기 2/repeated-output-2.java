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


    public static void printHello(int n){
        if(n==0)
            return;

        printHello(n-1);
        System.out.println("HelloWorld");

    }

    public static void main(String[] args) {
        N = sc.nextInt();


        printHello(N);
    }
}