import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int n = sc.nextInt();
        
        for(int i = 0 ; i < n ; i++){
            String str = sc.next();

            if(str.equals("push")){
                int now = sc.nextInt();
                q.add(now);
            }
            if(str.equals("pop")){
                System.out.println(q.poll());
            }
            if(str.equals("size")){
                System.out.println(q.size());
            }
            if(str.equals("empty")){
                if(q.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            if(str.equals("front")){
                System.out.println(q.peek());
            }
        }
    }
}