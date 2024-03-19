import java.util.Scanner;

class intWrapper{

    int value;

    public intWrapper(int n){
        this.value = n;
    }
}

public class Main {
    public static int n;
    public static int[] arr = new int[11];
    public static Scanner sc = new Scanner(System.in);

    public static int lcm(int a, int b){
        int gcd = 1;

        for(int i = 1 ; i <= Math.min(a, b) ; i++ ){
            if(a%i == 0 && b%i == 0)
                gcd = i;
        }

        return (a*b)/gcd;
    }  

    public static int getlcm(int idx){
        if(idx == 1)
            return arr[1];

        return lcm(getlcm(idx-1), arr[idx]);
    }


    public static void main(String[] args) {
        int n = sc.nextInt();

        for(int i = 1 ; i <= n ; i++ )
            arr[i] = sc.nextInt();

        

        System.out.print(getlcm(n));
    }
}

/*import java.util.Scanner;

class intWrapper{

    int value;

    public intWrapper(int n){
        this.value = n;
    }
}

public class Main {
    public static int n;
    public static Scanner sc = new Scanner(System.in);

    public static int gcd(int a, int b){
        int gcd = 1;

        for(int i = 1 ; i <= Math.min(a, b) ; i++ ){
            if(a%i == 0 && b%i == 0)
                gcd = i;
        }
        return gcd;
    }  

    public static int lcm(int[] arr, int n){
        if(n==0)
            return arr[0];

        int gcd = gcd(arr[n], arr[n-1]);

        if(n==1)
            return (arr[1]*arr[0])/gcd;

        arr[n-1] = (arr[n]*arr[n-1])/gcd;  // 두 수의 최소공배수는 두 수의 곱을 두 수의 최대공약수로 나눈 수이다.


        return lcm(arr, n-1);
    }


    public static void main(String[] args) {
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++ )
            arr[i] = sc.nextInt();

        

        System.out.print(lcm(arr, n-1));
    }
}*/