import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int offset = 100;

        int n = sc.nextInt();
        int[][] arr = new int[201][201];

        for(int i = 0 ; i < n ; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = x1 + 8;
            int y2 = y1 + 8;

            x1+=offset;
            y1+=offset;
            x2+=offset;
            y2+=offset;


            for(int x = x1 ; x < x2 ; x++){
                for(int y = y1 ; y < y2 ; y++){
                    arr[x][y]++;
                }
            }

        }

        
        int cnt = 0;

        for(int x = 0 ; x < 201 ; x++){
            for(int y = 0 ; y < 201 ; y++){
                if(arr[x][y] > 0)
                    cnt++;
            }
        }

        System.out.print(cnt);

    }
}