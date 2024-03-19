import java.util.Scanner;

class intWrapper{

    int value;

    public intWrapper(int n){
        this.value = n;
    }
}

public class Main {
    public static int n;
    public static int allmul = 1;
    public static Scanner sc = new Scanner(System.in);

    /*public static int minValue(int n){
        if(n==0)
            return arr[0];

        return Math.min(arr[n] , minValue(n-1));
    }

    public static int maxValue(int n){
        if(n==0)
            return arr[0];

        return Math.max(arr[n] , maxValue(n-1));
    }

    public static int gcd(){
        int gcd = 1;

        for(int i = minValue(n-1) ; i <= maxValue(n-1) ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                if(arr[j] % i != 0)
                    break;
                gcd = i;
            }
        }
        return gcd;
    } // 최소공배수는 최대공약수의 배수이다.*/

    public static int allmul(int[] arr){
        for( int i = 0 ; i < arr.length ; i++ ){
                allmul *= arr[i];
        }
        return allmul;
    }

    

    public static int lcm(int[] arr, int n){
        int lcm = allmul(arr) / arr[n];

        for(int i = 0 ; i < n ; i++ ){
            if(lcm % arr[i] != 0){
                break;
            }
            return lcm;
        }

        if(n == 0)
            return allmul(arr);

        return Math.min(allmul(arr), lcm(arr, n-1));
    }


    public static void main(String[] args) {
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++ )
            arr[i] = sc.nextInt();

        

        System.out.print(lcm(arr, n-1));
    }
}