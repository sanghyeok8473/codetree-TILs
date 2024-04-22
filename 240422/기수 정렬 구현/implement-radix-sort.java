import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static int returnK(int x){   // 자릿수 반환함수
        if(x<10)
            return 1;
    
        return 1+returnK(x/10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = 0, max = 0;
        int[] arr = new int[n];

        for(int i = 0 ; i < n ; i++)
            arr[i] = sc.nextInt();
        
        for(int pos = 0 ; pos < 6 ; pos++){    // 일의 자리부터 비교
            ArrayList<Integer>[] new_arr = new ArrayList[10];
            for(int i = 0 ; i < 10 ; i++)
                new_arr[i] = new ArrayList<>();
            
            int nowPos = (int)Math.pow(10,pos);
            for(int i = 0 ; i < n ; i++){
                int nowNum = (arr[i] / nowPos )%10;          // 현재 위치의 숫자 추출
                new_arr[nowNum].add(arr[i]);
            } // 여기까지 하면 해당 자리를 기준으로 기수 정렬 끝, 이제 arr을 업데이트 해줄 차례

            int idx = 0;
            for(int i = 0 ; i < 10 ; i++){
                for(int j = 0 ; j < new_arr[i].size() ; j++){
                    arr[idx] = new_arr[i].get(j);
                    idx++;
                }
            }
        }



        for(int i = 0 ; i < n ; i++)
            System.out.print(arr[i]+" ");
    }
}