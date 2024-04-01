import java.util.Scanner;

public class Main {
    public static int x, y, cnt = 0;

    public static int checkNums(int x){ //자리수를 반환해주는 재귀함수
        if(x < 10)
            return 1;
        
        return checkNums(x/10) + 1;
    }
    public static boolean checkInterest(int x){
        int nums = checkNums(x);
        int[] nowNums = new int[nums + 1];
        for(int i = 1 ; i < nums ; i++){
            int div = (int)Math.pow(10,nums-i);
            nowNums[i] = x/div;
            x -= nowNums[i]*div;
        }
        nowNums[nums] = x;
        int cnt = 0, check = nowNums[1];
        for(int i = 1 ; i <= nums ; i++){
            if(nowNums[i] != check)
                cnt++;
        }
        if(cnt == 1)
            return true;
        else if(cnt == nums-1){
            int check2 = nowNums[2];
            for(int i = 2 ; i <= nums ; i++){
                if(nowNums[i] != check2)
                    return false;
            }
            return true;
        }
        else
            return false;
            
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt(); y = sc.nextInt();

        for(int i = x ; i <= y ; i++){
            if(checkInterest(i))
                cnt++;
        }
        System.out.print(cnt);
    }
}