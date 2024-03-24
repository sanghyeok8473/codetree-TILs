import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a_pos = new int[1000001];
        int[] b_pos = new int[1000001];

        int v, t;

        int a_nowIdx = 1, b_nowIdx = 1;

        for(int i = 0 ; i < n ; i++){
            v = sc.nextInt();
            t = sc.nextInt();

            for(int j = a_nowIdx ; j < a_nowIdx + t ;j++){
                a_pos[j] = a_pos[j - 1] + v;
            }

            a_nowIdx += t;
            
        }

        for(int i = 0 ; i < m ; i++){
            v = sc.nextInt();
            t = sc.nextInt();

            for(int j = b_nowIdx ; j < b_nowIdx + t ;j++){
                b_pos[j] = b_pos[j - 1] + v;
            }

            b_nowIdx += t;
            
        }

        int cnt = 0, leader = 0;

        for(int i = 1; i < a_nowIdx ; i++){ // a가 leader면 1, b가 leader면 2, 같이 leader면 3
            if(a_pos[i] > b_pos[i]){
                if(leader != 1)
                    cnt++;
                leader =1;
            }
            else if(a_pos[i] < b_pos[i]){
                if(leader != 2)
                    cnt++;
                leader = 2;
            }
            else{
                if(leader != 3)
                    cnt++;
                leader = 3;
            }
        } // 현재 leader값이 바뀔 leader값과 다르면 명예의 전당에 변화가 생긴거이므로 cnt에 1을 더함
        System.out.print(cnt);
        
            
    }
}