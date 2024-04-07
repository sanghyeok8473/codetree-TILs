import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int cnt = 0;
    public static int[] men = new int[3];

    public static boolean checkEnd(){
        if(men[2] == men[1]+1 && men[1] == men[0]+1)
            return true;
        
        return false;
    }


    // 3차이가 나는 숫자가 있으면, 반드시 한쪽 숫자와 1차이나게 그 쪽으로 이동해야함(그러면 6 8 9(6 7 9) 처럼 되고,)
    // 6 7 8(7 8 9)로 해서 끝남.
    // 2차이면 이동하면 끝남.

    // 그럼 그 전에는, 차이가 더 큰쪽을 줄이는 방향으로 이동시키면 됨.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0 ; i < 3 ; i++)
            men[i] = sc.nextInt();

        Arrays.sort(men);
        if(checkEnd()){
            System.out.print(cnt);
            System.exit(0);
        }

        while(true){
            Arrays.sort(men);

            int one = men[1] - men[0];
            int two = men[2] - men[1];

            if(checkEnd()){
                System.out.print(cnt);
                break;
            }
            if(one == 2 || two == 2){
                System.out.print(cnt+1);
                break;
            }
            if(one == 3 || two == 3){
                System.out.print(cnt+2);
                break;
            }
            if(one == 1 || one > two){          // one과 two가 둘다 1일순 없음(둘다 1이면 checkEnd에서 끝났을 것.)
                men[0] = men[1] + 2;            // 또한 two는 2, 3도 아님( 2나 3이면 위에서 끝났을 것.) 즉 4이상임.
                cnt++;
                continue;
            }
            else if(two == 1 || two >= one){
                men[2] = men[0] + 2;
                cnt++;
                continue;
            }
        }
        
    }
}