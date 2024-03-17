import java.util.Scanner;

public class Main {
    public static boolean include(int[] a, int[] b){
        int alen = a.length;
        int blen = b.length;

        for(int i = 0; i <= alen-blen ; i++){
            if(a[i] == b[0]){
                for(int j = 0 ; j < blen ; j++){
                    if(a[i + j] == b[j]){
                        if(j == blen-1)
                            return true;
                    }
                    else
                        break;
                }
            }
        }

        return false;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        int[]A = new int[n1];
        int[]B = new int[n2];

        for(int i = 0 ; i < n1; i++){
            A[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n2; i++){
            B[i] = sc.nextInt();
        }

        if(include(A, B))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}