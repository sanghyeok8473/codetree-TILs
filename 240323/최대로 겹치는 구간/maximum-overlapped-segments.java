import java.util.Scanner;

public class Main {
    //길이가 무한하다면 숫자들부터 받아서 배열에 넣고 배열들의 합을 구하자. 왼쪽 오른쪽 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, a, b, max;

        n = sc.nextInt();

        int[] block = new int[201];

        for(int i = 0 ; i < n ; i++ ){
            a = sc.nextInt();
            b = sc.nextInt();

            for(int j = a+100 ; j < b+100; j++)
                block[j]++;
        }

        max = -1;

        for(int i = 0 ; i < 201 ; i++ ){
            if(max < block[i])
                max = block[i];
        }
        System.out.print(max);

        
    }
}