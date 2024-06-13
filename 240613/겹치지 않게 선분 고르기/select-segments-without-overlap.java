import java.util.*;

public class Main {
    public static int n, maxCnt = 1;
    public static int[] x1;
    public static int[] x2;
    public static ArrayList<Integer> nowX1;
    public static ArrayList<Integer> nowX2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); x1 = new int[n]; x2 = new int[n];

        for(int i = 0 ; i < n ; i++){
            int now1 = sc.nextInt();
            int now2 = sc.nextInt();
            x1[i] = now1;
            x2[i] = now2;
        }

        for(int i = 0 ; i < n-1 ; i++){
            int nowCnt = 1;
            nowX1 = new ArrayList<>(); nowX2 = new ArrayList<>();
            nowX1.add(x1[i]); nowX2.add(x2[i]); // 현재 선분을 일단 추가해둠. // nowX1과 nowX2에는, 겹치지 않는 선분들의 x1과 x2의 값들이 저장될 예정임.
            for(int j = i+1 ; j < n ; j++){
                boolean none = true;
                for(int now = 0 ; now < nowX1.size() ; now++){ // 선분들의 모음에서 새로 추가될 수 있는 선분이 겹치지 않으려면, 모든 선분에 대해 겹치지 않으면 됨.
                    if(nowX1.get(now) <= x2[j] || nowX2.get(now) >= x1[j])    // 현재 선분의 앞이 선분의 끝보다 뒤에 있거나, 현재 선분의 뒤가 선분의 앞보다 앞에 있으면 됨.
                        none = false;                                   // 근데 생각해보니까 이러면 앞에서 엄청 큰 선분이 나와버리면 뒤에가 다 안들어가버리는 문제가 생김.
                }                                                       // 결국 재귀로 하나하나 다 넣어보고 만족하는지 여부를 고르는 수 밖에 없겠네.. 아 못하겠는데 이거
                if(none){
                    nowX1.add(x1[j]);
                    nowX2.add(x2[j]);
                    nowCnt++;
                }
                    
            }
            maxCnt = Math.max(maxCnt, nowCnt);
        }
        System.out.print(maxCnt);
    }
}