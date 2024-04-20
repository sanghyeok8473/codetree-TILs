import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LinkedList<Integer> nums = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            String order = sc.next();
            if(order.equals("size")){
                System.out.println(nums.size());
            }
            if(order.equals("empty")){
                if(nums.isEmpty())
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            if(order.equals("push_front")){
                int order_num = sc.nextInt();
                nums.addFirst(order_num);
            }
            if(order.equals("push_back")){
                int order_num = sc.nextInt();
                nums.addLast(order_num);
            }
            if(order.equals("pop_front")){
                System.out.println(nums.pollFirst());
            }
            if(order.equals("pop_back")){
                System.out.println(nums.pollLast());
            }
            if(order.equals("front")){
                System.out.println(nums.peekFirst());
            }
            if(order.equals("back")){
                System.out.println(nums.peekLast());
            }
        }
    }
}