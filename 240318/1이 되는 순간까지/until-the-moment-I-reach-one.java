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

    public static int f(int n){
        if(n==1)
            return 0;

        if(n%2==0){
            return 1 + f(n/2);
        }
            
        else{  
            return 1 + f(n/3);
        }

    }

    public static void main(String[] args) {
        N = sc.nextInt();


        System.out.print(f(N));
    }
}