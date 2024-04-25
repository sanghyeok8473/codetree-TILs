import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> s = new Stack<>();
        String str =sc.next();
        
        for(int i = 0 ; i < str.length() ; i++){
            char now = str.charAt(i);
            if(now == '('){
                s.push(now);
            }
            else{
                if(s.empty()){
                    System.out.print("No");
                    System.exit(0);
                }
                s.pop();
            }
        }
        if(s.size() > 0)
            System.out.print("No");
        else
            System.out.print("Yes");
        
    }
}