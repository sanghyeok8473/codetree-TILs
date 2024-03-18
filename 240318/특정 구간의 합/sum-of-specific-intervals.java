import java.util.Scanner;

class intWrapper{

    int value;

    public intWrapper(int n){
        this.value = n;
    }
}

public class Main {
    public static int n, m, a1, a2, sum;
    public static int[] arr = new int[100];
    public static Scanner sc = new Scanner(System.in);


    public static int cal(){
        a1 = sc.nextInt();
        a2 = sc.nextInt();

        sum = 0;

        for(int i = a1-1 ; i < a2 ; i++)
            sum+=arr[i];

        return sum;

    }

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        for( int i = 0 ; i < m ; i++){
            System.out.println(cal());
        }
    }
}