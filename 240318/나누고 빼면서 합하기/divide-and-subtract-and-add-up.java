import java.util.Scanner;

class intWrapper{

    int value;

    public intWrapper(int n){
        this.value = n;
    }
}

public class Main {
    public static int n, m;
    public static Scanner sc = new Scanner(System.in);

    public static int cal(){
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        int sum = 0;

        while(m>0){
            sum += arr[m-1];

            if(m%2==0)
                m/=2;
            else
                m-=1;
        }

        return sum;

    }

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();

        

        System.out.print(cal());
    }
}