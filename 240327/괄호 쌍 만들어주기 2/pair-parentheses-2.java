import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();

        int cnt = 0;
        int len = A.length();
        
        for(int i = 0 ; i < len-3 ; i++){
            if(A.charAt(i)=='(' && A.charAt(i+1)=='('){
                for(int j = i+2 ; j < len-1 ; j++){
                    if(A.charAt(j)==')' && A.charAt(j+1)==')'){
                        cnt++;
                    }
                }
            }
            
        }

        System.out.print(cnt);
            

    }
}