import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int[] pairSums = new int[15];
    public static int[] myArray = new int[15];

    public static boolean isEqualArray() {
        Arrays.sort(pairSums);
        Arrays.sort(myArray);

        for(int i = 0; i < 15; i++)
            if(pairSums[i] != myArray[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < 15 ; i++)
            pairSums[i] = sc.nextInt();

        for(int a = 1; a <= 40; a++){
            for(int b = a; b <= 40; b++){
                for(int c = b; c <= 40; c++) {
                    for(int d = c; d <= 40; d++) {
                        myArray[0] = a;
                        myArray[1] = b;
                        myArray[2] = c;
                        myArray[3] = d;
                        myArray[4] = a + b;
                        myArray[5] = b + c;
                        myArray[6] = c + d;
                        myArray[7] = d + a;
                        myArray[8] = a + c;
                        myArray[9] = b + d;
                        myArray[10] = a + b + c;
                        myArray[11] = a + b + d;
                        myArray[12] = a + c + d;
                        myArray[13] = b + c + d;
                        myArray[14] = a + b + c + d;
                        if(isEqualArray())
                            System.out.println(a + " " + b + " " + c + " " + d);
                    }
                }
            }
        }
    }
}