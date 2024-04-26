import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int n = sc.nextInt(), k = sc.nextInt();

        for(int i = 1 ; i <= n ; i++)
            q.add(i);
        
        while(q.size() > 0){
            for(int i = 0 ; i < k-1 ; i++){
                q.add(q.peek());
                q.poll();
            }
            System.out.print(q.poll()+" ");
        }
    }
}