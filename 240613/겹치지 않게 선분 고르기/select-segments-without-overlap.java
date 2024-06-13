import java.util.*;

class Pair {
    int x1, x2;

    public Pair(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Pair[] segments = new Pair[n];

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segments[i] = new Pair(x1, x2);
        }

        Arrays.sort(segments, Comparator.comparingInt(a -> a.x2));

        int count = 0;
        int lastEnd = 0;

        for (Pair segment : segments) {
            if (segment.x1 > lastEnd) {
                count++;
                lastEnd = segment.x2;
            }
        }

        System.out.println(count);
    }
}