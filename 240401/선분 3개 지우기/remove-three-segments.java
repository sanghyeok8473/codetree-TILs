import java.util.Scanner;

public class Main {
    public static int n, ans = -1, nowCnt = 0;
    public static int[][] seg = new int[101][101];

    public static int countSegments(int x, int y, int z){
        int[] counts = new int[101];
        for(int i = 0 ; i < n ; i++){
            if(i == x || i == y || i == z)
                continue;
            int x1 = seg[i][0], x2 = seg[i][1];
            for(int j = x1 ; j <= x2; j++)
                counts[j]++;
        }
        for(int i = 0 ; i < 101 ; i++){
            if(counts[i]>=2)
                return 0;
        }
            

        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            seg[i][0] = sc.nextInt();
            seg[i][1] = sc.nextInt();
        }

        for(int i = 0 ; i < n-2 ; i++){
            for(int j = i+1; j < n-1 ; j++){
                for(int k = j+1 ; k < n ; k++){
                    nowCnt += countSegments(i,j,k);
                }
            }

        }
        System.out.println(nowCnt);


    }
}