import java.util.Scanner;

public class Main {
    public static String season(int m){
        if (m >= 3 && m <= 5)
            return "Spring";
        if (m >= 6 && m <= 8)
            return "Summer";
        if (m >= 9 && m <= 11)
            return "Fall";

        return "Winter";
    }

    public static boolean yoon(int y){
        if(y%400 == 0)
            return true;
        else if(y%100 == 0)
            return false;
        else if(y%4==0)
            return true;

        return false;
    }
    

    public static int lastDay(int y, int m){
        if (m==2 && yoon(y))
            return 29;
        if(m==2 && (yoon(y)==false))
            return 28;
        if(m == 4|| m==6 || m==9 || m==11)
            return 30;

        return 31;
    }

    public static boolean existDay(int y, int m, int d){

        if(m>=1 && m<=12 && d>=1 && d<=lastDay(y, m))
            return true;

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int Y = sc.nextInt();
        int M = sc.nextInt();
        int D = sc.nextInt();

        if(existDay(Y, M, D)==false)
            System.out.print("-1");
        else
            System.out.print(season(M));
    }
}