import java.util.Scanner;

public class Main {
    public static int n, maxDist = 0;
    public static String seats;

    public static int nearest(int x){
        int l = 0, r = 0;
        for(int i = x+1 ; i < n ; i++){
            if(seats.charAt(i)-'0' == 1){
                r = i - x;
                break;
            }
        }
        for(int i = x-1 ; i >= 0 ; i--){
            if(seats.charAt(i)-'0' == 1){
                l = x - i;
                break;
            }
        }

        return Math.min(l, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        seats = sc.next();

        for(int i = 0 ; i < n ; i++){      // 시작위치
            if(seats.charAt(i)-'0' == 1)
                continue;
            maxDist = Math.max(maxDist, nearest(i));
        }
        
        System.out.print(maxDist);
    }
}