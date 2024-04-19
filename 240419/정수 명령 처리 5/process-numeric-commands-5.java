import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        
        ArrayList<Integer> nums = new ArrayList<>();
        
        for(int i = 0 ; i < n ; i++){
            String order = sc.next();
            if(order.equals("size")){
                System.out.println(nums.size());
            }
            if(order.equals("get")){
                int order_num = sc.nextInt();
                System.out.println(nums.get(order_num-1));
            }
            if(order.equals("push_back")){
                int order_num = sc.nextInt();
                nums.add(order_num);
            }
            if(order.equals("pop_back")){
                nums.remove(nums.size()-1);
            }
        }
    }
}