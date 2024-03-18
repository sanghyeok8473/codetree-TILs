import java.util.Scanner;

class intWrapper{

    int value;

    public intWrapper(int n){
        this.value = n;
    }
}

public class Main {
    public static int n;
    public static int max = 0;
    public static int[] arr = new int[101];
    public static Scanner sc = new Scanner(System.in);

    public static int f(int n){
        if(n > 0){
            if(max < arr[n]){
                max = arr[n];
            }
            return f(n-1);
        }
        else
            return max;
    }


    public static void main(String[] args) {
        n = sc.nextInt();

        for( int i = 1 ; i <= n ; i++ ){
            arr[i] = sc.nextInt();
        }


        System.out.print(f(n));
    }
}