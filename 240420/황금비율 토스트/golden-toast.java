import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        LinkedList<Character> bread = new LinkedList<>();
        String order = sc.next();
        for(int i = 0 ; i < n ; i++){
            bread.add(order.charAt(i));
        }

        ListIterator<Character> it = bread.listIterator(bread.size());

        for(int i = 0 ; i < m ; i++){
            char nowOrder = sc.next().charAt(0);
            if(nowOrder == 'L'){
                if(it.hasPrevious())
                    it.previous();
            }
            if(nowOrder == 'R'){
                if(it.hasNext())
                    it.next();
                
            }
            if(nowOrder == 'D'){
                if(it.hasNext()){
                    it.next();
                    it.remove();
                }
            }
            if(nowOrder == 'P'){
                char pOrder = sc.next().charAt(0);
                it.add(pOrder);
            }
        }
        it = bread.listIterator();
        while(it.hasNext()) {
            System.out.print(it.next());
        } 
    }
}