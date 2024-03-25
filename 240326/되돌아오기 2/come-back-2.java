import java.util.Scanner;

public class Main {
    /*public static boolean inRange(int x, int y){
        return (x>=0 && x<n && y>=0 && y<n);
    }*/

    public static int rotate(char c){
        if(c == 'L')
            return (dirNum + 3) % 4;
        else
            return (dirNum + 1) % 4;
    }

    public static int t=0, x=0, y=0, dirNum = 3;
    public static String order;
    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};
                                     //E  N   W  S
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        order = sc.next();
        boolean comeback = false;


        for(int i = 0 ; i < order.length() ; i++){
            char nowOrder = order.charAt(i);

            if(nowOrder != 'F'){
                dirNum = rotate(nowOrder);
                t++;
            }
            else{
                x += dx[dirNum]; y += dy[dirNum];
                t++;
            }
            if(x==0 && y==0){
                comeback = true;
                break;
            }
        }
        
        if(comeback == true)
            System.out.print(t);
        else
            System.out.print(-1);
    }
}