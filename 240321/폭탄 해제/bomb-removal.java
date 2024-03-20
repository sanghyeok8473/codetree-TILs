import java.util.Scanner;
import java.util.Arrays;

class bomb {
    String code;
    char color;
    int second;

    public bomb(String code, char color, int second){
        this.code = code;
        this.color = color;
        this.second = second;
    }
};

public class Main {
    public static int n;
    public static int[] a  = new int[101];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String code = sc.next();
        char color = sc.next().charAt(0);
        int second = sc.nextInt();

        bomb Bomb = new bomb(code, color, second);

        
        System.out.println("code : "+Bomb.code);
        System.out.println("color : "+Bomb.color);
        System.out.print("second : "+Bomb.second);
    }
}