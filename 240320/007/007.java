import java.util.Scanner;
import java.util.Arrays;

class information {
    String code;
    char place;
    int time;

    public information(String code, char place, int time){
        this.code = code;
        this.place = place;
        this.time = time;
    }
};

public class Main {
    public static int n;
    public static int[] a  = new int[101];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String c = sc.next();
        char p = sc.next().charAt(0);
        int t = sc.nextInt();

        information inform1 = new information(c, p, t);
        System.out.printf("secret code : %s\nmeeting point : %c\ntime : %d", inform1.code, inform1.place, inform1.time);
    }
}