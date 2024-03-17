import java.util.Scanner;

class IntWrapper{
    int value;

    public IntWrapper(int n){
        this.value = n;
    }
}

public class Main {
    public static int lastDay(int m){
        if (m==2)
            return 28;
        if(m == 4|| m==6 || m==9 || m==11)
            return 30;

        return 31;
    }

    public static void swap(IntWrapper a, IntWrapper b){

        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        IntWrapper q = new IntWrapper(n);
        IntWrapper w = new IntWrapper(m);
        

        swap(q, w);

        System.out.print(q.value+" "+w.value);


    }
}