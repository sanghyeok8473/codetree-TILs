import java.util.Arrays;
import java.util.Scanner;

class Dist implements Comparable<Dist>{
    int x, y, n;

    public Dist(int x, int y, int n){
        this.x = x;
        this.y = y;
        this.n = n;
    }

    @Override
    public int compareTo(Dist dist){
        int thisD = 0;
        int distD = 0;

        thisD = Math.abs(this.x) + Math.abs(this.y);
        distD = Math.abs(dist.x) + Math.abs(dist.y);

        return thisD - distD;
    }
}; 

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

       Dist[] dists = new Dist[n];

        for(int i = 0 ; i < n ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            dists[i] = new Dist(x, y, i+1);
        }

        Arrays.sort(dists);

        for(int i = 0; i < n ; i++){
            System.out.println(dists[i].n);
        }
    }
}