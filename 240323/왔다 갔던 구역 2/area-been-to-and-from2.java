import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, x, sum;
        char O;

        int idx = 100;

        n = sc.nextInt();

        int[] block = new int[201];

        for(int i = 0 ; i < n ; i++ ){
            x = sc.nextInt();
            O = sc.next().charAt(0);

            if(O == 'R'){
                for(int j = idx ; j < idx + x ; j++){
                    block[j]++;
                }
                idx += x;
            }
            else{
                for(int j = idx ; j > idx - x ; j--){
                    block[j]++;
                }
                idx -= x;
            }
        }

        sum = 0;

        for(int i = 0 ; i < 201 ; i++ ){
            if(block[i] >= 2)
                sum++;
        }
        System.out.print(sum);

        
    }
}