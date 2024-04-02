import java.util.Scanner;

public class Main {
    public static int n;
    public static int[][] range = new int[10][2];
    
    public static boolean checkPossible(int x){
        for(int i = 0 ; i < n ; i++){ 
            x *= 2;
            if( x < range[i][0] || x > range[i][1] )
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            range[i][0] = sc.nextInt();
            range[i][1] = sc.nextInt();
        }

        for(int i = 1 ; i <= range[0][1]/2; i++){  // 양의 정수이므로 최소값은 1, 처음 주어지는 범위의 최대값을 2로 나눈 값보다 크면 성립이 불가. 
            if(checkPossible(i)){
                System.out.print(i);
                break;
            }  
        }
    }
}