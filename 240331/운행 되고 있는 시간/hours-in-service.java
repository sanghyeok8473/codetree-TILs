import java.util.Scanner;

public class Main {
    public static int n, nowWork, workMax = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int[] start = new int[n], end = new int[n];                                                                                                                                                         

        for(int i = 0 ; i < n ; i++){
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }

        for(int i = 0 ; i < n ; i++){ // 제외할 사람
            int[] timeline = new int[1001]; // 0부터 1000까지 0으로 초기화되어있는 타임라인 배열을 선언.
            for(int j = 0 ; j < n ; j++){ // 제외할 사람을 제외한 나머지 사람들
                if(j == i)
                    continue;
                nowWork = 0;
                for(int k = start[j] ; k < end[j] ; k++)
                    timeline[k] = 1;                        // 제외된 사람 이외의 사람이 일하는 시간의 값을 1로 변경. 
                                                    // 운행되고있는 시간이므로, 여기서 timeline[1]은 1시부터 2시까지 일했음을 의미.
                for(int k = 1 ; k < 1001 ; k++)
                    nowWork += timeline[k];                        // timeline이 1일땐 1, 0일땐 0이 더해짐(1이면 한명이라도 운영중)
                
                workMax = Math.max(workMax, nowWork);
            }  
        }

        System.out.print(workMax);


    }
}