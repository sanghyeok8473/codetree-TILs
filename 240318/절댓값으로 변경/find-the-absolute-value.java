import java.util.Scanner;

class intWrapper{

    int value;

    public intWrapper(int n){
        this.value = n;
    }
}

public class Main {

    public static void jeol(int[] arr2){
        for(int i = 0 ; i < arr2.length ; i++){
            if(arr2[i] < 0)
                arr2[i]*=-1;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for(int i = 0 ; i < N ; i++)
            arr[i] = sc.nextInt();

        jeol(arr);
        
        for(int i = 0 ; i < arr.length ; i++){
            System.out.print(arr[i]+" ");
        }


        
    }
}