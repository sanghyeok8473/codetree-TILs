import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s = new Stack<>();
        int n = sc.nextInt();
        
        for(int i = 0 ; i < n ; i++){
            String str =sc.next();

            if(str.equals("push")){
                int now = sc.nextInt();
                s.push(now);
            }
            if(str.equals("pop")){
                System.out.println(s.pop());
            }
            if(str.equals("size")){
                System.out.println(s.size());
            }
            if(str.equals("empty")){
                if(s.empty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            if(str.equals("top")){
                System.out.println(s.peek());
            }
        }
    }
}