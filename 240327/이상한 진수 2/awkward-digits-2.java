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

        for(int i = 0 ; i < len ; i++){
            if(number[i] == 0){
                number[i] = 1;
                break;
            }
            if(i==len-1){
                sum--;
            }

        }

        for(int i = 0 ; i < len ; i++){
            sum = (sum*2) + number[i];
        }
        if(sum!=1)
            System.out.print(sum);
        else
            System.out.print(0);
    }
}