import java.util.Scanner;
import java.util.Arrays;

class id_level {
    String id;
    int lv;
    
    public id_level(){
        this.id = "codetree";
        this.lv = 10;
    }

    public id_level(String id, int lv){
        this.id = id;
        this.lv = lv;
    }
};

public class Main {
    public static int n;
    public static int[] a  = new int[101];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String id = sc.next();
        int lv = sc.nextInt();

        id_level user1 = new id_level();
        id_level user2 = new id_level(id, lv);
        System.out.println("user " + user1.id +" lv " + user1.lv);
        System.out.print("user " + user2.id +" lv " + user2.lv);
    }
}