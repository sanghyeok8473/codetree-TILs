import java.util.Scanner;

public class Main {
    //길이가 무한하다면 숫자들부터 받아서 배열에 넣고 배열들의 합을 구하자. R일때는 더하고, L일때는 빼면서 가장 큰 좌표가 몇이였는지를 구해서 배열크기 구하자. 
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
                for(int j = nowIdx ; j <= nowIdx + move[i] ; j++){
                    block[j]++;
                }
                nowIdx += move[i];
            }
            else if(dir[i] == 'L'){
                for(int j = nowIdx ; j >= nowIdx - move[i] ; j--){
                    block[j]++;
                }
                nowIdx -= move[i];
            }
        }

        sum = 0;

        for(int i = 0 ; i < 2001 ; i++ ){
            if(block[i] >= 2){
                int idx = i;
                while(true){
                    if(block[idx] >= 2){
                        idx++;
                    }  
                    else
                        break;
                }
                idx--;
                sum += (idx - i);
                i = idx;
            }
        }

        for(int i = 988 ; i <= 1003 ; i++){
            System.out.print(block[i]);
        }
        
        

        
    }
}