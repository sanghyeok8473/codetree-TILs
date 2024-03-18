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

    public static int include(){
        int alen = a.length();
        int blen = b.length();

        for( int i = 0 ; i <= alen-blen ; i++ ){
            if(a.substring(i, i+blen).equals(b)){
                return i;
            }  
        }

        return -1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.next();
        b = sc.next();

        System.out.print(include());
    }
}