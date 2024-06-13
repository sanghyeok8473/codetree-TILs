import java.util.*;

class Pair{
    int x1, x2;

    public Pair(int x1, int x2){
        this.x1 = x1;
        this.x2 = x2;
    }
};

public class Main {
    public static int n, maxCnt = 1, nowCnt;
    public static int[] x1;
    public static int[] x2;
    public static ArrayList<Pair> x1x2;

    public static boolean checkPossible(){  // 현재 배열이 모두 겹치지 않는 선분으로만 이루어져있는지 판단
        for(int now = 0 ; now < x1x2.size() - 1 ; now++){
            for(int next = now+1 ; next < x1x2.size() ; next++){
                if(x1x2.get(now).x1 == x1x2.get(next).x1 && x1x2.get(now).x2 == x1x2.get(next).x2){ // 같은 선분을 넣은 조합이면 판단 X
                    return false;
                }
                else if((x1x2.get(next).x1 >= x1x2.get(now).x1 && x1x2.get(next).x1 <= x1x2.get(now).x2) || (x1x2.get(next).x2 >= x1x2.get(now).x1 && x1x2.get(next).x2 <= x1x2.get(now).x2) || (x1x2.get(next).x1 <= x1x2.get(now).x1 && x1x2.get(next).x2 >= x1x2.get(now).x2) || (x1x2.get(now).x1 <= x1x2.get(next).x1 && x1x2.get(now).x2 >= x1x2.get(next).x2)){    // 겹치는 조건 : 한 선분의 두 끝점 중 하나라도 다른 선분의 사이에 들어가면 겹침.
                    return false;
                }
            }
        }
        return true;
    }
    //해결 방법 : 재귀를 이용해 모든 선택의 가짓수를 만들고, 겹치는 부분이 하나도 없는지 체크. 없으면 그 size를 Math.max에 넣어 최대값을 구함.
    public static void findMaxcnt(int cnt){
        if(cnt == nowCnt){
            if(checkPossible())
                maxCnt = Math.max(maxCnt, x1x2.size());
            return;
        }

        for(int i = 0 ; i < n ; i++){
            x1x2.add(new Pair(x1[i], x2[i]));
            findMaxcnt(cnt + 1);
            x1x2.remove(x1x2.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); x1 = new int[n]; x2 = new int[n];

        for(int i = 0 ; i < n ; i++){
            int now1 = sc.nextInt();
            int now2 = sc.nextInt();
            x1[i] = now1;
            x2[i] = now2;
        }
        if(n==1){
            System.out.print(1);
            System.exit(0);
        }
        x1x2 = new ArrayList<>();
        for(nowCnt = 2 ; nowCnt <= n ; nowCnt++){    // findMaxCnt : cnt라는 숫자를 주었을때, cnt만큼의 개수를 가지는 조합을 만들어보고, 겹치지 않는지 판단함.
            findMaxcnt(0);
        }
        System.out.print(maxCnt);
    }

    public static void print(){
        for(int i = 0 ; i < x1x2.size() ; i++){
            System.out.println(x1x2.get(i).x1 + " " + x1x2.get(i).x2);
        }
        System.out.println();
    }
}