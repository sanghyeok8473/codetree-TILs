import java.util.Scanner;
import java.util.Arrays;

class codename {
    char code;
    int score;

    public codename(char code, int score){
        this.code = code;
        this.score = score;
    }
};

public class Main {
    public static int n;
    public static int[] a  = new int[101];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        codename[] fiveman = new codename[5];

        int min = 101;
        char min_code = '0';

        for( int i = 0 ; i < 5 ; i++){   
            char code = sc.next().charAt(0);
            int  score= sc.nextInt();

            fiveman[i] = new codename(code, score);
            if(min > score){
                min_code = fiveman[i].code;
                min = fiveman[i].score;
            }
        }

        
        System.out.print(min_code+" "+min);
    }
}