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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        for(int i = 0 ; i < 3 ; i++)
            men[i] = sc.nextInt();

        Arrays.sort(men);
        if(checkEnd()){
            System.out.print(cnt);
            System.exit(0);
        }
        // 간격이 더 작은쪽의 끝이 간격이 더 큰쪽의 끝-1로 이동하면됨.
        while(true){
            Arrays.sort(men);

            int one = men[1] - men[0];
            int two = men[2] - men[1];

            if(checkEnd()){
                System.out.print(cnt);
                break;
            }
            if(one > two){                      // one과 two가 둘다 1일순 없음(둘다 1이면 checkEnd에서 끝났을 것.)
                men[2] = men[1] - 1;            // 또한 two는 2, 3도 아님( 2나 3이면 위에서 끝났을 것.) 즉 4이상임.
                cnt++;
                continue;
            }
            else if(two >= one){
                men[0] = men[2] - 1;
                cnt++;
                continue;
            }
        }
        
    }
}