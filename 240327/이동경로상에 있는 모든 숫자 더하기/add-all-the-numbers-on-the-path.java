import java.util.Scanner;

public class Main {
    public static boolean inRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }

    public static int n, t, x, y, dirNum;
    public static String str;
    public static int[] dx = new int[]{0, 1, 0, -1};
    public static int[] dy = new int[]{1, 0, -1, 0};
                                     //E  S   W  N
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        t = sc.nextInt();
        
        str = sc.next();

        int[][] arr = new int[n][n];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = sc.nextInt();
            }
        } // 입력 부분

        x = y = (n-1)/2;
        dirNum = 3; // 초기 위치와 방향 설정(정중앙, 북쪽)

        int sum = arr[x][y]; // 시작위치를 포함한 합이므로 시작위치의 값으로 시작.

        for(int i = 0 ; i < t ; i++){
            char nowOrder = str.charAt(i); // 매번 str.charAt(i)를 쓰기 번거로우니 nowOrder라는 변수를 선언.
            
            if(nowOrder == 'L')
                dirNum = (dirNum + 3) % 4;
            else if(nowOrder == 'R')
                dirNum = (dirNum + 1) % 4; // L이나 R일때는 방향만 바꿔주면 됨.
            else{  //L이나 R이 아니면 F임. 전진을 할때는 
                int nx = x + dx[dirNum], ny = y + dy[dirNum];
                if(inRange(nx, ny)){ // 현재방향으로 전진을 할 때 그 값이 격자범위 안이면, 좌표를 업데이트하고 해당 좌표의 값을 더함.
                    x = nx; y = ny;
                    sum += arr[x][y];
                }
            }
        }
        System.out.print(sum);
    }
}