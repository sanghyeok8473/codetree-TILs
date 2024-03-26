import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] number = new int[10];

        String num = sc.next();
        int len = num.length();

        for(int i = 0 ; i < len ; i++)
            number[i] = num.charAt(i) - '0'; // 정수형 배열에 2진법숫자를 집어넣음.
        
        int sum = 0;

        if(len == 1 && number[0] == 1){
            System.out.print(0);
            System.exit(0);
        }
        
        boolean allOne = false;

        for(int i = 0 ; i < len ; i++){
            if(number[i] == 0){
                number[i] = 1;
                break;
            }
            if(i==len-1){
                sum--;
                allOne = true;
            }
                
        }

        for(int i = 0 ; i < len ; i++){
            sum = (sum*2) + number[i];
        }
        if(allOne)
            System.out.print(sum-1);
        else
            System.out.print(sum);
    }
}