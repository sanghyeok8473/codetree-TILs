import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int offset = 100;

        int n = sc.nextInt();
        int[][] arr = new int[201][201];
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];

        for(int i = 0 ; i < n ; i++){
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();

            x1[i]+=offset;
            y1[i]+=offset;
            x2[i]+=offset;
            y2[i]+=offset;
        }


        for(int i = 0 ; i < n ; i++){
            for(int x = x1[i] ; x < x2[i] ; x++){
                for(int y = y1[i] ; y < y2[i] ; y++){
                    if( i%2 == 0 )
                        arr[x][y] = 1; // 빨간색 = 1
                    else
                        arr[x][y] = 2; // 파란색 = 2
                }
            }
        }

        int cnt = 0;

        for(int x = 0 ; x < 201 ; x++){
            for(int y = 0 ; y < 201 ; y++){
                if( arr[x][y] == 2 )
                    cnt++;
            }
        }

        System.out.print(cnt);

    }
}