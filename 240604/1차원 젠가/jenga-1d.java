import java.util.Scanner;
import java.util.*;

public class Main {
    public static int n, s1, e1, s2, e2, cnt;
    public static int[] block, temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        n = sc.nextInt(); block = new int[n];
        for(int i = 0 ; i < n ; i++)
            block[i] = sc.nextInt();
        s1 = sc.nextInt(); e1 = sc.nextInt(); s2 = sc.nextInt(); e2 = sc.nextInt();
        s1--; e1--; s2--; e2--;     // 입력 파트

        cnt = n - ((e1-s1+1) + (e2-s2+1));

        removeBlock(s1, e1, n);
        removeBlock(s2, e2, n - (e1-s1+1));

        System.out.println(cnt);
        for(int i = 0 ; i < cnt ; i++){
            System.out.println(block[i]);
        }
    }
    public static void removeBlock(int s, int e, int c){
        for(int i = s ; i <= e ; i++){
            block[i] = 0;
        }
        int tempIdx = 0;
        temp = new int[c];

        for(int i = 0 ; i < c ; i++){
            if(block[i] != 0){
                temp[tempIdx] = block[i];
                tempIdx++;
            }
        }
        copyArr(c - (e - s + 1));
    }

    public static void copyArr(int size){
        block = new int[size];
        for(int i = 0 ; i < size ; i++){
            block[i] = temp[i];
        }
    }
    
}