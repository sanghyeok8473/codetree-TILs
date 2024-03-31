import java.util.Scanner;

public class Main {
    public static int n, k, nowWork, idx = 0, cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt(); n = sc.nextInt();

        int[] line = new int[n];
        int[][] arr = new int[n+1][n+1];                                                                                                                                                       

        for(int i = 0 ; i < k ; i++){            // 반복 횟수
            if(i==0){
                for(int j = 0 ; j < n ; j++)
                    line[j] = sc.nextInt();

                for(int j = 0 ; j < n-1 ; j++){     // a의 위치
                    for(int k = j+1 ; k < n ; k++){ // b의 위치
                        arr[line[j]][line[k]] = 1;
                    }
                }
            }                                       // 첫 줄에서 나오는 모든 순서쌍 좌표의 값을 1로 변경
            else{
                for(int j = 0 ; j < n ; j++)
                    line[j] = sc.nextInt();
                
                for(int j = 0 ; j < n ; j++){       // a의 위치
                    for(int k = j+1 ; k < n ; k++){ // b의 위치
                        for(int x = 1 ; x <= n ; x++){
                            for(int y = 1 ; y <= n ; y++){
                                if(arr[x][y] == 1 && (y == line[j] && x == line[k]))  // 이전까지는 이 순서쌍이 존재했으나 이번에는 존재하지 않음
                                    arr[x][y] = 0;
                            }  // 이전까지 존재하던 순서쌍이 존재하지 않게 되는 경우는 두 숫자의 위치가 바뀌어 나왔다는 뜻임.
                        }
                    }
                }
            }
            
            
        }
            
        // 2차원 배열을 선언하고, i가 0일때 생기는 순서쌍의 값이 의미하는 2차원배열의 값을 1로 변경
        // 첫 줄에서 나오는 모든 순서쌍을 배열에 넣은 이후에는 기존 순서쌍이 1인데 다음 줄에서 이 순서쌍이 존재할 수 없으면 그 값을 0으로 변경해야함.
        // 이 과정을 반복했을 때 2차원 배열에 남아있는 1의 개수가 서로다른 순서쌍의 개수임

        for(int x = 1 ; x <= n ; x++){
            for(int y = 1 ; y <= n ; y++){
                if(arr[x][y] == 1)
                    cnt++;
            }
        }
        
        System.out.print(cnt);


    }
}