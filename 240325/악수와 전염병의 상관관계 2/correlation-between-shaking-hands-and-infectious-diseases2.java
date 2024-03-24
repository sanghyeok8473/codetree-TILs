import java.util.Scanner;
import java.util.Arrays;

class Timeline implements Comparable<Timeline>{
    int t;
    int a;
    int b;

    public Timeline(int t, int a, int b){
        this.t = t;
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Timeline timeline){
        return this.t - timeline.t;
    }
};

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int p = sc.nextInt();
        int x = sc.nextInt(); // x = T

        int[] men = new int[n+1]; // 사람들의 감염여부를 판단하는 배열
        int[] jeon = new int[n+1]; // 남은 전염횟수를 판단해주는 배열; 처음엔 전부 0임.
        men[p] = 1; // 첫 감염자
        jeon[p] = k; // 첫 감염자의 남은 전염횟수

        Timeline[] time = new Timeline[x];


        for(int i = 0 ; i < x ; i++){
            int t = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            time[i] = new Timeline(t, a, b);            
        }

        Arrays.sort(time); // 시간순으로 정렬까진 완료.

        for(int i = 0 ; i < x ; i++){ // 시간순으로 확인할 차례 경우의 수는 4가지. 둘다 아닐때, 한쪽만 감염일때, 둘다 감염일때
            if(men[time[i].a] == 0 && men[time[i].b] == 0) // 악수하는 사람 둘다 감염자가 아닌 경우
                continue;
            else if( men[time[i].a] == 1 && men[time[i].b] == 1 ){ // 악수하는 사람 둘다 감염자일 때는 남은 전염횟수만 줄이면 됨
                jeon[time[i].a]--;
                jeon[time[i].b]--;
            }
            else if(men[time[i].a] == 1 && men[time[i].b] == 0){ // a만 감염자이고 b가 비감염자일 때
                if(jeon[time[i].a] > 0){ // a의 전염횟수가 남아있을 때만
                    jeon[time[i].a]--; // a의 남은 전염횟수를 줄이고
                    men[time[i].b] = 1; // b 감염자 선언
                    jeon[time[i].b] = k; // b의 남은 전염횟수를 k번으로 선언.
                }                
            }
            else if(men[time[i].a] == 0 && men[time[i].b] == 1){ // b만 감염자이고 a가 비감염자일 때
                if(jeon[time[i].b] > 0){ // b의 전염횟수가 남아있을 때만
                    jeon[time[i].b]--; // b의 남은 전염횟수를 줄이고
                    men[time[i].a] = 1; // a 감염자 선언
                    jeon[time[i].a] = k; // a의 남은 전염횟수를 k번으로 선언.
                }                
            }
        }
        for(int i = 1 ; i < n+1 ; i++)
            System.out.print(men[i]);



        
        
            
    }
}