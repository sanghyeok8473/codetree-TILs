import java.util.Scanner;


public class Main {

    public static void div(int[] arr2){

        for(int i = 0 ; i<arr2.length ; i++){
            if(arr2[i]%2==0)
                arr2[i]/=2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for ( int i = 0 ; i < N ; i++){
            arr[i] = sc.nextInt();
        }
        

        div(arr);

        for( int i = 0 ; i < N ; i++){
            System.out.print(arr[i]+" ");
        }


    }
}