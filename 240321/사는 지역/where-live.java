import java.util.Scanner;
import java.util.Arrays;

class inform {
    String name;
    String addr;
    String city;

    public inform(String n, String a, String c){
        this.name = n;
        this.addr = a;
        this.city = c;
    }
};

public class Main {
    public static int n;
    public static int[] a  = new int[101];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        inform[] I3 = new inform[N];

        for(int i = 0 ; i < N ; i++ ){
            String n = sc.next();
            String a = sc.next();
            String c = sc.next();

            I3[i] = new inform(n, a, c);
        }

        String[] Name = new String[N];

        int idx = 0;

        for(int i = 0 ; i < N ; i++ ){
            Name[i] = I3[i].name;
        }

        Arrays.sort(Name);

        for(int i = 0 ; i < N ; i++ ){
            if(I3[i].name == Name[N-1]){
                System.out.println("name "+I3[i].name);
                System.out.println("addr "+I3[i].addr);
                System.out.println("city "+I3[i].city);
            }
        }
    }
}