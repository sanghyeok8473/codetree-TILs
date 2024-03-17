import java.util.Scanner;


public class Main {

    public static boolean palindrome(String s){

        String pali = "";

        int len = s.length();

        for(int i = len - 1 ; i >=0 ; i--){
            pali += s.charAt(i);
        }

        for(int i = 0 ; i < len ; i++){
            if(pali.charAt(i) != s.charAt(i))
                return false;
        }

        return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String  A = sc.next();
        
        if(palindrome(A))
            System.out.print("Yes");
        else
            System.out.print("No");

    }
}