import java.util.Scanner;

class intWrapper{

    int value;

    public intWrapper(int n){
        this.value = n;
    }
}

public class Main {

    public static String a;
    public static String b;

    public static int include(String n, String m){
        int N = n.length();
        int M = m.length();

        for( int i = 0 ; i <= N-M ; i++ ){
            if(n.substring(i, i+M).equals(m)){
                return i;
            }  
        }

        return -1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.next();
        b = sc.next();

        System.out.print(include(a, b));
    }
}