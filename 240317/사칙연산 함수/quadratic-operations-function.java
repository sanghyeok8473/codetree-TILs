import java.util.Scanner;

public class Main {
    public static void cal(int a, char c, int b){

        if(c == '*'){
            System.out.printf("%d * %d = %d", a, b, a*b);
        }
        else if(c == '+'){
            System.out.printf("%d + %d = %d", a, b, a+b);
        }
        else if(c == '-'){
            System.out.printf("%d - %d = %d", a, b, a-b);
        }
        else if(c == '/'){
            System.out.printf("%d / %d = %d", a, b, a/b);
        }
        else{
            System.out.print("False");
        }

    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        char c = sc.next().charAt(0);
        int b = sc.nextInt();

        cal(a, c, b);

    }
}