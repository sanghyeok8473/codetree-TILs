import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, x, sum;
        char O;

        n = sc.nextInt();

        int[] block = new int[2001];
        int[] move = new int[n];
        char[] dir = new char[n];

        for(int i = 0 ; i < n ; i++ ){
            move[i] = sc.nextInt();
            dir[i] = sc.next().charAt(0);
        }

        int nowIdx = 1000;

        for(int i = 0 ; i < n ; i++ ){
            if(dir[i] == 'R'){
                for(int j = nowIdx ; j < nowIdx + move[i] ; j++){
                    block[j]++;
                }
                nowIdx += move[i];
            }
            else if(dir[i] == 'L'){
                for(int j = nowIdx - move[i] ; j < nowIdx ; j++){
                    block[j]++;
                }
                nowIdx -= move[i];
            }
        } 

        sum = 0;

        for(int i = 0 ; i < 2001 ; i++ ){ 
            if(block[i] >= 2){
                sum ++;
            }
        }
        System.out.println(sum);
        
        

        
    }
}