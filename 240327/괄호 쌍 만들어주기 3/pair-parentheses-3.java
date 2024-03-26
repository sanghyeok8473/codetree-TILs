import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();

        int cnt = 0;
        int len = A.length();
        
        for(int i = 0 ; i < len ; i++){
            if(A.charAt(i)==')')
                continue;
            for(int j = i+1 ; j < len ; j++){
                if(A.charAt(j)==')')
                    cnt++;
            }
        }

        System.out.print(cnt);
            

    }
}