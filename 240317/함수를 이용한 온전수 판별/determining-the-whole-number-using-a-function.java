import java.util.Scanner;

public class Main {
    public static boolean Onjeon(int a){
        if(a%2==0 || a%10==5 || (a%3==0 && a%9!=0)){
                return false;
        }

        return true;

    }

    

    


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        // System.out.print(cntOnjeon(a, b));
        int cnt = 0; 

        for(int i = a ; i<= b; i++){
            if(Onjeon(i))
                cnt++;

        }

        System.out.print(cnt);




    }

    /*public static int cntOnjeon(int a, int b){

        int cnt = 0;

        for(int i = a ; i<= b; i++){
            if(i%2==0 || i%10==5 || (i%3==0 && i%9!=0)){
                continue;
            }
            else
                cnt++;
        }

        return cnt;

    }*/
}