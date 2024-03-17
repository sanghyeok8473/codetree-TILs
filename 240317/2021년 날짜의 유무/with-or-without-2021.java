import java.util.Scanner;

public class Main {
    public static boolean existDay(int m, int d){
        
        if(m == 2){
            if(d>=1 && d<=28)
                return true;
            else
                return false;
        }
        else if(m<=7 && m>=1 && m%2 ==1){
            if(d>=1 && d<=31)
                return true;
            else
                return false;
        }
        else if(m<=7 && m>=1 && m%2 == 0){
            if(d>=1 && d<=30)
                return true;
            else
                return false;
        }
        else if(m>=8 && m<=12 && m%2 == 0){
            if(d>=1 && d<=31)
                return true;
            else
                return false;
        }
        else if(m>=8 && m<=12 && m%2 == 1){
            if(d>=1 && d<=30)
                return true;
            else
                return false;
        }

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