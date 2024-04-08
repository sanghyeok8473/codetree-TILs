import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int n, max = -1, cnt;
    public static int[] f = new int[100];
    public static int[] s = new int[100];
    public static String[] check = new String[]{"가위" , "바위", "보"};
    public static int[][] six = {{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};

    public static void changeNums(int t){
        for(int i = 0 ; i < n ; i++){
            f[i] = six[t][f[i]-1];
            s[i] = six[t][s[i]-1];
        }
    }


    public static int checkWins(int a, int b){
        if(check[a].equals("가위") && check[b].equals("보"))
            return 1;
        if(check[a].equals("바위") && check[b].equals("가위"))
            return 1;
        if(check[a].equals("보") && check[b].equals("바위"))
            return 1;
        
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            f[i] = sc.nextInt();
            s[i] = sc.nextInt();
        }
        for(int t = 0 ; t < 6 ; t++){
            changeNums(t);
            cnt = 0;
            for(int i = 0 ; i < n ; i++){
                if(s[i] == f[i])
                    continue;
            
                int nowF = f[i]-1, nowS = s[i] - 1;
                cnt += checkWins(nowF, nowS);
            }
            max = Math.max(max, cnt);
        }
        System.out.print(max);
    }
}