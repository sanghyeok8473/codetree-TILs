import java.util.Scanner;

public class Main {
    public static int newprint(int a, int b, int c){

        int min = 101;

        int[] arr = new int[3]{a, b, c};

        for(int i = 0 ; i < 3 ; i++){
            if(min > arr[i])
                min = arr[i];
        }
        
        return min;
            
    }   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.print(newprint(a, b, c));
            
        

    }
}