import java.util.Scanner;

public class Main {
    public static int n, maxX = 1, maxY = 1, minX = 100, minY = 100, 
    quad1 = 0, quad2 = 0, quad3 = 0, quad4 = 0, nowMax, finalMin = 101; 
    /*사분면은 2  1
               3  4      */
    public static int quadrant(int x, int y, int nowX, int nowY){
        if(nowX > x &&  nowY > y) // 1사분면
            return 1;
        else if(nowX < x &&  nowY > y) // 2사분면
            return 2;
        else if(nowX < x &&  nowY < y) // 3사분면
            return 3;
        else if(nowX > x &&  nowY < y) // 4사분면
            return 4;

        return 0;
    }

    public static int quaMax(int q1, int q2, int q3, int q4){
        int max = q1;
        max = Math.max(max, q2);
        max = Math.max(max, q3);
        max = Math.max(max, q4);
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int[][] seg = new int[n][2];

        for(int i = 0 ; i < n ; i++){
            seg[i][0] = sc.nextInt();
            seg[i][1] = sc.nextInt();

            maxX = Math.max(seg[i][0], maxX);
            minX = Math.min(seg[i][0], minX);
            maxY = Math.max(seg[i][1], maxY);
            minY = Math.min(seg[i][1], minY);
        }
        if(maxX == minX || maxY == minY){
            System.out.print(n/2);
            System.exit(0);
        }
        for(int i = minX+1 ; i < maxX ; i+=2 ){
            for(int j = minY+1 ; j < maxY ; j+=2){
                quad1 = 0; quad2 = 0; quad3 = 0; quad4 = 0;
                for(int k = 0 ; k < n ; k++){
                    int nowX = seg[k][0], nowY = seg[k][1];
                    if(quadrant(i, j, nowX, nowY) == 1)
                        quad1++;
                    else if(quadrant(i, j, nowX, nowY) == 2)
                        quad2++;
                    else if(quadrant(i, j, nowX, nowY) == 3)
                        quad3++;
                    else if(quadrant(i, j, nowX, nowY) == 4)
                        quad4++;
                }
                nowMax = quaMax(quad1, quad2, quad3, quad4);
                finalMin = Math.min(finalMin, nowMax);
            }
        }
        System.out.print(finalMin);

        

    }
}