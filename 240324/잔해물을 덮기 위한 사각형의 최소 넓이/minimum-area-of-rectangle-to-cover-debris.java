import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 만약 두번째 직사각형이 첫번째 직사각형을 한 줄로 깔끔하게 지우면 지워지고 남은부분이 정답, 아니면 첫 직사각형의 원래 넓이가 정답
        Scanner sc = new Scanner(System.in);
        int offset = 1000;

        int[][] arr = new int[2001][2001];
        int[] x1 = new int[2];
        int[] y1 = new int[2];
        int[] x2 = new int[2];
        int[] y2 = new int[2];

        for(int i = 0 ; i < 2 ; i++){
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i]= sc.nextInt();

            x1[i]+=offset;
            y1[i]+=offset;
            x2[i]+=offset;
            y2[i]+=offset;
        }

        int cnt = 0;

        for(int i = 0 ; i < 2 ; i++){
            for(int x = x1[i] ; x < x2[i] ; x++){
                for(int y = y1[i] ; y < y2[i] ; y++){
                    if(i == 0)
                        arr[x][y] = 1;
                    else
                        arr[x][y] = 0;
                }
            }
        }

        for(int x = 0 ; x < 2001 ; x++){
            for(int y = 0 ; y < 2001 ; y++ ){
                if(arr[x][y]>0)
                    cnt++;
            }
        } // 한줄로 깔끔하게 지워졌을 때를 대비해 지워지고 남은 부분의 넓이를 구해둠

        int first = 0;

        for(int x = x1[0] ; x < x2[0] ; x++){
            for(int y = y1[0] ; y < y2[0] ; y++){
                first++;
            }
        } // 두번째 직사각형이 첫 직사각형을 전부 포함하거나 직사각형의 모양이 나오지 않게 일부만 지웠을때를 대비한 원래 넓이를 구해둠.

        //첫 직사각형의 넓이가 답이 아닌경우 : 첫번째 직사각형이 한줄로 깔끔하게 지워진 경우. 첫번째 직사각형의 중간부분만 한줄로 지워도 정답은 cnt임

        if(x1[0] >= x1[1] && x2[0] <= x2[1]){
            if( y1[0] == y1[1] && y2[0] == y2[1] )
                System.out.print(first);
            else if( y1[0] >= y1[1] && y2[0] >= y2[1] ){
                System.out.print(cnt);
            }
            else if( y1[0] <= y1[1] && y2[0] <= y2[1] ){
                System.out.print(cnt);
            }
        }
        else if(y1[0] >= y1[1] && y2[0] <= y2[1]){
            if( x1[0] == x1[1] && x2[0] == x2[1] )
                System.out.print(first);
            else if( x1[0] >= x1[1] && x2[0] >= x2[1] ){
                System.out.print(cnt);
            }
            else if( x1[0] <= x1[1] && x2[0] <= x2[1] ){
                System.out.print(cnt);
            }
        }
        else
            System.out.print(first);
    }
}