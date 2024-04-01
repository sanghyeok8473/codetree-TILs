import java.util.Scanner;
import java.util.Arrays;

class Cheese implements Comparable<Cheese>{
    int p; int m; int t;

    public Cheese(int p, int m, int t){
        this.p = p;
        this.m = m;
        this.t = t;
    }

    @Override
    public int compareTo(Cheese cheese){
        if(this.t == cheese.t && this.m == cheese.m)
            return this.p - cheese.p;   // 치즈 번호와 시간이 모두 같으면 사람의 번호를 오름차순으로 정렬
        else if(this.m == cheese.m)
            return this.t - cheese.t; // 치즈 번호가 같으면 시간순으로 오름차순 정렬
        else
            return this.m - cheese.m; // 치즈 번호순으로 오름차순으로 정렬.
    }
};

class Report implements Comparable<Report>{
    int p; int t;

    public Report(int p, int t){
        this.p = p;
        this.t = t;
    }

    @Override
    public int compareTo(Report report){
        return this.t - report.t;        // 시간순으로 오름차순 정렬
    }
};
// 약의 최대 개수 : 특정 치즈가 상한 치즈일 가능성이 있을 때, 그 치즈를 먹은 모든 사람의 합
public class Main {
    public static int getCnt(int m, Cheese[] cheese){
        int first = 0, end = 0;
        for(int i = 0 ; i < d ; i++){
            if(cheese[i].m == m){
                first = i; break;
            }
        }
        for(int i = d-1 ; i >= 0 ; i--){
            if(cheese[i].m == m){
                end = i; break;
            }
        }
        int cnt = end - first + 1;              // 한 사람이 같은 치즈를 여러번 먹지 않았으면 이 값이 정답.
        int dupCnt = 0;
        for(int i = first ; i < end ; i++){    // m번 치즈인 범위의 cheese class 값에서만 계산
            for(int j = i+1 ; j <= end ; j++){
                if(cheese[i].p == cheese[j].p)
                    dupCnt++;
            }
        }

        return cnt - dupCnt;
    }

    public static int n, m, d, s, nowCal, nowCnt = 0, max = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); m = sc.nextInt(); d = sc.nextInt(); s = sc.nextInt(); 

        Cheese[] cheese = new Cheese[d];
        Report[] report = new Report[s];                                                                                                                                

        for(int i = 0 ; i < d ; i++){
            int p = sc.nextInt();
            int m = sc.nextInt();
            int t = sc.nextInt();
            cheese[i] = new Cheese(p, m, t);
        }
        for(int i = 0 ; i < s ; i++){
            int p = sc.nextInt();
            int t = sc.nextInt();
            report[i] = new Report(p, t);
        }
        // 입력 파트 끝
        Arrays.sort(cheese); // 사건을 치즈의 번호순으로 정렬(같으면 시간순으로 정렬)
        Arrays.sort(report); // 기록을 시간순으로 정렬

        // 기록된 사람 중 한명이라도 먹지 않았거나, 아프기 전에 먹지 않았으면 상한 치즈가 아님.
        // 기록된 사람들이 모두 먹었고, 전원이 아파지기 전에 먹었다고 기록되어있으면 상한치즈일 수 있음.

        for(int i = 1 ; i <= m ; i++){ // 각 치즈에 대해 상한 치즈일 가능성 체크
            boolean none = false;
            for(int k = 0 ; k < s ; k++){
                for(int j = 0 ; j < d ; j++){ 
                    if(cheese[j].m == i){
                        if(report[k].p == cheese[j].p)
                            break;
                        if(j == d-1 || cheese[j+1].m != i){  // 여기까지 왔다는건 report에 있는 사람이 현재 치즈에 없다는 뜻.
                            none = true;
                            break;
                        }
                    }
                }
            }
            if(none == true) // report에 있는 사람이 현재 치즈를 먹은 적이 없다면 상한치즈일 수 없음.
                continue;
            for(int k = 0 ; k < s ; k++){
                for(int j = 0 ; j < d ; j++){
                    if(cheese[j].m == i && cheese[j].p == report[k].p){
                        if(cheese[j].t < report[k].t)
                            break;
                        else{
                             none = true;
                             break;
                        }
                    }
                }
                int cnt;
                if(none == true) // report에 있는 사람이 모두 현재 치즈를 먹었으나 더 아픈 이후에 먹음
                    continue;
                else{
                    cnt = getCnt(i, cheese); // 상한 치즈일 가능성이 있을 때는 먹은 모든사람이 아플 수 있음.                
                }               // 같은 치즈를 같은 사람이 여러번 먹었을 수 있으므로 한 번만 세줘야됨...                          
                max = Math.max(max, cnt);
            }
        }
        if(m==1)
            System.out.print(n);
        else
            System.out.print(max);
    }
}