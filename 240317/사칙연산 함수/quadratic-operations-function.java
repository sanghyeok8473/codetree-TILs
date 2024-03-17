import java.util.Scanner;

public class Main {
    public static int cal(int a, char c, int b){

        if(c == '*'){
           return a*b;
        }
        else if(c == '+'){
            return a+b;
        }
        else if(c == '-'){
            return a-b;
        }
        else if(c == '/'){
            return a/b;
        }

        return 0;

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        char c = sc.next().charAt(0);
        int b = sc.nextInt();

        if(c == '*'){
            System.out.printf("%d * %d = %d", a, b, cal(a,c,b));
        }
        else if(c == '+'){
            System.out.printf("%d + %d = %d", a, b, cal(a,c,b));
        }
        else if(c == '-'){
            System.out.printf("%d - %d = %d", a, b, cal(a,c,b));
        }
        else if(c == '/'){
            System.out.printf("%d / %d = %d", a, b, cal(a,c,b));
        }
        else{
            System.out.print("False");
        }

    }
}