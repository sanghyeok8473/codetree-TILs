import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int elapsedDate = (a-11)*60*24;
        int elapsedMinute = (b-11)*60;
        int elapsedSecond = (c-11);

        int elapsedtime = elapsedDate + elapsedMinute + elapsedSecond;

        System.out.print(elapsedtime);

    }
}