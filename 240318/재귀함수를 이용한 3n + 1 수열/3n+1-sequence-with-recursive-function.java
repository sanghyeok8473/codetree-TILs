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
        if(n == 1)
            return 0;
        else if(n%2 == 0)
            return 1+f(n/2);
        else
            return 1+f(3*n+1);
    }


    public static void main(String[] args) {
        int n = sc.nextInt();
        

        System.out.print(f(n));
    }
}