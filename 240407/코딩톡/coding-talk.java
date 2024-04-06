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

        if(u[p] == 0){                      // 0이라는 건 모든 사람이 다 읽었다는 뜻임. 따라서 0출력
            System.out.print("");
            System.exit(0);
        }
        
        for(int i = p ; i <= m ; i++){  // 확실하게 메세지를 읽을사람을 확인하는 코드(p번째 포함 확실하게 등장하는 사람)
            int nowUser = c[i] - 'A';
            checkedUser[nowUser] = 1;
        }

        if(p!= 1 && u[p] == u[p-1]){             // 입력받은 질문과 직전 질문이 같으면 반드시 어디서부터 이어져 온건지 확인
            int idx = 0;
            for(int i = p-2 ; i >= 1; i--){
                if(u[i] != u[p]){
                    idx = i+1;
                    break;
                }
                if(i == 1)
                    idx = 1;
            }
            for(int i = idx ; i <= p-1 ; i++){
                int nowUser = c[i] - 'A';
                checkedUser[nowUser] = 1;       // 1은 반드시 들어가야 한다는 뜻.
            }
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