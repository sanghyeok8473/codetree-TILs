import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int offset = 1000000;

        char[] A_dir = new char[n];
        int[] A_move = new int[n];

        char[] B_dir = new char[m];
        int[] B_move = new int[m];
        

        int A_sum = 0, B_sum = 0;

        for(int i = 0 ; i < n ; i++){
            A_dir[i] = sc.next().charAt(0);
            A_move[i] = sc.nextInt();
            A_sum += A_move[i];
        }
        int[] A_timeplace = new int[A_sum+1];

        for(int i = 0 ; i < m ; i++){
            B_dir[i] = sc.next().charAt(0);
            B_move[i] = sc.nextInt();
            B_sum += B_move[i];
        }
        int[] B_timeplace = new int[B_sum+1];
            
        int A_nowIdx = 1;
        int B_nowIdx = 1;


        for(int i = 0 ; i < n ; i++){
            if(A_dir[i] == 'L'){
                for(int j = A_nowIdx ; j < A_nowIdx + A_move[i] ; j++){
                    A_timeplace[j] = A_timeplace[j-1] -1;
                }
                A_nowIdx += A_move[i];
            }
            else{
                for(int j = A_nowIdx ; j < A_nowIdx + A_move[i] ; j++){
                    A_timeplace[j] = A_timeplace[j-1] + 1;
                }
                A_nowIdx += A_move[i];
            }
        }

        for(int i = 0 ; i < m; i++){
            if(B_dir[i] == 'L'){
                for(int j = B_nowIdx ; j < B_nowIdx + B_move[i] ; j++){
                    B_timeplace[j] = B_timeplace[j-1] -1;
                }
                B_nowIdx += B_move[i];
            }
            else{
                for(int j = B_nowIdx ; j < B_nowIdx + B_move[i] ; j++){
                    B_timeplace[j] = B_timeplace[j-1] + 1;
                }
                B_nowIdx += B_move[i];
            }
        }
        
        int min = Math.min(A_sum + 1, B_sum + 1);

        for(int i = 1 ; i < min ; i++){
            if(A_timeplace[i] == B_timeplace){
                System.out.print(i);
                break;
            }
            if(A_timeplace[i] != B_timeplace && i==min-1){
                System.out.print(-1);
            }
        }

            
    }
}