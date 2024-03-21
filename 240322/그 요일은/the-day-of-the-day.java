import java.util.Scanner;

public class Main {
    public static int days(int m, int d){
        int totalDays = 0;
        int[] date = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for( int i = 1 ; i < m ; i++){
            totalDays += date[i];
        }
        totalDays += d;

        return totalDays;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();
        String A = sc.next();
        //                            0      1      2     3       4      5      6
        String[] day = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

        int elapsed = days(m2, d2) - days(m1, d1);

        int idx = 0;

        for( int i = 0 ; i < 7 ; i++){
            if(day[i].equals(A))
                idx = i;
        } // 입력받은 요일의 위치를 구함

        if( elapsed < idx )
            System.out.print(0);
        else{
            System.out.print((elapsed-idx)/7+1);
        }
    }
}