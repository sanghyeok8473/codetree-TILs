import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, m, p, cnt = 0;
    public static char[] c = new char[100];
    public static int[] u = new int[100];
    public static int[] checkedUser = new int[26]; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt(); m = sc.nextInt(); p = sc.nextInt();

        for(int i = 1 ; i <= m ; i++){
            c[i] = sc.next().charAt(0);
            u[i] = sc.nextInt();
        }

        if(u[p] == 0){                      // 모든 사람 출력
            for(int i = 0 ; i < n ; i++){  
                char nowC = (char)(i+65);
                System.out.print(nowC+" ");
            }
            System.exit(0);
        }
        
        for(int i = p ; i <= m ; i++){  // 확실하게 메세지를 읽을사람을 확인하는 코드
            int nowUser = c[i] - 'A';
            checkedUser[nowUser] = 1;
        }
        for(int i = p ; i <= m ; i++){      // 만약 직전 메시지를 읽지 않은 사람과 현재 메시지를 읽지 않은 사람이 같으면,
            int nowUser = c[i-1] - 'A';     // 직전에 메시지를 보낸사람이 나가지 않아야만 가능한 상황임.
            if(u[i] == u[i-1]){             // 왜냐하면 직전에 보낸 사람의 조건과 직후에 보낸 사람의 조건이 같기때문.
                checkedUser[nowUser] = 1;   // 예시의 경우, B가 만약에 보내고 바로 나갔으면 절대 개수가 같을 수 없음(안읽은 사람이 하나 늘어야함.)
            }
        }

        for(int i = 0 ; i < n ; i++){
            if(checkedUser[i] == 0){
                char nowC = (char)(i+65);
                System.out.print(nowC+" ");
            }
        }

        
        


        


    }
}