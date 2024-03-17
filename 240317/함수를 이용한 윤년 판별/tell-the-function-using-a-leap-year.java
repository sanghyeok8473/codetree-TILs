import java.util.Scanner;

public class Main {
    public static boolean yoon(int n){

        if(n%100 == 0 && n%400!=0)
            return false;
        else if(n%4==0)
            return true;

        return false;

    } 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int y = sc.nextInt();

        System.out.print(yoon(y));

    }
}