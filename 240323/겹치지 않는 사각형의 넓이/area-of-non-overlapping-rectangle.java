import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int offset = 1000;

        int[][] arr = new int[2001][2001];

        for(int i = 0 ; i < 3 ; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            x1+=offset;
            y1+=offset;
            x2+=offset;
            y2+=offset;


            for(int j = x1 ; j < x2 ; j++){
                for(int k = y1 ; k < y2 ; k++){
                    arr[j][k] = i+1;
                }
            }

        }

        
        int cnt = 0;

        for(int i = 0 ; i < 2001 ; i++){
            for(int j = 0 ; j < 2001 ; j++){
                if(arr[i][j] == 1 || arr[i][j] == 2)
                    cnt++;
            }
        }

        System.out.print(cnt);

    }
}