import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> dq = new ArrayDeque<>();
        int n = sc.nextInt();
        
        for(int i = 0 ; i < n ; i++){
            String str = sc.next();

            if(str.equals("push_front")){
                int now = sc.nextInt();
                dq.addFirst(now);
            }
            else if(str.equals("push_back")){
                int now = sc.nextInt();
                dq.addLast(now);
            }
            else if(str.equals("pop_front")){
                System.out.println(dq.pollFirst());
            }
            else if(str.equals("pop_back")){
                System.out.println(dq.pollLast());
            }
            else if(str.equals("size")){
                System.out.println(dq.size());
            }
            else if(str.equals("empty")){
                if(dq.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            else if(str.equals("front")){
                System.out.println(dq.peekFirst());
            }
            else if(str.equals("back")){
                System.out.println(dq.peekLast());
            }
        }
    }
}