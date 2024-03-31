import java.util.Scanner;

public class Main {
    public static int n, nowWork, workMax = Integer.MIN_VALUE, cnt = 0, offset = 1000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        // x1이 더 큰데 x2가 더 작아버리거나 x1은 더 작은데 x2는 더 커버리면 겹침.

        int[] x1 = new int[n], x2 = new int[n], line = new int[2000001];                                                                                                                                                       

        for(int i = 0 ; i < n ; i++){
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n-1 ; i++){ // 비교할 두 선분 중 먼저 나오는 선분
            for(int j = i+1 ; j < n ; j++){ // 비교할 두 선분 중 나중에 나오는 선분
                if((x1[i] > x1[j] && x2[i] < x2[j]) || (x1[i] < x1[j] && x2[i] > x2[j])){
                    line[x1[i]+offset] = 1; line[x1[j]+offset] = 1;
                } // cnt+=2로 하면 한 선분에 두 선분이 겹칠 때 숫자가 달라짐. 그 자리를 나타내는 배열값을 1로 바꿔주는게 나음
            }  
        }

        for(int i = 0 ; i < 2000001 ; i++){
            if(line[i] == 1)
                cnt++;
        }

        System.out.print(cnt);


    }
}