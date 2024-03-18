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

    public static void printStar(int n){
        if(n==0)
            return;
        for(int i = 0 ; i < n ; i++){
            System.out.print("* ");
        }
        System.out.println();
        printStar(n-1);
        for(int i = 0 ; i < n ; i++){
            System.out.print("* ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        N = sc.nextInt();


        printStar(N);
    }
}