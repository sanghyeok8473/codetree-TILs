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
                for(int j = nowIdx ; j < nowIdx + move[i] ; j++){
                    block[j]++;
                }
                nowIdx += move[i];
            }
            else if(dir[i] == 'L'){
                for(int j = nowIdx - 1 ; j >= nowIdx - move[i] ; j--){
                    block[j]++;
                }
                nowIdx -= move[i];
            }
        } // 입력받는 부분까지는 문제없음.

        sum = 0;

        for(int i = 0 ; i < 2001 ; i++ ){ // 2이상인 것의 개수를 구하고, 크기가 나눠지는 횟수를 빼면 됨. 크기를 나누는 횟수를 어떻게 잡을지 고민.
            if(block[i] >= 2){
                sum ++;
            }
        }
        System.out.println(sum);
        
        

        
    }
}