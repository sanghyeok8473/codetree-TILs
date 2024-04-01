import java.util.Scanner;

public class Main {
    public static int t, a, b, cnt = 0;
    public static char[] sn = new char[1001];
    
    public static int nearestS(int x){
        int l = 1000, r = 1000, min = 0;
        for(int i = x ; i < 1001 ; i++ ){
            if(sn[i] == 'S'){
                r = i-x;
                break;
            }
        }
        for(int i = x ; i >= 1 ; i-- ){
            if(sn[i] == 'S'){
                l = x-i;
                break;
            }
        }
        min = Math.min(r, l);
        return min;
    }

    public static int nearestN(int x){
        int l = 1000, r = 1000, min = 0;
        for(int i = x ; i < 1001 ; i++ ){
            if(sn[i] == 'N'){
                r = i-x;
                break;
            }
        }
        for(int i = x ; i >= 1 ; i-- ){
            if(sn[i] == 'N'){
                l = x-i;
                break;
            }
        }
        min = Math.min(r, l);
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        t= sc.nextInt(); a = sc.nextInt(); b = sc.nextInt();

        for(int i = 0 ; i < t ; i++){
            char alphabet = sc.next().charAt(0); int n = sc.nextInt();

            sn[n] = alphabet;
        }

        for( int i = a ; i <= b ; i++ ){
            if(nearestN(i) >= nearestS(i)){
                cnt++;
            }
                
        }
        System.out.print(cnt);

    }
}