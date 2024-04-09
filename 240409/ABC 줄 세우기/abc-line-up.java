import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, cnt = 0;
    public static char[] alphabet = new char[26];

    // 해결 아이디어 : for문으로 i를 잡고, i와 i+1이 있을때, 앞은 맞고 뒤는 틀리면 넘어감. 
    // 아니면 A부터 맨 앞으로 옮겨주고, 그다음인 B를 제 위치로 옮겨주고 C를보고 그런순으로?

    public static boolean checkEnd(){
        for(int i = 0 ; i < n ; i++){
            if((char)(i+65) != alphabet[i])
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++)
            alphabet[i] = sc.next().charAt(0);

        for(int i = 0 ; i < n ; i++){
            if(checkEnd()){
                System.out.print(cnt);
                break;
            }
            char now = (char)(i+65);
            int nowIdx = 0;
            for(int j = i ; j < n ; j++){       // 잘못되어있는 위치를 찾음.
                if(alphabet[j] == now){ 
                    nowIdx = j;
                    break;
                }
            }
            for(int j = nowIdx ; j >= i+1 ; j--){
                alphabet[j] = alphabet[j-1];
            }
            alphabet[i] = now;
            cnt += nowIdx - i;
        }
    }
}