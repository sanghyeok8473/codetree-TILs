import java.util.Scanner;
import java.util.Arrays;

class product {
    String name;
    int price;

    public product(){
        this.name = "codetree";
        this.price = 50;
    }

    public product(String n, int p){
        this.name = n;
        this.price = p;
    }
};

public class Main {
    public static int n;
    public static int[] a  = new int[101];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.next();
        int s = sc.nextInt();

        product P1 = new product();
        product P2 = new product(n, s);

        
        System.out.println("product "+P1.price+" is "+P1.name);
        System.out.println("product "+P2.price+" is "+P2.name);
    }
}