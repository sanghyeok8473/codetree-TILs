import java.util.Scanner;

public class Main {
    public static int x, y, cnt = 0;

    public static int checkNums(int x){ //자리수를 반환해주는 재귀함수
        if(x < 10)
            return 1;
        
        return checkNums(x/10) + 1;
    }

    public static boolean palindrome(int x){
        int nums = checkNums(x);
        int y = x;
        int[] nowNums = new int[nums + 1];
        int[] nowPalindrome = new int[nums + 1];

        for(int i = 1 ; i < nums ; i++){
            int div = (int)Math.pow(10,nums-i);
            nowNums[i] = x/div;
            x -= nowNums[i]*div;
        }
        nowNums[nums] = x;

        for(int i = 1 ; i <= nums ; i++){
            nowPalindrome[i] = y%10;
            y /= 10;
        }
        for(int i = 1 ; i <= nums ; i++){
            if(nowNums[i] != nowPalindrome[i]){
                return false;
            } 
        }
        return true;
            
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt(); y = sc.nextInt();

        for(int i = x ; i <= y ; i++){
            if(palindrome(i))
                cnt++;
        }
        System.out.print(cnt);
    }
}