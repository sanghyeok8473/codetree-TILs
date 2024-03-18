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

    public static void printDown(int n){
        if(n==0)
            return;

        System.out.print(n+" ");
        printDown(n-1);
    }


    public static void printUp(int n){
        if(n==0)
            return;

        printUp(n-1);
        System.out.print(n+" ");

    }

    public static void main(String[] args) {
        N = sc.nextInt();


        printUp(N);
        System.out.println();
        printDown(N);
    }
}