import java.util.Scanner;

public class Main {
    public static boolean lastDay(int m){
        if (m==2)
            return 28;
        else if(m== 4|| m==6 || m==9 || m==11)
            return 30;

        return 31;
    }

    public static boolean existDay(int m, int d){

        if(m>=1 && m<=12 && d>=1 && d<=lastDay(m))
            return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int D = sc.nextInt();

        if(existDay(M, D))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}