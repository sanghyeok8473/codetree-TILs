import java.util.Scanner;
import java.util.Arrays;

class Gift implements Comparable<Gift>{
    int p, s;

    public Gift(int p, int s){
        this.p = p;
        this.s = s;
    }

    @Override
    public int compareTo(Gift gift){
        int now = this.p + this.s;
        int next = gift.p + gift.s;
        if(this.s == gift.s)
            return this.p - gift.p;
        if(now == next)
            return this.s - gift.s
        return now - next;
    }
};

public class Main {
    public static int n, b, nowCal, nowCnt = 0, maxCnt = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); b = sc.nextInt();

        // x1이 더 큰데 x2가 더 작아버리거나 x1은 더 작은데 x2는 더 커버리면 겹침.

        int[] pi = new int[n];
        Gift[] gift = new Gift[n];                                                                                                                                           

        for(int i = 0 ; i < n ; i++){
            int p = sc.nextInt();
            int s = sc.nextInt();
            gift[i] = new Gift(p, s);
        }

        Arrays.sort(gift); 

        for(int i = 0 ; i < n ; i++){ // 반값으로 만들 물건의 가격.
            for(int j = 0 ; j < n ; j++)
                pi[j] = gift[j].p;            // 반값으로 만들어 개수를 세본 이후 원래대로 돌려야되기 때문에 똑같은 배열을 하나 만듬.
            
            pi[i] /= 2;         // 오름차순으로 정렬(많이 사려면 가격이 낮은 것 부터 사야하므로)

            nowCal = b; nowCnt = 0;

            for(int j = 0 ; j < n ; j++){
                nowCal -= (pi[j] + gift[j].s);

                if(nowCal>=0)
                    nowCnt++;
                else
                    break;
            }
            maxCnt = Math.max(maxCnt, nowCnt);
        }
        System.out.print(maxCnt);


    }
}