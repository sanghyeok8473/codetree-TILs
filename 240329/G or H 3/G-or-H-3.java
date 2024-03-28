import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt(), R = 0, max = 0, nowSum;

        int[] arr = new int[n];
        char[] alphabet = new char[n];

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
            alphabet[i] = sc.next().charAt(0);

            R = Math.max(R, arr[i]);
        }

        char[] placed = new char[R+1];

        for(int i = 0 ; i < n ; i++)
            placed[arr[i]] = alphabet[i];

        for(int i = 1 ; i < R + 1 - k ; i++){
            nowSum = 0;
            for(int j = i ; j <= i+k ; j++){
                if(placed[j] == 'G')
                    nowSum += 1;
                else if(placed[j] == 'H')
                    nowSum += 2;
            }
            max = Math.max(max, nowSum);
        }

        System.out.print(max);
    }
}