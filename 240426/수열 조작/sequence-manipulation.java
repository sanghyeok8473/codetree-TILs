import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> dq = new ArrayDeque<>();
        int n = sc.nextInt();

        for(int i = 1 ; i <= n ; i++){
            dq.addLast(i);
        }
        
        while(dq.size() > 1){
            dq.pollFirst();
            dq.addLast(dq.peekFirst());
            dq.pollFirst();
        }
        System.out.print(dq.pollFirst());
    }
}