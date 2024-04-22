import java.util.Scanner;

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

        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
            max = Math.max(max, arr[i]); // 가장 큰 값의 자리수 파악
        }
        k = returnK(max);

        for(int pos = 0 ; pos < k ; pos++){    // 일의 자리부터 비교
            int[][] new_arr = new int[10][n];                // 특정 자리수가 모두 같을때 최대 n개가 들어감.
            int nowPos = (int)Math.pow(10,pos);
            for(int i = 0 ; i < n ; i++){
                int nowNum = (arr[i] / nowPos )%10;          // 현재 위치의 숫자 추출
                for(int j = 0 ; j < n ; j++){
                    if(new_arr[nowNum][j] == 0){
                        new_arr[nowNum][j] = arr[i];
                        break;
                    }
                }
            } // 여기까지 하면 해당 자리를 기준으로 기수 정렬 끝, 이제 arr을 업데이트 해줄 차례
            int idx = 0;
            for(int i = 0 ; i < 10 ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(new_arr[i][j] != 0){
                        arr[idx] = new_arr[i][j];
                        idx++;
                    }
                    else
                        break;
                }
            }
        }



        for(int i = 0 ; i < n ; i++)
            System.out.print(arr[i]+" ");
    }
}