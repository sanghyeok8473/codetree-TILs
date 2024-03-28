import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), cnt = 0;

        String cow = sc.next();

        for(int i = 0 ; i < n-2 ; i++){
            if(cow.charAt(i) == 'C'){
                for(int j = i+1 ; j < n-1 ; j++){
                    if(cow.charAt(j) == 'O'){
                        for(int k = j+1 ; k < n ; k++){
                            if(cow.charAt(k) == 'W'){
                                cnt++;
                            }
                        }
                    }
                }
            } 
        }
        System.out.print(cnt);
    }
}