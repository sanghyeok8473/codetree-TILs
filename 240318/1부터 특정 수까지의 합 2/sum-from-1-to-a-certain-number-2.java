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

    public static int printsum(int n){
        if(n==1)
            return 1;

        return n + printsum(n-1);

    }

    public static void main(String[] args) {
        N = sc.nextInt();


        System.out.print(printsum(N));
    }
}