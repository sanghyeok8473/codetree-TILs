import java.util.Scanner;

class intWrapper{

    int value;

    public intWrapper(int n){
        this.value = n;
    }
}

public class Main {

    public static void cal(intWrapper a, intWrapper b){
        int temp = 0;

        if(a.value > b.value){
            a.value*=2;
            b.value+=10;
        }
        else{
            b.value*=2;
            a.value+=10;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        intWrapper n = new intWrapper(a);
        intWrapper m = new intWrapper(b);

        cal(n, m);
        
        a = n.value;
        b = m.value;

        System.out.print(a+" "+b);
    }
}