import java.util.Scanner;

public class Main {
    public static boolean check369(int n){
            
        String s = Integer.toString(n);

        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '3'|| s.charAt(i) == '6' || s.charAt(i) == '9'){
                return true;
            }  
        }

        return false;

    }   

    public static int count369(int a, int b){

        int cnt = 0;

        for( int i = a ; i <= b ; i++){
            if(check369(i) i%3==0)
                cnt++;
        }
            
        return cnt;
    }   

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.print(count369(a,b));

    }
}