import java.util.Scanner;

public class Main {
    public static int x, y, max = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        x = sc.nextInt(); y = sc.nextInt();

        for(int i = x ; i <= y ; i++){
            int now;
            if(i==10000)
                now = i/10000;
            else if(i <= 9999 && i >= 1000)
                now = i/1000 + (i/100)%10 + (i/10)%10 + i%10; 
            else if(i <= 999 && i>=100)
                now = i/100 +(i/10)%10 +i%10;
            else if(i <= 99 && i >= 10)
                now = i/10 + i%10;
            else
                now = i;
            max = Math.max(now, max);  
        }
        
        System.out.print(max);
    }
}