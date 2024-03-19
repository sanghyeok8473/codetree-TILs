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
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        else
            return f(n-1) + f(n/3);
    }


    public static void main(String[] args) {
        int n = sc.nextInt();
        

        System.out.print(f(n));
    }
}