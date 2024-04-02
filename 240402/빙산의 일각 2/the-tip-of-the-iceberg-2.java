import java.util.Scanner;

public class Main {
    public static int n, cnt = 0, max = 100, min = 1, maxCnt = 0;
    public static int[] h = new int[100], tmp = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            h[i] = sc.nextInt();

            max = Math.max(max, h[i]);
            min = Math.min(min, h[i]);
        }

        for( int k = min ; k <= max ; k++ ){ // 해수면의 높이
            int cnt = 0;

            for( int i = 0 ; i < n ; i++ )
                tmp[i] = h[i];
            for( int i = 0 ; i < n ; i++ )
                tmp[i] -= k;                    // 여러번 반복해야하기에 temp배열에 옮겨 현재 해수면의 높이만큼 다 빼줌.

            for( int i = 0 ; i < n ; i++ ){
                int idx = 0;
                if(tmp[i] > 0){
                    for(int j = i ; j < n ; j++){
                        if(tmp[j+1] <= 0){
                            idx = j;
                            cnt++;
                            break;
                        }
                    }
                    i = idx;
                }
            }  
            maxCnt = Math.max(cnt, maxCnt);
        }
        System.out.print(maxCnt);

    }
}