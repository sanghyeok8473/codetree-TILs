import java.util.Scanner;

public class Main {
    public static int judgmentMax(){
        int max = -1, nowSum1, nowSum2, firstX, firstStart, firstEnd;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n-2 ; j++){
                nowSum1 = (arr[i][j] + arr[i][j+1] + arr[i][j+2]);
                firstX = i; firstStart = j; firstEnd = j+2;       // 첫 격자는 범위를 벗어나지만 않는다면 크게 제한은 없음.

                for(int k = 0 ; k < n ; k++){
                    for(int l = 0 ; l < n-2 ; l++){
                        nowSum2 = 0;
                        if(k != firstX){                                   // 첫 번째 격자와 행이 다르면 제한이 없음.
                            nowSum2 = (arr[k][l] + arr[k][l+1] + arr[k][l+2]); 
                        }
                        else if(n >= 6){ //격자 크기가 6보다 작으면 두 격자가 겹치지 않고 같은 줄에 존재할 수가 없음.
                            if(l <= firstStart - 3 || l > firstEnd){
                                nowSum2 = (arr[k][l] + arr[k][l+1] + arr[k][l+2]);  // 두 번재 격자는 첫 번째 격자와 행이 같을때에만 제한이생김.(겹치면 안됨)
                            }   
                        }
                        max = Math.max(max, (nowSum1 + nowSum2));
                    }
                }
            }
            
        } 

        


        return max;
    }

    


    public static int[][] arr = new int[20][20];
    public static int n;
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                arr[i][j] = sc.nextInt();
            }
        } // 판 입력

        System.out.print(judgmentMax());
    }
}