import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
                           //E  N   W  S

        int nx = 0;
        int ny = 0;
        int dirNum = 3;

       
        String dir =  sc.next();
        
        for(int i = 0 ; i < 100000 ; i++){
            if(i == dir.length())
                break;
            else if( dir.charAt(i) == 'L'){
                dirNum = (dirNum + 3) % 4;
            }
            else if( dir.charAt(i) == 'R'){
                dirNum = (dirNum + 1) % 4;
            }
            else if( dir.charAt(i) == 'F'){
                nx += dx[dirNum];
                nx += dy[dirNum];
            }
        }
        
        System.out.print(nx+" "+ny);
        
            
        

    }
}