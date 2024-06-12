import java.util.*;

public class Main {
    public static int n, k, cnt = 0;
    public static ArrayList<Integer> answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        answer = new ArrayList<>();

        choose(1);
        System.out.print(cnt);
    }

    public static boolean checkBeauty(){ // 1이상 4이하의 숫자로만 이루어져 있으면서, 정확히 해당 숫자만큼 연달아 같은 숫자가 나오는 숫자인지 여부를 체크
        int idx = 0, nowNum = answer.get(0);

        while( idx <= answer.size()-1 ){
            if( idx + answer.get(idx) > answer.size())
                return false;
            nowNum = answer.get(idx);
            for(int i = idx ; i < idx + nowNum ; i++){
                if(answer.get(i) != nowNum || answer.get(i) > 4)
                    return false;
            }
            idx += nowNum;
        }
        return true; 
    }

    public static void choose(int currNum){
        if(answer.size() == n){ // 지우기 전에, 출력 대신 아름다운 수인지 여부를 판단
            if(checkBeauty()){
                cnt++;
            }
            return;
        }

        for(int i = 1 ; i <= n ; i++){
            answer.add(i);
            choose(i);
            answer.remove(answer.size()-1);
        }
    }

    public static void print(){
        for(int i = 0 ; i < answer.size() ; i++){
            System.out.print(answer.get(i)+" ");
        }
        System.out.println();
    }
}